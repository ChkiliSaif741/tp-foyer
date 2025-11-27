package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.services.IFoyerServiceImp;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    private final IFoyerServiceImp foyerService;

    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer Foyer) {
        return foyerService.addFoyer(Foyer);
    }

    @PostMapping("/{id}")
    public Foyer affecterFoyerAUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        return foyerService.affecterFoyerAUniversite(id, universite);
    }
}
