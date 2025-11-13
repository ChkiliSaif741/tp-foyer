package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.services.IEtudiantServiceImp;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/etudiant")
public class EtudiantController {
    private final IEtudiantServiceImp etudiantService;
}
