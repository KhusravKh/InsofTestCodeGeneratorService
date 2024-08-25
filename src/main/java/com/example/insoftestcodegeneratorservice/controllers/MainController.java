package com.example.insoftestcodegeneratorservice.controllers;

import com.example.insoftestcodegeneratorservice.services.CodeGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CodeGeneratorService codeGeneratorService;

    @GetMapping("/")
    public String first(Model model) {
        var codes = codeGeneratorService.findAllCodes();
        model.addAttribute("codes", codes);
        return "main";
    }

    @GetMapping("/trigger_code")
    public String triggerCode(Model model) {
        var codes = codeGeneratorService.generateCode();
        model.addAttribute("codes", codes);
        return "main";
    }

}
