package be.thomasmore.chess.controllers;

import be.thomasmore.chess.model.Game;
import be.thomasmore.chess.repository.GameRepository;
import be.thomasmore.chess.repository.OpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    OpeningRepository openingRepository;
    @Autowired
    GameRepository gameRepository;
    @GetMapping({"/gamedetails","/gamedetails/{id}"})
    public String gamedetails(Model model, @PathVariable(required = false) Integer id) {
        if (gameRepository.findById(id).isPresent()) {
            model.addAttribute("movesList", gameRepository.findById(id).get().processAlgebraicNotation());
            model.addAttribute("game", gameRepository.findById(id).get());
            model.addAttribute("moveListPrintable", gameRepository.findById(id).get().getMoveList());
        }
        return "gamedetails";
    }
    @GetMapping({"/gamelist"})
    public String gameList(Model model, @RequestParam(required = false) String opening){
        model.addAttribute("gameList", opening != null ? gameRepository.findGamesUsedOpening(opening) : gameRepository.findAll());
        return "gamelist";
    }
}
