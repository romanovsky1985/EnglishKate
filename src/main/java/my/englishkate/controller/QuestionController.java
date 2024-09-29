package my.englishkate.controller;

import my.englishkate.dto.PageQuestionDTO;
import my.englishkate.dto.QuestionOpenDTO;
import my.englishkate.dto.ThemeOpenDTO;
import my.englishkate.entity.QuestionEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.mapper.ThemeMapper;
import my.englishkate.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/english/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ThemeMapper themeMapper;

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {
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
        return "redirect:/english/question/2";
    }
}
