package com.example.argprogapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private PeopleInterface persoServ;
    @PostMapping ("/new/persona/")
    public void agregarPersona (@RequestBody People pers){
        persoServ.crearPersona(pers);
    }

    @PutMapping ("/put/{id}")
    public People mofidicarPersona (@PathVariable Long id, @RequestParam("nombre") String nuevoNombre,
    @RequestParam ("apellido") String nuevoApellido){
        People pers = persoServ.buscarPersona(id);
        pers.setApellido(nuevoApellido);
        pers.setNombre(nuevoNombre);
        persoServ.modificarPersona(pers);
        return pers;

    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<People> verPersonas (){
        return persoServ.verPersonas();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
}
