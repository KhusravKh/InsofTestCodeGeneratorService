package com.example.insoftestcodegeneratorservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String first(Model model) {
        return "main";
    }

    @GetMapping("/trigger_code")
    public String triggerCode(Model model) {
        return "main";
    }

}
