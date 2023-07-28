package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTY_FILE_PATH = "src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        CountryImportDto[] countryImportDtos = gson.fromJson(readCountriesFromFile(), CountryImportDto[].class);

        Arrays.stream(countryImportDtos)
                .forEach(countryImportDto -> {
                    if(validationUtil.isValid(countryImportDto) &&
                    countryRepository.findByCountryName(countryImportDto.getCountryName()).isEmpty()) {
                        Country country = modelMapper.map(countryImportDto, Country.class);
                        countryRepository.save(country);

                        sb.append(String.format("Successfully imported country %s - %s", country.getCountryName(), country.getCurrency()))
                                .append(System.lineSeparator());
                    }else {
                        sb.append("Invalid country").append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }

    @Override
    public Country findById(Long country) {
        return countryRepository.findById(country).get();
    }
}
