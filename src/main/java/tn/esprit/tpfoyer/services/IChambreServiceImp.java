package tn.esprit.tpfoyer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repositories.ChambreRepository;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class IChambreServiceImp implements IChambreServices {
    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambreById(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre findChambreById(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> findAllChambres() {
        return chambreRepository.findAll();
    }

    /*
        @Scheduled(fixedRate=1000)
        public void countChambre(){
            log.info(String.valueOf(chambreRepository.count()));
        }


    @Scheduled(fixedRate = 1000)
    public void DetailsChambres() {
        List<Chambre> chambres = chambreRepository.findAll();
        chambres.forEach(chambre -> {
            log.info("\n Chambre : "+chambre.getIdChambre()+"\n Chambre Numero : "+chambre.getNumeroChambre()+"\n Chambre Type: "+chambre.getTypeC());
        });
    }*/

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {

        // 1️⃣ Récupérer l'université par son nom
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (universite == null || universite.getFoyer2() == null) {
            return new ArrayList<>(); // pas d'université ou pas de foyer
        }

        Foyer foyer = universite.getFoyer2();

        // 2️⃣ Récupérer les blocs du foyer
        Set<Bloc> blocs = foyer.getBlocset();  // ⚠ tu dois avoir un Set<Bloc> blocs; dans Foyer

        List<Chambre> chambres = new ArrayList<>();

        // 3️⃣ Récupérer les chambres de chaque bloc
        for (Bloc bloc : blocs) {
            chambres.addAll(bloc.getChambres());
        }

        return chambres;
    }

}

