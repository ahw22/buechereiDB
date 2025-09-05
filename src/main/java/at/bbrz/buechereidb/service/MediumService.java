package at.bbrz.buechereidb.service;

import at.bbrz.buechereidb.model.*;
import at.bbrz.buechereidb.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediumService {

    @Autowired
    private MediaRepository repository;

    @Autowired
    private BuchRepository buchRepository;

    @Autowired
    private DVDRepository dvdRepository;

    @Autowired
    private MagazinRepository magazinRepository;

    @Autowired
    private SchallplatteRepository schallplatteRepository;

    public void saveAll(List<Medium> mediumList) {
        System.out.println(mediumList);
        repository.saveAll(mediumList);
    }

    public List<Medium> fetchAll() {
        List<Buch> buecher = buchRepository.findAll();
        List<Magazin> magazine = magazinRepository.findAll();
        List<DVD> dvds = dvdRepository.findAll();
        List<Schallplatte> schallplatten = schallplatteRepository.findAll();

        List<Medium> allMedia = new ArrayList<>();
        allMedia.addAll(buecher);
        allMedia.addAll(magazine);
        allMedia.addAll(dvds);
        allMedia.addAll(schallplatten);

        return allMedia;
    }

    public Medium getByInventarnummer(String inventarNr) {
        Buch buch = buchRepository.findByInventarNr(inventarNr);
        if (buch != null) return buch;

        DVD dvd = dvdRepository.findByInventarNr(inventarNr);
        if (dvd != null) return dvd;

        Magazin magazin = magazinRepository.findByInventarNr(inventarNr);
        if (magazin != null) return magazin;

        Schallplatte schallplatte = schallplatteRepository.findByInventarNr(inventarNr);
        if (schallplatte != null) return schallplatte;

        throw new EntityNotFoundException();
    }

}
