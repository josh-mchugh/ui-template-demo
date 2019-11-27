package com.example.demo.controller.framework;

import org.springframework.ui.Model;

public class ModalRedirectResponse {

    private Model model;

    public ModalRedirectResponse(Model model) {

        this.model = model;
    }

    public ModalRedirectResponse url(String url) {

        model.addAttribute("url", url);
        return this;
    }

    public String build() {

        return "components/modal/modal-redirect";
    }
}
