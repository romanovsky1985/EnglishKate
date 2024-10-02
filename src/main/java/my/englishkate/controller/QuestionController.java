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
import org.springframework.ui.Model;
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
    public String getRandomQuestion(Model model) {
        Random rand = new Random();
        //System.out.println("DEBUG: start form random question");
        StudentEntity student = studentService.getById(studentService.getCurrentStudentId());
        ThemeEntity theme = student.getThemes().get(rand.nextInt(student.getThemes().size()));
        QuestionEntity question = theme.getQuestions().get(rand.nextInt(theme.getQuestions().size()));
        //System.out.println("DEBUG: end form random question");

        PageQuestionDTO pageDTO = new PageQuestionDTO();
        pageDTO.setTitle(theme.getTitle());
        pageDTO.setInstruction(theme.getInstruction());
        pageDTO.setText(question.getText());
        pageDTO.setQuestionId(question.getId());
        pageDTO.setStudentName(student.getFirstName() + " " + student.getLastName());
        pageDTO.setAnswersCount(student.getAnswers().size());
        pageDTO.setWrongCount(student.getAnswers().size() -
                (int)student.getAnswers().stream().filter(AnswerEntity::getResult).count());
        model.addAttribute("pageDTO", pageDTO);
        return "question";




    }

}
