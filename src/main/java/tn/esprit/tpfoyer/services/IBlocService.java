package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Long id);
    Bloc findBlocById(Long id);
    List<Bloc> findAllBlocs();
}
