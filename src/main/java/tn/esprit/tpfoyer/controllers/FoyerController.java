package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.UniversiteDTO;
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
    public Foyer affecterFoyerAUniversite(@PathVariable Long id,@RequestBody UniversiteDTO universiteDTO) {
        return foyerService.affecterFoyerAUniversite(id, universiteDTO.getNomUniversite());
    }

    @PatchMapping("/{id}")
    public Universite desaffecterFoyerAUniversite (@PathVariable Long idUniversite){
        return foyerService.desaffecterFoyerAUniversite(idUniversite);
    }

    @PostMapping("foyeretunuveritse/{id}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable long id){
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, id);
    }
}
