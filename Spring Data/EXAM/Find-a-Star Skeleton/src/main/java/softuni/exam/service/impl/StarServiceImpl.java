package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.apache.tomcat.jni.Local;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class StarServiceImpl implements StarService {

    private static final String  STAR_FILE_PATH = "src/main/resources/files/json/stars.json";

    private final StarRepository starRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ConstellationService constellationService;

    public StarServiceImpl(StarRepository starRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson, ConstellationService constellationService) {
        this.starRepository = starRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.constellationService = constellationService;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STAR_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {

        StringBuilder sb = new StringBuilder();

        StarImportDto[] starImportDtos = gson.fromJson(readStarsFileContent(), StarImportDto[].class);

        Arrays.stream(starImportDtos)
                .forEach(starImportDto -> {
                    if(validationUtil.isValid(starImportDto) &&
                    starRepository.findByName(starImportDto.getName()).isEmpty()) {

                        Star star = modelMapper.map(starImportDto, Star.class);

                        star.setConstellation(constellationService.findById(starImportDto.getConstellation()));

                        starRepository.save(star);

                        sb.append(String.format(Locale.US,"Successfully imported star %s - %.2f light years", star.getName(), star.getLightYears()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append("Invalid star").append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }

    @Override
    public String exportStars() {
        StringBuilder sb = new StringBuilder();

        List<Star> stars = starRepository.findStarToExport();

        stars.forEach(star -> {
            sb.append(String.format("Star: %s",star.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(Locale.US, "   *Distance: %.2f light years", star.getLightYears()))
                    .append(System.lineSeparator())
                    .append(String.format("   **Description: %s", star.getDescription()))
                    .append(System.lineSeparator())
                    .append(String.format("   ***Constellation: %s", star.getConstellation().getName()))
                    .append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    @Override
    public Optional<Star> findById(Long observingStar) {
        return starRepository.findById(observingStar);
    }
}
