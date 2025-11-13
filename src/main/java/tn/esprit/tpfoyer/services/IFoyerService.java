package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    void deleteFoyer(Long id);
    Foyer findFoyerById(Long id);
    List<Foyer> findAllFoyers();
}
