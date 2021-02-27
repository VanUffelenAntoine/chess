package be.thomasmore.chess.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }
    @GetMapping ({"/openingslist"})
    public String openingsList(Model model){

    }
}
