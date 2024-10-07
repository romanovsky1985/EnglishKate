package my.englishkate.controller.teacher;

import my.englishkate.dto.QuestionCreateDTO;
import my.englishkate.dto.ThemeCreateDTO;
import my.englishkate.dto.page.teacher.ThemeQuestionsPage;
import my.englishkate.dto.page.teacher.ThemesPage;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.entity.TeacherEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.mapper.ThemeMapper;
import my.englishkate.mapper.TeacherMapper;
import my.englishkate.service.QuestionService;
import my.englishkate.service.ThemeService;
import my.englishkate.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/teacher/themes")
public class ThemesController {
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ThemeMapper themeMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private QuestionService questionService;

    // Список всех тем
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

    // Создать новую тему
    @PostMapping(path = "/create")
    public String createTheme(ThemeCreateDTO createDTO) {
        //TeacherEntity teacher = teacherService.getById(teacherService.getCurrentTeacherId());
        //if (!Objects.equals(createDTO.getTeacherId(), teacher.getId())) {
            // TODO: Permission denied exception
            // перенести проверки в сервис вроде createWithTeacherVerify
        //    throw new RuntimeException("Вы пытаетесь создать тему для другого учителя!");
        //}
        themeService.create(createDTO);
        return "redirect:/teacher/themes";
    }

    // Удалить тему
    @PostMapping(path = "/{id}/delete")
    public String deleteTheme(@PathVariable Long id) {
        //service.deleteWithTeacherVerify
        themeService.deleteById(id);
        return "redirect:/teacher/themes";
    }

    // Вопросы конкретной темы
    @GetMapping(path = "/{id}/questions")
    public String showTheme(Model model, @PathVariable Long id) {
        ThemeEntity theme = themeService.getById(id);

        ThemeQuestionsPage pageDTO = new ThemeQuestionsPage();
        pageDTO.setThemeTitle(theme.getTitle());
        pageDTO.setThemeInstruction(theme.getInstruction());
        pageDTO.setThemeId(theme.getId());
        pageDTO.setQuestions(theme.getQuestions().stream().map(questionMapper::map).toList());
        model.addAttribute("pageDTO", pageDTO);
        return "teacher/theme-questions.html";
    }

    // Создать вопрос для конкретной темы
    @PostMapping("{id}/questions/create")
    public String createQuestion(@PathVariable Long id, QuestionCreateDTO createDTO) {
        //ThemeEntity theme = themeService.getById(id);
        //if (!Objects.equals(theme.getTeacher().getId(), teacherService.getCurrentTeacherId())) {
        //    // TODO: Permission denied exception
        //    throw new RuntimeException("Вы пытаетесь добавить вопрос в тему другого учителя!");
        //}
        questionService.create(createDTO);
        return "redirect:/teacher/themes/" + createDTO.getThemeId() + "/questions";
    }

    // Удалить вопрос из конкретной темы
    @PostMapping(path = "{themeId}/questions/delete/{questionId}")
    public String deleteQuestion(@PathVariable Long themeId, @PathVariable Long questionId) {
        //QuestionEntity question = questionService.getById(questionId);
        //service.deleteWithVerify
        questionService.deleteById(questionId);
        return "redirect:/teacher/themes/" + themeId + "/questions";
    }
}
