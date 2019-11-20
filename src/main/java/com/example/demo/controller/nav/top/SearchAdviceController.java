package com.example.demo.controller.nav.top;

import com.example.demo.controller.nav.top.model.TopNavForm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SearchAdviceController {

    @ModelAttribute()
    public void getTopNavAttributes(Model model) {

        model.addAttribute("topNavForm", new TopNavForm());
    }
}
