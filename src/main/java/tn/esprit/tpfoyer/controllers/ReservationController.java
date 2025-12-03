package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.services.IReservationServiceImp;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/reservation")
public class ReservationController {
    private final IReservationServiceImp reservationService;

    @PostMapping("ajout/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idBloc,@PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc,cinEtudiant);
    }

    @DeleteMapping("cancel/{cinEtudiant}")
    public Reservation annulerReservation(long cinEtudiant){
        return reservationService.annulerReservation(cinEtudiant);
    }
}
