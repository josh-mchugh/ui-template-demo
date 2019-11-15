package com.example.demo.controller.menu.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName="Builder")
public class Menu {
    private final String name;
    private final String url;
    private final String icon;
    private final boolean active;
}
