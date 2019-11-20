package com.example.demo.controller.table.model;

import lombok.Data;

@Data
public class TableFilterForm {

    private String filterQuery;
    private boolean active;
    private boolean inactive;
}
