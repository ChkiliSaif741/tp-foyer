package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.services.IReservationServiceImp;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/reservation")
public class ReservationController {
    private final IReservationServiceImp reservationService;
}
