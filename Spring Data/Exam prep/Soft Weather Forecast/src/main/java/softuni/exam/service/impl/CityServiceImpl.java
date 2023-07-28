package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private static final String CITY_FILE_PATH = "src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITY_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {

        StringBuilder sb = new StringBuilder();

        CityImportDto[] cityImportDtos = gson.fromJson(readCitiesFileContent(), CityImportDto[].class);

        Arrays.stream(cityImportDtos)
                .forEach(cityImportDto -> {
                    if(validationUtil.isValid(cityImportDto) &&
                    cityRepository.findByCityName(cityImportDto.getCityName()).isEmpty()) {
                        City city = modelMapper.map(cityImportDto, City.class);
                        city.setCountry(countryService.findById(cityImportDto.getCountry()));

                        cityRepository.save(city);

                        sb.append(String.format("Successfully imported city %s - %s",city.getCityName(), city.getPopulation()))
                                .append(System.lineSeparator());

                    }else {
                        sb.append("Invalid city").append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }
}
