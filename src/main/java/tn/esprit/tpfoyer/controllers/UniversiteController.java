package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.services.IUniversiteServiceImp;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    private final IUniversiteServiceImp universiteService;
}
