package my.englishkate.controller.student;

import my.englishkate.dto.page.TestPage;
import my.englishkate.entity.AnswerEntity;
import my.englishkate.entity.QuestionEntity;
import my.englishkate.entity.StudentEntity;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping(path = "/student/test")
public class TestController {
    @Autowired
    private StudentService studentService;

    @GetMapping(path = "")
    public String getRandomQuestion(Model model) {
        Random rand = new Random();
        // тянем из базы текущего пользователя (нужно тянуть, т.к. для того, что в authentication для proxy
        // hibernate уже закрыл сеесию) тянем темы этого пользователя и для одной из них тянем список вопросов
        StudentEntity student = studentService.getById(studentService.getCurrentStudentId());
        ThemeEntity theme = student.getThemes().get(rand.nextInt(student.getThemes().size()));
        QuestionEntity question = theme.getQuestions().get(rand.nextInt(theme.getQuestions().size()));

        TestPage pageDTO = new TestPage();
        pageDTO.setTitle(theme.getTitle());
        pageDTO.setInstruction(theme.getInstruction());
        pageDTO.setQuestionText(question.getQuestionText());
        pageDTO.setQuestionId(question.getId());
        pageDTO.setStudentName(student.getFirstName() + " " + student.getLastName());
        pageDTO.setStudentId(student.getId());
        pageDTO.setAnswersCount(student.getAnswers().size());
        pageDTO.setWrongCount(student.getAnswers().size() -
                (int)student.getAnswers().stream().filter(AnswerEntity::getResult).count());
        model.addAttribute("pageDTO", pageDTO);
        return "student/test.html";
    }
}
