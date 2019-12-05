package com.example.demo.controller.table;

import com.example.demo.controller.components.TablePage;
import com.example.demo.controller.table.model.TableFilterForm;
import com.example.demo.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tables")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping("")
    public String getDefault(Model model, TableFilterForm form, Pageable pageable) {

        TablePage<UserEntity> page  = tableService.getUsers(form, pageable);
        model.addAttribute("pageable", page);
        model.addAttribute("form", form);

        return "table/view-table";
    }

    @GetMapping("/users")
    public String getTable(Model model, @ModelAttribute("form") TableFilterForm form, Pageable pageable) {

        TablePage<UserEntity> page  = tableService.getUsers(form, pageable);
        model.addAttribute("pageable", page);
        model.addAttribute("form", form);

        return "table/partials/partial-user-table";
    }
}
