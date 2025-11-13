package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repositories.BlocReposotory;

import java.util.List;

@Service
public class IBlocServiceImp implements IBlocService{
    @Autowired
    private BlocReposotory blocReposotory;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return  blocReposotory.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocReposotory.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocReposotory.deleteById(id);
    }

    @Override
    public Bloc findBlocById(Long id) {
        return blocReposotory.findById(id).orElse(null);
    }

    @Override
    public List<Bloc> findAllBlocs() {
        return blocReposotory.findAll();
    }
}
