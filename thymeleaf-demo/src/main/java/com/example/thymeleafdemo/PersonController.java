package com.example.thymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PersonController {
    @GetMapping
    String getPeople(Model model){
        model.addAttribute("something","this is coming from the controller");
        model.addAttribute("people", Arrays.asList(
                new Person("ibrahim", 31),
                new Person("bekir", 28),
                new Person("talip", 22),
                new Person("mustafa", 17)
        ));
        return "people";
    }

}
