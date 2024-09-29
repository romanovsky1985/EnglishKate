package my.englishkate.component;

import my.englishkate.dto.QuestionCreateDTO;
import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.service.QuestionService;
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

    @Override
    public void run(ApplicationArguments args) {
        themeService.create(new ThemeCreateDTO("Предлоги времени", "Укажите пропущенный предлог"));
        ThemeEntity colorTheme = themeService.create(
                new ThemeCreateDTO("Набор английских цветов", "Укажите русский перевод"));
        questionService.create(new QuestionCreateDTO("blue", "синий", colorTheme.getId()));
        questionService.create(new QuestionCreateDTO("red", "красный", colorTheme.getId()));
    }
}
