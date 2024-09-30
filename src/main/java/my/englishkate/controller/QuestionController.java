package my.englishkate.controller;

import my.englishkate.dto.PageQuestionDTO;
import my.englishkate.dto.QuestionOpenDTO;
import my.englishkate.dto.ThemeOpenDTO;
import my.englishkate.entity.AnswerEntity;
import my.englishkate.entity.QuestionEntity;
import my.englishkate.entity.StudentEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.mapper.ThemeMapper;
import my.englishkate.service.QuestionService;
import my.englishkate.service.StudentService;
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
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String getRandomQuestion() {
        Random rand = new Random();
        StudentEntity student = studentService.getById(studentService.getCurrentStudentId());
        long themeId = student.getThemes().get(rand.nextInt(student.getThemes().size())).getId();
        ThemeEntity theme = themeService.getById(themeId);
        long questionId = theme.getQuestions().get(rand.nextInt(theme.getQuestions().size())).getId();
        return "redirect:/english/question/" + questionId;
    }

    @GetMapping("/{id}")
    public ModelAndView getQuestion(@PathVariable Long id) {
        QuestionEntity question = questionService.getById(id);
        ThemeEntity theme = question.getTheme();
        StudentEntity student = studentService.getById(studentService.getCurrentStudentId());

        PageQuestionDTO pageDTO = new PageQuestionDTO();
        pageDTO.setTitle(theme.getTitle());
        pageDTO.setInstruction(theme.getInstruction());
        pageDTO.setText(question.getText());
        pageDTO.setQuestionId(question.getId());
        pageDTO.setStudentName(student.getFirstName() + " " + student.getLastName());
        pageDTO.setAnswersCount(student.getAnswers().size());
        pageDTO.setWrongCount(student.getAnswers().size() -
                (int)student.getAnswers().stream().filter(AnswerEntity::getResult).count());
        ModelAndView modelAndView = new ModelAndView("question");
        modelAndView.addObject("pageDTO", pageDTO);
        return modelAndView;
    }
}
