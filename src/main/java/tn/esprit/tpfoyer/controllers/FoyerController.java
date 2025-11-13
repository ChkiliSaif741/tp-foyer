package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.services.IFoyerServiceImp;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    private final IFoyerServiceImp foyerService;
}
