package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    Reservation findReservation(Long id);
    List<Reservation> findAllReservations();
    public Reservation ajouterReservation (long idBloc, long cinEtudiant) ;
    Reservation annulerReservation(long cinEtudiant);
}
