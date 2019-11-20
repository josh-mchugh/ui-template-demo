package com.example.demo.controller.modal;

import com.example.demo.controller.modal.model.StandardModalForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modals")
public class ModalController {

    @GetMapping("")
    public String getDefault(Model model) {

        model.addAttribute("standardModalForm", new StandardModalForm());

        return "modal/view-modal";
    }
}
