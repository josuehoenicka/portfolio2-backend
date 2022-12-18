package com.example.portfolio2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService implements PeopleInterface {

    @Autowired
    public PeopleRepository persoRepo;

    @Override
    public List<People> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(People per) {
        persoRepo.save(per);
        
    }

    @Override
    public void modificarPersona(People per) {
        persoRepo.save(per);        
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
        
    }

    @Override
    public People buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
}
