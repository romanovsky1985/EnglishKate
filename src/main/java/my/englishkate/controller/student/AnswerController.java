package my.englishkate.controller.student;

import jakarta.validation.constraints.NotNull;
import my.englishkate.dto.AnswerCreateDTO;
import my.englishkate.service.AnswerService;
import my.englishkate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/student/answer")
public class AnswerController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AnswerService answerService;

    @PostMapping(path = "")
    public String createAnswer(@NotNull AnswerCreateDTO createDTO) {
        createDTO.setStudentId(studentService.getCurrentStudentId());
        answerService.create(createDTO);
        return "redirect:/student/test";
    }
}
