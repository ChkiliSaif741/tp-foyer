package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repositories.BlocReposotory;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;
import java.util.Set;

@Service
public class IBlocServiceImp implements IBlocService{
    @Autowired
    private BlocReposotory blocReposotory;

    @Autowired
    private ChambreRepository chambreRepository;

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

    public List<Chambre> affecterChambresABloc(List<Long> numChambres, String nomBloc) {

        Bloc bloc = (Bloc) blocReposotory.findBlocByNomBloc(nomBloc).orElse(null);

        List<Chambre> chambres = chambreRepository.findAllById(numChambres);

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }

        return chambreRepository.saveAll(chambres);
    }

}
