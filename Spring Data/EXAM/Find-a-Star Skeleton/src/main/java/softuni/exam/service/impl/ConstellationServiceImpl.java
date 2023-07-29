package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private static final String CONSTELLATION_FILE_PATH = "src/main/resources/files/json/constellations.json";

    private final ConstellationRepository constellationRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATION_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder sb = new StringBuilder();

        ConstellationImportDto[] constellationImportDtos = gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class);

        Arrays.stream(constellationImportDtos)
                .forEach(constellationImportDto -> {
                    if(validationUtil.isValid(constellationImportDto) &&
                    constellationRepository.findByName(constellationImportDto.getName()).isEmpty()) {
                        Constellation constellation = modelMapper.map(constellationImportDto, Constellation.class);

                        constellationRepository.save(constellation);

                        sb.append(String.format("Successfully imported constellation %s - %s", constellation.getName(), constellation.getDescription()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append("Invalid constellation").append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }

    @Override
    public Constellation findById(Long constellation) {
        return constellationRepository.findById(constellation).get();
    }
}
