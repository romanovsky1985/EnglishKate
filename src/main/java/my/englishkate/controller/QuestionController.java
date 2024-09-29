package my.englishkate.controller;

import my.englishkate.dto.PageQuestionDTO;
import my.englishkate.dto.QuestionOpenDTO;
import my.englishkate.dto.ThemeOpenDTO;
import my.englishkate.entity.QuestionEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.mapper.ThemeMapper;
import my.englishkate.service.QuestionService;
import my.englishkate.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
@RequestMapping("/english/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ThemeMapper themeMapper;

    @GetMapping("")
    public String getRandomQuestion() {
        // TODO: получаем id нужных тем у пользователя
        long themeId = 2;

        ThemeEntity theme = themeService.getById(themeId);
        int index = new Random().nextInt(theme.getQuestions().size());
        long id = theme.getQuestions().get(index).getId();
        return "redirect:/english/question/" + id;
    }

    @GetMapping("/{id}")
    public ModelAndView getQuestion(@PathVariable Long id) {
        QuestionEntity question = questionService.getById(id);
        ThemeEntity theme = question.getTheme();
        PageQuestionDTO pageDTO = new PageQuestionDTO();
        pageDTO.setTitle(theme.getTitle());
        pageDTO.setInstruction(theme.getInstruction());
        pageDTO.setText(question.getText());
        pageDTO.setQuestionId(question.getId());
        ModelAndView modelAndView = new ModelAndView("question");
        modelAndView.addObject("pageDTO", pageDTO);
        return modelAndView;
    }

    @PostMapping("/{id}")
    public String post(@PathVariable Long id, @RequestBody String answer) {
        // TODO: проверка ответа и редирект на получение следующего задания
        return "redirect:/english/question";
    }
}
