package tn.esprit.tpfoyer.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repositories.BlocReposotory;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IReservationServiceImp implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BlocReposotory blocReposotory;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public Reservation findReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {

        // 1️⃣ Récupérer le bloc
        Bloc bloc = blocReposotory.findById(idBloc).orElse(null);
        if (bloc == null) return null;

        // 2️⃣ Récupérer l’étudiant par CIN
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) return null;

        // 3️⃣ Chercher une chambre disponible
        Chambre chambreDisponible = bloc.getChambres()
                .stream()
                .filter(chambre -> chambre.getReservations() == null || chambre.getReservations().isEmpty())
                .findFirst()
                .orElse(null);

        if (chambreDisponible == null) {
            System.out.println("Aucune chambre disponible dans ce bloc !");
            return null;
        }

        // 4️⃣ Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setAnneeUniversitaire(new Date());
        reservation.setEstValide(true);
        reservation.setEtudiants(Set.of(etudiant));
        reservation.setChambre(chambreDisponible);

        // 5️⃣ Lier la réservation à l’étudiant
        if (etudiant.getReservations2() == null)
            etudiant.setReservations2(new HashSet<>());

        etudiant.getReservations2().add(reservation);

        // 6️⃣ Lier la réservation à la chambre
        chambreDisponible.getReservations().add(reservation);

        // 7️⃣ Sauvegarder
        reservation = reservationRepository.save(reservation);

        return reservation;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(long cinEtudiant) {

        // 1️⃣ Récupérer l’étudiant par CIN
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null || etudiant.getReservations2() == null || etudiant.getReservations2().isEmpty()) {
            return null; // aucun étudiant ou aucune réservation
        }

        // 2️⃣ On considère que l'étudiant a UNE seule réservation active
        //    (Cas classique dans les foyers universitaires)
        Reservation reservation = etudiant.getReservations2()
                .stream()
                .filter(Reservation::getEstValide)
                .findFirst()
                .orElse(null);

        if (reservation == null) {
            return null; // pas de réservation valide trouvée
        }

        // 3️⃣ Désaffecter l’étudiant de cette réservation
        reservation.getEtudiants().remove(etudiant);
        etudiant.getReservations2().remove(reservation);

        // 4️⃣ Mettre estValide = false
        reservation.setEstValide(false);

        // 5️⃣ Désaffecter la chambre
        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
            reservation.setChambre(null);

            // 6️⃣ Mettre à jour la capacité du bloc
            Bloc bloc = chambre.getBloc();
            bloc.setCapaciteBloc(bloc.getCapaciteBloc() + 1);
            blocReposotory.save(bloc);
        }

        // 7️⃣ Sauvegarder la réservation mise à jour
        return reservationRepository.save(reservation);
    }



}
