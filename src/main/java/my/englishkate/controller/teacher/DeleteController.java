package my.englishkate.controller.teacher;

import my.englishkate.entity.QuestionEntity;
import my.englishkate.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/delete")
public class DeleteController {
    @Autowired
    private QuestionService questionService;

    @PostMapping(path = "/question/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        QuestionEntity question = questionService.getById(id);
        Long themeId = question.getTheme().getId();
        questionService.deleteById(id);
        return "redirect:/teacher/themes/" + themeId;
    }
}
