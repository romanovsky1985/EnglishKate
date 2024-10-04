package my.englishkate.controller.teacher;

import my.englishkate.dto.page.QuestionsPage;
import my.englishkate.dto.page.ThemesPage;
import my.englishkate.dto.page.StudentsPage;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.entity.TeacherEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.mapper.ThemeMapper;
import my.englishkate.mapper.TeacherMapper;
import my.englishkate.mapper.StudentMapper;
import my.englishkate.service.ThemeService;
import my.englishkate.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private TeacherService teacherService;

/*
    @GetMapping(path = "/{id}")
    public String showTheme(Model model, @PathVariable Long id) {
        ThemeEntity theme = themeService.getById(id);

        QuestionsPage pageDTO = new QuestionsPage();
        pageDTO.setThemeTitle(theme.getTitle());
        pageDTO.setThemeInstruction(theme.getInstruction());
        pageDTO.setThemeId(theme.getId());
        pageDTO.setQuestions(theme.getQuestions().stream().map(questionMapper::map).toList());
        model.addAttribute("pageDTO", pageDTO);
        return "teacher/questions.html";
    }

    @GetMapping(path = "")
    public String showThemes(Model model) {
        TeacherEntity teacher = teacherService.getById(teacherService.getCurrentTeacherId());

        ThemesPage pageDTO = new ThemesPage();
        pageDTO.setTeacherName(teacher.getFirstName() + " " + teacher.getLastName());
        pageDTO.setTeacherId(teacher.getId());
        pageDTO.setThemes(teacher.getThemes().stream().map(themeMapper::map).toList());
        model.addAttribute("pageDTO", pageDTO);
        return "teacher/themes.html";
    }
*/

    @GetMapping(path = " ")
    public String showStudents(Model model) {
        TeacherEntity teacher = teacherService.getById(teacherService.getCurrentTeacherId());

        StudentsPage pageDTO = new StudentsPage();
        pageDTO.setStudents(teacher.getStudents().stream().map(studentMapper::map).toList());
        model.addAttribute("pageDTO", pageDTO);
        return "teacher/students.html";
    }
}
