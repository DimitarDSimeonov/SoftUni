package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskImportRootDto;
import softuni.exam.models.entity.CarType;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.CarsService;
import softuni.exam.service.MechanicsService;
import softuni.exam.service.PartsService;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TasksRepository tasksRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final MechanicsService mechanicsService;
    private final CarsService carsService;
    private final PartsService partsService;

    public TasksServiceImpl(TasksRepository tasksRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, MechanicsService mechanicsService, CarsService carsService, PartsService partsService) {
        this.tasksRepository = tasksRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.mechanicsService = mechanicsService;
        this.carsService = carsService;
        this.partsService = partsService;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        TaskImportRootDto taskImportRootDto = xmlParser.fromFile(TASKS_FILE_PATH, TaskImportRootDto.class);

        taskImportRootDto.getTasks().forEach(taskImportDto -> {

            if (validationUtil.isValid(taskImportDto) &&
            mechanicsService.findByFirstName(taskImportDto.getMechanic().getFirstName()).isPresent()) {

                Task task = modelMapper.map(taskImportDto, Task.class);

                task.setDate(LocalDateTime.parse(taskImportDto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                task.setCar(carsService.findById(taskImportDto.getCar().getId()));
                task.setMechanic(mechanicsService.findByFirstName(taskImportDto.getMechanic().getFirstName()).get());
                task.setPart(partsService.findById(taskImportDto.getPart().getId()));

                tasksRepository.save(task);

                sb.append(String.format("Successfully imported task %s", task.getPrice()))
                        .append(System.lineSeparator());
            }else {
                sb.append("Invalid task").append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {

        List<Task> tasks = tasksRepository.findAllByCarTypeCoupeOrderByPriceDesc();

        StringBuilder sb = new StringBuilder();

        tasks.forEach(task -> {
            sb.append(String.format("Car %s %s with %skm",task.getCar().getCarMake(), task.getCar().getCarModel(), task.getCar().getKilometres()))
                    .append(System.lineSeparator())
                    .append(String.format("-Mechanic: %s %s - task №%s:",task.getMechanic().getFirstName(), task.getMechanic().getLastName(), task.getId()))
                    .append(System.lineSeparator())
                    .append(String.format(" --Engine: %s", task.getCar().getEngine()))
                    .append(System.lineSeparator())
                    .append(String.format("---Price: %s$",task.getPrice()))
                    .append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
