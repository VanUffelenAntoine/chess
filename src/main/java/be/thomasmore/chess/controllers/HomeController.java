package be.thomasmore.chess.controllers;

import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.repository.OpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {
    @Autowired
    private OpeningRepository openingRepository;
    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }
    @GetMapping ({"/openingslist"})
    public String openingsList(Model model){
        Iterable<Opening> openings = openingRepository.findAll();
        model.addAttribute("openings",openings);
        return "openingslist";
    }
    @GetMapping({"/openingdetails","/openingdetails/{variable}"})
    public String openingDetails(Model model, @PathVariable int variable){
        model.addAttribute("opening",(openingRepository.findById(variable).isPresent()) ? openingRepository.findById(variable).get() : null);
        model.addAttribute("leftButton",(variable != 1) ? variable-1 : openingRepository.count());
        model.addAttribute("rightButton",(variable != openingRepository.count()) ? variable+1 : 1);
        return "openingdetails";
    }
}
