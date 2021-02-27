package be.thomasmore.chess.controllers;

import be.thomasmore.chess.model.Opening;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {
    Opening[] openings = {new Opening("1"), new Opening("2"), new Opening("3")};

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }
    @GetMapping ({"/openingslist"})
    public String openingsList(Model model){
        model.addAttribute("openings",openings);
        return "openingslist";
    }
    @GetMapping({"/openingdetails","/openingdetails/{variable}"})
    public String openingDetails(Model model, @PathVariable int variable){
        model.addAttribute("opening",openings[variable]);
        return "openingdetails";
    }
}
