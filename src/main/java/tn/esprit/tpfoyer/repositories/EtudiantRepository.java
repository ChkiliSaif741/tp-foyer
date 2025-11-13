package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
