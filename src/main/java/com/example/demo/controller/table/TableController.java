package com.example.demo.controller.table;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tables")
public class TableController {

    @GetMapping("")
    public String getDefault() {

        return "table/view-table";
    }
}
