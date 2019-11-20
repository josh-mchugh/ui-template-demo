package com.example.demo.controller.form;

import com.example.demo.controller.form.model.BasicExampleForm;
import com.example.demo.controller.form.model.DisabledExampleForm;
import com.example.demo.controller.form.model.ErrorExampleForm;
import com.example.demo.controller.form.model.IconExampleForm;
import com.example.demo.controller.form.model.InlineExampleForm;
import com.example.demo.controller.form.model.ReadOnlyExampleForm;
import com.example.demo.controller.form.model.RequiredExampleForm;
import com.example.demo.controller.form.model.RowExampleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/forms")
public class FormController {

    @GetMapping("")
    public String getDefault(Model model, @Valid @ModelAttribute ErrorExampleForm errorExampleForm, BindingResult result) {

        model.addAttribute("basicExampleForm", new BasicExampleForm());
        model.addAttribute("rowExampleForm", new RowExampleForm());
        model.addAttribute("inlineExampleForm", new InlineExampleForm());
        model.addAttribute("iconExampleForm", new IconExampleForm());
        model.addAttribute("requiredExampleForm", new RequiredExampleForm());
        model.addAttribute("errorExampleForm", errorExampleForm);
        model.addAttribute("disabledExampleForm", new DisabledExampleForm());
        model.addAttribute("readOnlyExampleForm", new ReadOnlyExampleForm());

        return "form/view-form";
    }
}
