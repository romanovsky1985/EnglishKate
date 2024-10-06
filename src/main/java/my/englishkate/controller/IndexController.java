package my.englishkate.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import my.englishkate.dto.page.MainPage;

@Controller
@RequestMapping(path = "")
public class IndexController {

    @GetMapping(path = "")
    public String index(Model model) {
        MainPage pageDTO = new MainPage();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        pageDTO.setUsername(authentication.getName());
        authentication.getAuthorities().stream().findFirst().ifPresent(
                authority -> pageDTO.setAuthority(authority.getAuthority())
        );
        model.addAttribute("pageDTO", pageDTO);
        return "main.html";
    }

    @PostMapping(path = "login/ok")
    public String loginOk() {
        return "redirect:/";
    }

    @PostMapping(path = "login/fail")
    public String loginFail() {
        return "redirect:/";
    }


}
