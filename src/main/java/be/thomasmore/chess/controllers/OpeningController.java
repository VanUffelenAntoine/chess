package be.thomasmore.chess.controllers;

import be.thomasmore.chess.model.Opening;
import be.thomasmore.chess.repository.OpeningRepository;
import be.thomasmore.chess.repository.VariantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OpeningController {
    @Autowired
    private OpeningRepository openingRepository;

    @Autowired
    private VariantRepository variantRepository;

    private Logger logger = LoggerFactory.getLogger(OpeningController.class);
    @GetMapping({"/openingslist"})
    public String openingsList(Model model, @RequestParam(required = false) String firstMove){
        Iterable<Opening> openings = openingRepository.findByFirstMoveQuery(firstMove);
        model.addAttribute("openings",openings);
        return "openingslist";
    }

    @GetMapping({"/openingdetails","/openingdetails/{variable}"})
    public String openingDetails(Model model, @PathVariable int variable){
        model.addAttribute("opening",(openingRepository.findById(variable).isPresent()) ? openingRepository.findById(variable).get() : null);
        model.addAttribute("leftButton",(variable != 1) ? variable-1 : openingRepository.count());
        model.addAttribute("rightButton",(variable != openingRepository.count()) ? variable+1 : 1);
        model.addAttribute("variants", variantRepository.findByParentIdQuery(variable));
        return "openingdetails";
    }
}
