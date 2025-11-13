package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
