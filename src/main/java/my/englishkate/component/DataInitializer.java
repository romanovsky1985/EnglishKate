package my.englishkate.component;

import my.englishkate.dto.QuestionCreateDTO;
import my.englishkate.dto.StudentCreateDTO;
import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.entity.StudentEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.service.QuestionService;
import my.englishkate.service.StudentService;
import my.englishkate.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private ThemeService themeService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private StudentService studentService;

    @Override
    public void run(ApplicationArguments args) {
        ThemeEntity animalTheme = themeService.create(
                new ThemeCreateDTO("Набор слов \"животные\"", "Укажите перевод:"));
        questionService.create(new QuestionCreateDTO("cat", "кошка", animalTheme.getId()));
        questionService.create(new QuestionCreateDTO("dog", "собака", animalTheme.getId()));
        questionService.create(new QuestionCreateDTO("mouse", "мышь", animalTheme.getId()));
        questionService.create(new QuestionCreateDTO("lion", "лев", animalTheme.getId()));
        questionService.create(new QuestionCreateDTO("pig", "свинья", animalTheme.getId()));


        ThemeEntity colorTheme = themeService.create(
                new ThemeCreateDTO("Набор слов \"цвета\"", "Укажите перевод:"));
        questionService.create(new QuestionCreateDTO("blue", "синий", colorTheme.getId()));
        questionService.create(new QuestionCreateDTO("red", "красный", colorTheme.getId()));
        questionService.create(new QuestionCreateDTO("yellow", "желтый", colorTheme.getId()));
        questionService.create(new QuestionCreateDTO("green", "зеленый", colorTheme.getId()));
        questionService.create(new QuestionCreateDTO("white", "белый", colorTheme.getId()));

        StudentEntity student = studentService.create(
                new StudentCreateDTO("Иван", "Иванов", "qwerty", "test", true));
        studentService.addTheme(student.getId(), animalTheme.getId());
        studentService.addTheme(student.getId(), colorTheme.getId());
    }
}
