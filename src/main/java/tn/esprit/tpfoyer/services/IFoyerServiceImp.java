package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repositories.FoyerRepository;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
public class IFoyerServiceImp implements IFoyerService{
    @Autowired
    private FoyerRepository foyerRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer findFoyerById(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> findAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer affecterFoyerAUniversite (Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        Universite universite = universiteRepository.findUniversiteByNomUniversiteEquals(nomUniversite);
        foyer.setUniversite(universite);
        return foyerRepository.save(foyer);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Foyer foyer = foyerRepository.findByUniversiteEquals(universite);
        foyer.setUniversite(null);
        return universite;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        foyer.setUniversite(universite);

        if (foyer.getBlocset() != null) {
            for (Bloc bloc : foyer.getBlocset()) {
                bloc.setFoyer(foyer);
            }
        }

        return foyerRepository.save(foyer);
    }
}
