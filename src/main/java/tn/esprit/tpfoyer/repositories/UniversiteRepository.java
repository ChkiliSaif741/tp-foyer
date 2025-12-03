package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Universite findUniversiteByNomUniversiteEquals(String nomUniversite);

    Universite findByNomUniversite(String nomUniversite);
}
