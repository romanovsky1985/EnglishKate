package my.englishkate.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class IndexController {

    @GetMapping(path = "")
    public String index(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().isAuthenticated() ?
                SecurityContextHolder.getContext().getAuthentication().getName() : null;
        model.addAttribute("username", username);
        return "index.html";
    }

    @GetMapping(path = "security/login/ok")
    public String loginOk() {
        return "redirect:/index.html";
    }

    @GetMapping(path = "security/login/fail")
    public String loginFail() {
        return "redirect:/index.html";
    }


}
