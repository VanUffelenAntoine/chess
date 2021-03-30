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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/create", "/edit"})

public class AdminController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    OpeningRepository openingRepository;
    @Autowired
    VariantRepository variantRepository;

    @ModelAttribute("gameList")
    public Iterable<Game> findGames() {
        return gameRepository.findAll();
    }

    @ModelAttribute("player")
    public Player findPlayer(@PathVariable(required = false) Integer playerId) {
        if (playerId == null)
            return new Player();
        Optional<Player> player = playerRepository.findById(playerId);
        return player.isPresent() ? player.get() : null;
    }

    @ModelAttribute("openings")
    public Iterable<Opening> findOpenings(){return openingRepository.findAll();}

    @ModelAttribute("game")
    public Game findGame(@PathVariable(required = false) Integer gameId) {
        if (gameId == null)
            return new Game();
        Optional<Game> game = gameRepository.findById(gameId);
        return game.isPresent() ? game.get() : null;
    }

    @ModelAttribute("players")
    public Iterable<Player> findPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/newgame")
    public String newGame(Model model) {
        return "admin/newgame";
    }

    @PostMapping("/newgame")
    public String newGamePost(Model model,
                              @Valid @ModelAttribute("game") Game game,
                              BindingResult bindingResult,
                              @RequestParam Integer player1,
                              @RequestParam Integer player2,
                              @ModelAttribute("gameList") Iterable<Game> games) {

        if (bindingResult.hasErrors()) {
            return "admin/newgame";
        }

        game.setPlayer1(new Player(player1));
        game.setPlayer2(new Player(player2));
        gameRepository.save(game);
        model.addAttribute("gameList", gameRepository.findAll());
        return "redirect:/gamedetails/" + game.getId();
    }

    @GetMapping("/newgamepgn")
    public String newGamePgn(Model model) {
        return "admin/newpgn";
    }

    @PostMapping("/newgamepgn")
    public String newGamePgnPost(Model model,
                                 @RequestParam String pgn) {
        Game game = setOpeningAndVariant(MakeNewGameFromPng(pgn));
        gameRepository.save(game);
        model.addAttribute("gameList", gameRepository.findAll());
        return "redirect:/gamedetails/" + game.getId();
    }

    @GetMapping({"/game", "/game/{gameId}"})
    public String editGame(Model model,
                           @PathVariable(required = false) Integer gameId) {
        model.addAttribute("gameChosen", gameId != null);
        return "admin/editgame";
    }

    @PostMapping({"/game/{gameId}", "/game"})
    public String choseGame(Model model,
                            @RequestParam(required = false) Integer chosenGameId,
                            @PathVariable(required = false) Integer gameId,
                            @Valid @ModelAttribute("game") Game game,
                            BindingResult bindingResult,
                            @RequestParam(required = false) Integer player1Id,
                            @RequestParam(required = false) Integer player2Id,
                            @RequestParam(required = false) Integer openingId) {
        if (chosenGameId != null)
            return "redirect:/edit/game/" + chosenGameId;

        if (bindingResult.hasErrors()) {
            model.addAttribute("gameChosen", gameId != null);
            return "admin/editgame";
        }

        game.setPlayer1(new Player(player1Id));
        game.setPlayer2(new Player(player2Id));
        if (openingId != null)
        game.setOpeningUsed(new Opening(openingId));
        gameRepository.save(game);
        return "redirect:/gamedetails/" + gameId;
    }

    @GetMapping({"/player", "/player/{playerId}"})
    public String editPlayer(Model model,
                             @PathVariable(required = false) Integer playerId) {
        model.addAttribute("playerChosen", playerId != null);
        return "admin/editplayer";
    }

    @PostMapping({"/player", "/player/{playerId}"})
    public String chosePlayer(Model model,
                              @RequestParam(required = false) Integer chosenPlayerId,
                              @PathVariable(required = false) Integer playerId,
                              @Valid @ModelAttribute("player") Player player,
                              BindingResult bindingResult) {
        if (chosenPlayerId != null)
            return "redirect:/edit/player/" + chosenPlayerId;

        if (bindingResult.hasErrors()) {
            model.addAttribute("playerChosen", playerId != null);
            return "admin/editplayer";
        }

        playerRepository.save(player);
        return "gamelist";
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
        for (String info : allInfo) {
            if (info.contains("WhiteElo") && !info.replaceAll("\s|BlackElo|\"", "").equals("")) {
                String eloPlayer1 = info.replaceAll("\s|WhiteElo|\"", "");
                if (game.getPlayer1().getRating() == null && !eloPlayer1.equals(""))
                    game.getPlayer1().setRating(Integer.parseInt(eloPlayer1));
            }
            if (info.contains("BlackElo") && !info.replaceAll("\s|BlackElo|\"", "").equals("")) {
                String eloPlayer2 = info.replaceAll("\s|BlackElo|\"", "");
                if (game.getPlayer1().getRating() == null && !eloPlayer2.equals(""))
                    game.getPlayer2().setRating(Integer.parseInt(eloPlayer2));
            }
        }
        game.setMoves(allInfo[allInfo.length - 1].replaceAll("[0-9][^\s][0-9]-*[0-9]*[^\s]*[0-9]*",""));
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
            while (i < openingMoves.size()) {
                if (openingMoves.get(i).equals(moves.get(i)))
                    isSame++;
                i++;
            }
            if (isSame == openingMoves.size()) {
                game.setOpeningUsed(o);
                for (Variant v : game.getOpeningUsed().getVariants()) {
                    if (moves.get(i).equals(v.getMove())) {
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
