package be.thomasmore.chess.controllers;

import be.thomasmore.chess.model.Game;
import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.model.Player;
import be.thomasmore.chess.model.Variant;
import be.thomasmore.chess.repository.GameRepository;
import be.thomasmore.chess.repository.OpeningRepository;
import be.thomasmore.chess.repository.PlayerRepository;
import be.thomasmore.chess.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("create")
public class AdminController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    OpeningRepository openingRepository;
    @Autowired
    VariantRepository variantRepository;

    @GetMapping("/newgame")
    public String newGame(Model model) {
        model.addAttribute("game", new Game());
        return "admin/newgame";
    }

    @PostMapping("/newgame")
    public String newGamePost(Model model,
                              @ModelAttribute("game") Game game,
                              @RequestParam Integer player1,
                              @RequestParam Integer player2,
                              @ModelAttribute("gameList") Iterable<Game> games) {
        game.setPlayer1(new Player(player1));
        game.setPlayer1(new Player(player2));
        gameRepository.save(game);
        model.addAttribute("gameList", gameRepository.findAll());
        return "gamelist";
    }

    @GetMapping("newgamepgn")
    public String newGamePgn(Model model) {
        model.addAttribute("game", new Game());
        return "admin/newpgn";
    }

    @PostMapping("newgamepgn")
    public String newGamePgnPost(Model model,
                                 @RequestParam String pgn) {
        gameRepository.save(setOpeningAndVariant(MakeNewGameFromPng(pgn)));
        model.addAttribute("gameList", gameRepository.findAll());
        return "gamelist";
    }

    @ModelAttribute("gameList")
    public Iterable<Game> findGames() {
        return gameRepository.findAll();
    }

    @ModelAttribute("players")
    public Iterable<Player> findPlayers() {
        return playerRepository.findAll();
    }

    public String[] processPgn(String pgn) {
        pgn = pgn.replaceAll("\\r|\\n", " ");
        String[] allInfo = pgn.split("\\[|\\]");
        return allInfo;
    }

    public Game MakeNewGameFromPng(String pgn) {
        Game game = new Game();
        String[] allInfo = processPgn(pgn);
        for (String info : allInfo) {
            if (info.matches("\s*White\s*\".*\"")) {
                String name = info.replaceAll("\"|White", "").replaceAll(",", "\s");
                if (playerRepository.findByName(name).isPresent()) {
                    game.setPlayer1(playerRepository.findByName(name).get());
                } else {
                    game.setPlayer1(makeNewPlayer(name));
                }
            }
            if (info.matches("\s*Black\s*\".*\"")) {
                String name = info.replaceAll("\"|Black", "").replaceAll(",", "\s");
                if (playerRepository.findByName(name).isPresent()) {
                    game.setPlayer2(playerRepository.findByName(name).get());
                } else {
                    game.setPlayer2(makeNewPlayer(name));
                }
            }
        }
        game.setMoves(allInfo[allInfo.length - 1]);
        return game;
    }

    public Player makeNewPlayer(String name) {
        Player player = new Player(name);
        playerRepository.save(player);
        return player;
    }

    public Game setOpeningAndVariant(Game game) {
        ArrayList<String> moves = game.processAlgebraicNotation();
        ArrayList<String> openingMoves = new ArrayList<>();
        for (Opening o : openingRepository.findAll()) {
            openingMoves.clear();
            openingMoves.addAll(Arrays.asList(((o.getMove1() != null ? o.getMove1() : "") + " " + (o.getMove2() != null ? o.getMove2() : "")).split(" ")));
            int i = 0;
            int isSame = 0;
            while (i < openingMoves.size() - 1) {
                if (openingMoves.get(i).equals(moves.get(i)))
                    isSame++;
                i++;
            }
            if (isSame == i) {
                game.setOpeningUsed(o);
                for (Variant v : game.getOpeningUsed().getVariants()) {
                    if (moves.get(i + 1).equals(v.getMove())) {
                        game.setVariantUsed(v);
                        break;
                    }
                }
                break;
            }
        }
        return game;
    }
}
