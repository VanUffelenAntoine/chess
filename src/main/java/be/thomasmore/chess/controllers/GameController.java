package be.thomasmore.chess.controllers;

import be.thomasmore.chess.model.Game;
import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.repository.GameRepository;
import be.thomasmore.chess.repository.OpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {
    @Autowired
    OpeningRepository openingRepository;
    @Autowired
    GameRepository gameRepository;


    @ModelAttribute("opening") public Opening CreateOpening(){return new Opening();}

    @GetMapping({"/gamedetails", "/gamedetails/{gameId}"})
    public String gamedetails(Model model, @PathVariable(required = false) Integer gameId) {
        if (gameRepository.findById(gameId).isPresent()) {
            model.addAttribute("movesList", gameRepository.findById(gameId).get().processAlgebraicNotation());
            model.addAttribute("game", gameRepository.findById(gameId).get());
            model.addAttribute("moveListPrintable", gameRepository.findById(gameId).get().getMoveList());
        }
        return "gamedetails";
    }

    @PostMapping("/gamedetails/{gameId}")
    public String newGameAddOpeningPost(Model model,
                                        @PathVariable Integer gameId,
                                        @ModelAttribute("opening") Opening opening){
        model.addAttribute("movesList", gameRepository.findById(gameId).get().processAlgebraicNotation());
        model.addAttribute("moveListPrintable", gameRepository.findById(gameId).get().getMoveList());
        openingRepository.save(opening);
        Game game = gameRepository.findGameById(gameId);
        game.setOpeningUsed(opening);
        gameRepository.save(game);
        model.addAttribute("game", gameRepository.findById(gameId).get());
        return "gamedetails";
    }

    @GetMapping({"/gamelist"})
    public String gameList(Model model, @RequestParam(required = false) String opening){
        model.addAttribute("gameList", opening != null ? gameRepository.findGamesUsedOpening(opening) : gameRepository.findAll());
        return "gamelist";
    }
}
