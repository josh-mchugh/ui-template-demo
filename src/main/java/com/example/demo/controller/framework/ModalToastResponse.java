package com.example.demo.controller.framework;

import org.springframework.ui.Model;

public class ModalToastResponse {

    public enum Type{
        SUCCESS,
        INFO,
        WARNING,
        ERROR
    }

    private Model model;

    public ModalToastResponse(Model model) {

        this.model = model;
    }

    public ModalToastResponse title(String title) {

        model.addAttribute("title", title);
        return this;
    }

    public ModalToastResponse message(String message) {

        model.addAttribute("message", message);
        return this;
    }

    public ModalToastResponse type(Type type) {

        model.addAttribute("type", type.name().toLowerCase());
        return this;
    }

    public String build() {
        return "components/modal/modal-toaster";
    }
}
