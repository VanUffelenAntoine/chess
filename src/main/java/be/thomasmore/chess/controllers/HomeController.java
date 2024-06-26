package be.thomasmore.chess.controllers;

import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.model.Variant;
import be.thomasmore.chess.repository.OpeningRepository;
import be.thomasmore.chess.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;


@Controller
public class HomeController {
    @Autowired
    private OpeningRepository openingRepository;
    @Autowired
    private VariantRepository variantRepository;

    @GetMapping({"/", "/home"})
    public String home(Model mode, Principal principal) {
        final String loginName = (principal != null) ? principal.getName() : "NOBODY";
        return "home";
    }

}
