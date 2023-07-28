package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportRootDto;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {

    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final CityService cityService;

    public ForecastServiceImpl(ForecastRepository forecastRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, CityService cityService) {
        this.forecastRepository = forecastRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.cityService = cityService;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        ForecastImportRootDto forecastImportRootDto = xmlParser.fromFile(FORECAST_FILE_PATH, ForecastImportRootDto.class);

        forecastImportRootDto.getForecasts()
                .forEach(forecastImportDto -> {
                    if(validationUtil.isValid(forecastImportDto) &&
                    forecastRepository.findByDayOfWeekAndCityId(forecastImportDto.getDayOfWeek(),forecastImportDto.getCity()).isEmpty()) {

                        Forecast forecast = modelMapper.map(forecastImportDto, Forecast.class);
                        forecast.setCity(cityService.findById(forecastImportDto.getCity()).get());

                        forecastRepository.save(forecast);

                        sb.append(String.format("Successfully import forecast %s - %s",forecast.getDayOfWeek(), forecast.getMaxTemperature()))
                                .append(System.lineSeparator());
                    }else {
                        sb.append("Invalid forecast")
                                .append(System.lineSeparator());
                    }
                });
        return sb.toString().trim();
    }

    @Override
    public String exportForecasts() {

        StringBuilder sb = new StringBuilder();

        List<Forecast> forecasts = forecastRepository.findAllToExport();
        forecasts.forEach(forecast -> {
            sb.append(String.format("City: %s:", forecast.getCity().getCityName()))
                    .append(System.lineSeparator())
                    .append(String.format("-min temperature: %.2f", forecast.getMinTemperature()))
                    .append(System.lineSeparator())
                    .append(String.format("--min temperature: %.2f", forecast.getMaxTemperature()))
                    .append(System.lineSeparator())
                    .append(String.format("---sunrise: %s", forecast.getSunrise()))
                    .append(System.lineSeparator())
                    .append(String.format("----sunset: %s", forecast.getSunset()))
                    .append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
