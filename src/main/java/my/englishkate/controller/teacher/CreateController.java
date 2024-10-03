package my.englishkate.controller.teacher;

import my.englishkate.dto.QuestionCreateDTO;
import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.entity.QuestionEntity;
import my.englishkate.service.QuestionService;
import my.englishkate.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher/create")
public class CreateController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ThemeService themeService;

    @PostMapping("/question")
    public String createQuestion(QuestionCreateDTO createDTO) {
        questionService.create(createDTO);
        return "redirect:/teacher/themes/" + createDTO.getThemeId();
    }

    @PostMapping("/theme")
    public String createTheme(ThemeCreateDTO createDTO) {
        themeService.create(createDTO);
        return "redirect:/teacher/themes";
    }
}
