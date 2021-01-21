package com.example.PCStore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeResource {

    @GetMapping("/home_page")
    public String showHomePage(){
        return "home_page";
    }
}
