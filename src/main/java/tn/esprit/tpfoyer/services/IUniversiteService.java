package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long id);
    Universite findUniversiteById(Long id);
    List<Universite> findAllUniversites();
}
