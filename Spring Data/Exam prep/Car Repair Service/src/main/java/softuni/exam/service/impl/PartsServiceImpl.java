package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartImportDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Arrays;

@Service
public class PartsServiceImpl implements PartsService {

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";
    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));

    }

    @Override
    public String importParts() throws IOException {
        StringBuilder sb = new StringBuilder();

        PartImportDto[] partImportDtos = gson.fromJson(readPartsFileContent(),PartImportDto[].class);

        Arrays.stream(partImportDtos).forEach(partImportDto -> {
            if(validationUtil.isValid(partImportDto) &&
            partsRepository.findByPartName(partImportDto.getPartName()).isEmpty()) {
                Part part = modelMapper.map(partImportDto, Part.class);
                partsRepository.save(part);

                sb.append(String.format("Successfully imported part %s - %s", part.getPartName(), part.getPrice()))
                        .append(System.lineSeparator());
            }else {
                sb.append("Invalid part").append(System.lineSeparator());
            }
        });
        return sb.toString().trim();
    }

    @Override
    public Part findById(Long id) {
        return partsRepository.findById(id).get();
    }
}
