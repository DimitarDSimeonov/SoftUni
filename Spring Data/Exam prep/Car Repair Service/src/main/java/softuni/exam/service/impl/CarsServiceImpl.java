package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CarsServiceImpl(CarsRepository carsRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        CarImportRootDto carImportRootDto = xmlParser.fromFile(CARS_FILE_PATH, CarImportRootDto.class);

        carImportRootDto.getCars().forEach(carImportDto -> {

            if (validationUtil.isValid(carImportDto) &&
            carsRepository.findByPlateNumber(carImportDto.getPlateNumber()).isEmpty()) {

                Car car = modelMapper.map(carImportDto, Car.class);
                carsRepository.save(car);
                sb.append(String.format("Successfully imported car %s - %s",car.getCarMake(), car.getCarModel()))
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid car").append(System.lineSeparator());
            }
        });
        return sb.toString().trim();
    }

    @Override
    public Car findById(Long id) {
        return carsRepository.findById(id).get();
    }
}
