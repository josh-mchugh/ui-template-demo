package com.example.demo.controller.modal;

import com.example.demo.controller.framework.ModalRedirectResponse;
import com.example.demo.controller.framework.ModalToastResponse;
import com.example.demo.controller.modal.model.StandardModalForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/modals")
public class ModalController {

    @GetMapping("")
    public String getDefault(Model model) {

        return "modal/view-modal";
    }

    @GetMapping("/standard-modal")
    public String getStandardModal(Model model) {

        model.addAttribute("form", new StandardModalForm());

        return "modal/partials/partial-standard-modal";
    }

    @PostMapping("/standard-modal")
    public String postStandardModal(Model model, @Valid @ModelAttribute("form") StandardModalForm form, BindingResult results) {

        if(results.hasErrors()) {

            return "modal/partials/partial-standard-modal";
        }

        return new ModalToastResponse(model)
                .title("Success")
                .message("New user registered")
                .type(ModalToastResponse.Type.SUCCESS)
                .build();
    }

    @GetMapping("/redirect-modal")
    public String getRedirectModal(Model model) {

        return "modal/partials/partial-redirect-modal";
    }

    @PostMapping("/redirect-modal")
    public String postRedirectModal(Model model) {

        return new ModalRedirectResponse(model)
                .url("/")
                .build();
    }
}
