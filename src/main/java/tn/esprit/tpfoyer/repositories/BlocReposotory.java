package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.Optional;

public interface BlocReposotory extends JpaRepository<Bloc, Long> {
    Optional<Object> findBlocByNomBloc(String nomBloc);
}
