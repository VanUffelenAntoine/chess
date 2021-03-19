package be.thomasmore.chess.controllers;

import be.thomasmore.chess.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {
    @Autowired
    GameRepository gameRepository;
    @GetMapping({"/gamedetails","/gamedetails/{id}"})
    public String gamedetails(Model model, @PathVariable(required = false) Integer id) {
        if (id != null)
        model.addAttribute("movesList", gameRepository.findById(id).get().getMovesAsArrayList());
        return "gamedetails";
    }
}
