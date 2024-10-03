package my.englishkate.controller.teacher;

import my.englishkate.entity.QuestionEntity;
import my.englishkate.service.QuestionService;
import my.englishkate.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "teacher/delete")
public class DeleteController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ThemeService themeService;

    @PostMapping(path = "/question/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        QuestionEntity question = questionService.getById(id);
        Long themeId = question.getTheme().getId();
        questionService.deleteById(id);
        return "redirect:/teacher/themes/" + themeId;
    }

    @PostMapping(path = "/theme/{id}")
    public String deleteTheme(@PathVariable Long id) {
        themeService.deleteById(id);
        return "redirect:/teacher/themes";
    }
}
