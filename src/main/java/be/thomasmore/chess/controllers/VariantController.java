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

import java.util.ArrayList;
import java.util.List;

@Controller
public class VariantController {
    @Autowired
    VariantRepository variantRepository;
    @Autowired
    OpeningRepository openingRepository;

    public List<Variant> getVariantsSortedByOpening(Opening opening){
        return openingRepository.findVariantsForOpening(opening);
    }
    @GetMapping({"/variantlist", "/variantlist/{id}"})
    public String variantList(Model model, @PathVariable(required = false) Integer id) {
        //Iterable<Variant> variants = variantRepository.findByParentIdQuery(id);
        Iterable<Opening> openings = openingRepository.findAll();
        model.addAttribute("openings", openings);
        //model.addAttribute("variants", variants);
        return "variantlist";
    }

    @GetMapping({"/variantdetails", "/variantdetails/{variable}"})
    public String variantDetails(Model model, @PathVariable int variable) {
        model.addAttribute("variant", (variantRepository.findById(variable).isPresent()) ? variantRepository.findById(variable).get() : null);
        model.addAttribute("leftButton", (variable != 1) ? variable - 1 : variantRepository.count());
        model.addAttribute("rightButton", (variable != variantRepository.count()) ? variable + 1 : 1);
        return "variantdetails";
    }
}
