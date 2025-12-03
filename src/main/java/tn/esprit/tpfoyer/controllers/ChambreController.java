package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.services.IChambreServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Gestion des chambres",description = "CRUD des chambres")
@RequestMapping(value = "/chambre")
public class ChambreController {
    private final IChambreServiceImp chambreServiceImp;

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreServiceImp.addChambre(chambre);
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreServiceImp.updateChambre(chambre);
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreServiceImp.deleteChambreById(id);
    }

    @Operation(summary = "Afficher les chambres")
    @GetMapping
    public List<Chambre> getAllChambre() {
        return chambreServiceImp.findAllChambres();
    }

    @GetMapping("{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreServiceImp.findChambreById(id);
    }

    @GetMapping("byUniveritse/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite){
        return chambreServiceImp.getChambresParNomUniversite(nomUniversite);
    }
}
