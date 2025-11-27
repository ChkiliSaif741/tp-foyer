package tn.esprit.tpfoyer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;

@Service
@Slf4j
public class IChambreServiceImp implements IChambreServices {
    @Autowired
    private ChambreRepository chambreRepository;

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
    */

    @Scheduled(fixedRate = 1000)
    public void DetailsChambres() {
        List<Chambre> chambres = chambreRepository.findAll();
        chambres.forEach(chambre -> {
            log.info("\n Chambre : "+chambre.getIdChambre()+"\n Chambre Numero : "+chambre.getNumeroChambre()+"\n Chambre Type: "+chambre.getTypeC());
        });
    }
    }

