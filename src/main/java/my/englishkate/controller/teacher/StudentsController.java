package my.englishkate.controller.teacher;

import my.englishkate.dto.page.QuestionsPage;
import my.englishkate.dto.page.ThemesPage;
import my.englishkate.dto.page.StudentsPage;
import my.englishkate.dto.page.StudentThemesPage;
import my.englishkate.dto.page.StudentAnswersPage;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.entity.TeacherEntity;
import my.englishkate.entity.StudentEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.mapper.ThemeMapper;
import my.englishkate.mapper.TeacherMapper;
import my.englishkate.mapper.AnswerMapper;
import my.englishkate.mapper.StudentMapper;
import my.englishkate.service.StudentService;
import my.englishkate.service.AnswerService;
import my.englishkate.service.ThemeService;
import my.englishkate.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/teacher/students")
public class StudentsController {
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ThemeMapper themeMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AnswerService answerService;

    @GetMapping(path = "/{id}/answers")
    public String showStudentAnswers(Model model, @PathVariable Long id) {
        StudentEntity student = studentService.getById(id);
        StudentAnswersPage pageDTO = new StudentAnswersPage();
        pageDTO.setStudentName(student.getFirstName() + " " + student.getLastName());
        pageDTO.setStudentId(student.getId());
        pageDTO.setAnswers(student.getAnswers().stream().map(answerMapper::map).toList());
        model.addAttribute("pageDTO", pageDTO);
        return "teacher/student-answers.html";
    }

    @PostMapping(path = "/{id}/answers/clear")
    public String clearStudentAnswers(@PathVariable Long id) {
        StudentEntity student = studentService.getById(id);
        answerService.deleteByStudent(student);
        return "redirect:/teacher/students/" + id + "/answers";
    }

    @GetMapping(path = "/{id}/themes")
    public String showStudentThemes(Model model, @PathVariable Long id) {
        StudentEntity student = studentService.getById(id);
        TeacherEntity teacher = teacherService.getById(teacherService.getCurrentTeacherId());

        StudentThemesPage pageDTO = new StudentThemesPage();
        pageDTO.setStudentName(student.getFirstName() + " " + student.getLastName());
        pageDTO.setStudentId(student.getId());
        pageDTO.setThemes(student.getThemes().stream().map(themeMapper::map).toList());
        pageDTO.setTeacherThemes(teacher.getThemes().stream().map(themeMapper::map).toList());

        model.addAttribute("pageDTO", pageDTO);
        return "teacher/student-themes.html";
    }

    @PostMapping(path = "/{studentId}/themes/remove/{themeId}")
    public String removeTheme(@PathVariable Long studentId, @PathVariable Long themeId) {
        studentService.removeTheme(studentId, themeId);
        return "redirect:/teacher/students/" + studentId + "/themes";
    }

    @PostMapping(path = "/{studentId}/themes/append")
    public String appendTheme(@PathVariable Long studentId, Long themeId) {
        studentService.addTheme(studentId, themeId);
        return "redirect:/teacher/students/" + studentId + "/themes";
    }


    @GetMapping(path = " ")
    public String showStudents(Model model) {
        TeacherEntity teacher = teacherService.getById(teacherService.getCurrentTeacherId());

        StudentsPage pageDTO = new StudentsPage();
        pageDTO.setStudents(teacher.getStudents().stream().map(studentMapper::map).toList());
        model.addAttribute("pageDTO", pageDTO);
        return "teacher/students.html";
    }
}
