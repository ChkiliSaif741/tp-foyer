package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
    Etudiant findEtudiantById(Long id);
    List<Etudiant> findAllEtudiants();
}
