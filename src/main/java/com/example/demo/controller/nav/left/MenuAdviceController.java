package com.example.demo.controller.nav.left;

import com.example.demo.controller.nav.left.model.Menu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MenuAdviceController {

    @ModelAttribute
    public void getMenuAttributes(Model model, HttpServletRequest request) {

        List<Menu> menus = new ArrayList<>();

        menus.add(Menu.builder()
                .name("Dashboard")
                .url("/dashboard")
                .icon("home")
                .active(isActive(request, "/dashboard"))
                .build());

        menus.add(Menu.builder()
                .name("Forms")
                .url("/forms")
                .icon("edit outline")
                .active(isActive(request, "/forms"))
                .build());

        menus.add(Menu.builder()
                .name("Modals")
                .url("/modals")
                .icon("window restore outline")
                .active(isActive(request, "/modals"))
                .build());

        menus.add(Menu.builder()
                .name("Tables")
                .url("/tables")
                .icon("table")
                .active(isActive(request, "/tables"))
                .build());

        model.addAttribute("menus", menus);
    }

    private boolean isActive(HttpServletRequest request, String path) {

        if(StringUtils.isNotBlank(request.getRequestURI())) {

            return request.getRequestURI().startsWith(path);
        }

        return false;
    }
}
