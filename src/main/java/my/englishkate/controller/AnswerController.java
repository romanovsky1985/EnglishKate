package my.englishkate.controller;

import jakarta.validation.constraints.NotNull;
import my.englishkate.dto.AnswerCreateDTO;
import my.englishkate.entity.AnswerEntity;
import my.englishkate.service.AnswerService;
import my.englishkate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/english/answer")
public class AnswerController {
    @Autowired
    StudentService studentService;
    @Autowired
    AnswerService answerService;

    @PostMapping(path = "/{id}")
    public String createAnswer(@PathVariable Long id, @NotNull String answer) {
        AnswerCreateDTO createDTO = new AnswerCreateDTO();
        createDTO.setQuestionId(id);
        createDTO.setStudentId(studentService.getCurrentStudentId());
        createDTO.setAnswer(answer);
        answerService.create(createDTO);
        return "redirect:/english/question";
    }
}
