package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private static final String ASTRONOMER_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";

    private final AstronomerRepository astronomerRepository;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final StarService starService;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, ValidationUtil validationUtil, XmlParser xmlParser, ModelMapper modelMapper, StarService starService) {
        this.astronomerRepository = astronomerRepository;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.starService = starService;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMER_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        AstronomerImportRootDto astronomerImportRootDto = xmlParser.fromFile(ASTRONOMER_FILE_PATH, AstronomerImportRootDto.class);

        astronomerImportRootDto.getAstronomers()
                .forEach(astronomerImportDto -> {
                    if (validationUtil.isValid(astronomerImportDto) &&
                            astronomerRepository.findByFistNameLastName(astronomerImportDto.getFirstName(), astronomerImportDto.getLastName()).isEmpty() &&
                    starService.findById(astronomerImportDto.getObservingStar()).isPresent()) {

                        Astronomer astronomer = modelMapper.map(astronomerImportDto, Astronomer.class);

                        astronomer.setObservingStar(starService.findById(astronomerImportDto.getObservingStar()).get());

                        if (astronomerImportDto.getBirthday() != null) {
                            astronomer.setBirthday(LocalDate.parse(astronomerImportDto.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        }

                        astronomerRepository.save(astronomer);

                        sb.append(String.format(Locale.US,"Successfully imported astronomer %s %s - %.2f",
                                astronomer.getFirstName(), astronomer.getLastName(), astronomer.getAverageObservationHours()))
                                .append(System.lineSeparator());
                    } else {
                        sb.append("Invalid astronomer")
                                .append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }
}
