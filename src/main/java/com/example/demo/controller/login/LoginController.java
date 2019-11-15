package com.example.demo.controller.login;

import com.example.demo.controller.login.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("")
    public String getLogin(Model model) {

        model.addAttribute("form", new LoginForm());

        return "login/view-login";
    }

    @PostMapping("/")
    public String postLogin(Model model, @Valid @ModelAttribute("form") LoginForm form, BindingResult results) {

        if(results.hasErrors()) {

            return "login/view-login";
        }

        return "redirect:/dashboard";
    }
}
