package com.example.argprogapi;
import java.util.List;


public interface PeopleInterface {
    public List<People> verPersonas();
    public void crearPersona (People per);
    public void modificarPersona(People per);
    public void borrarPersona(Long id);
    public People buscarPersona(Long id);
}
