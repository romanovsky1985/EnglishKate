package my.englishkate.controller.teacher;

import my.englishkate.dto.page.ThemePageDTO;
import my.englishkate.entity.ThemeEntity;
import my.englishkate.mapper.QuestionMapper;
import my.englishkate.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher/themes")
public class ThemeController {
    @Autowired
    private ThemeService themeService;
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/{id}")
    public String showTheme(Model model, @PathVariable Long id) {
        ThemeEntity theme = themeService.getById(id);

        ThemePageDTO pageDTO = new ThemePageDTO();
        pageDTO.setThemeTitle(theme.getTitle());
        pageDTO.setThemeInstruction(theme.getInstruction());
        pageDTO.setThemeId(theme.getId());
        pageDTO.setQuestions(theme.getQuestions().stream().map(questionMapper::map).toList());
        model.addAttribute("pageDTO", pageDTO);
        return "teacher/theme_questions";
    }
}
