package com.example.demo.controller.form.model;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class BasicExampleForm {


    private String email;
    private String password;
    private String textArea;
    private boolean terms;

    private Map<String, String> countries;
    private String selectedCountry;
    private List<String> selectedCountries;

    public BasicExampleForm() {

        this.countries = Stream.of(Locale.getISOCountries())
                .map(code -> new Locale("", code))
                .collect(Collectors.toMap(Locale::getCountry, Locale::getDisplayCountry));

        this.selectedCountry = "US";
        this.selectedCountries = Lists.newArrayList("US", "GB", "CA");
    }
}
