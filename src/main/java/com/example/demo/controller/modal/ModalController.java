package com.example.demo.controller.modal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modals")
public class ModalController {

    @GetMapping("")
    public String getDefault() {

        return "modal/view-modal";
    }
}
