package com.example.demo.controller.table;

import com.example.demo.controller.table.model.TableFilterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tables")
public class TableController {

    @GetMapping("")
    public String getDefault(Model model) {

        model.addAttribute("tableFilterForm", new TableFilterForm());

        return "table/view-table";
    }
}
