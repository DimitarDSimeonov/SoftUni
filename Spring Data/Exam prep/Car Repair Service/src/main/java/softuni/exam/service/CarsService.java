package softuni.exam.service;


import softuni.exam.models.entity.Car;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface CarsService {

    boolean areImported();

    String readCarsFromFile() throws IOException;

    String importCars() throws IOException, JAXBException;

    Car findById(Long id);
}
