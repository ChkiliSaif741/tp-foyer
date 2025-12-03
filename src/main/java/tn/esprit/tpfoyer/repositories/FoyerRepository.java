package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    Foyer findByUniversiteEquals(Universite universite);
}
