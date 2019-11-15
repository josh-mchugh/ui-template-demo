package com.example.demo.controller.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forms")
public class FormController {

    @GetMapping("")
    public String getDefault() {

        return "form/view-form";
    }
}
