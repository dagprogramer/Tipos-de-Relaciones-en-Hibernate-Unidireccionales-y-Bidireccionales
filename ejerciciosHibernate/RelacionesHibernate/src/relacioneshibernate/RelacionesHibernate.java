/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacioneshibernate;

import ar.com.manager.SessionManagerMio;
import ar.com.modelo.EquipoMio;
import ar.com.modelo.GuerreroMio;
import ar.com.modelo.JugadorMio;
import ar.com.modelo.MagoMio;
import ar.com.modelo.PersonajeMio;
import ar.com.repositorio.JugadorMioRepositorio;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yo
 */
public class RelacionesHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory factory=SessionManagerMio.getSession();
        
        try{
        PersonajeMio magoDiego=new MagoMio(250, "magodiego", 150);
        PersonajeMio guerreroDiego=new GuerreroMio(300, "guerrero diego", 145);
        
        List<PersonajeMio>listaPersonajesDiego=new ArrayList<>();
        listaPersonajesDiego.add(magoDiego);
        listaPersonajesDiego.add(guerreroDiego);
        
        EquipoMio equipoDiego=new EquipoMio("equipoDiego");
        equipoDiego.setPersonajes(listaPersonajesDiego);
        
        List<EquipoMio>listaEquipoDiego=new ArrayList<>();
        listaEquipoDiego.add(equipoDiego);
        
        JugadorMio jugadorDiego=new JugadorMio("diego");
        jugadorDiego.setEquipos(listaEquipoDiego);
        
        PersonajeMio magoPablo=new MagoMio(200, "magoPablo", 180);
        PersonajeMio guerreroPablo=new GuerreroMio(350, "guerrero pablo", 185);
        
        List<PersonajeMio>listaPersonajesPablo=new ArrayList<>();
        listaPersonajesPablo.add(magoPablo);
        listaPersonajesPablo.add(guerreroPablo);
        
        EquipoMio equipoPablo=new EquipoMio("equipoPablo");
        equipoPablo.setPersonajes(listaPersonajesPablo);
        
        List<EquipoMio>listaEquipoPablo=new ArrayList<>();
        listaEquipoPablo.add(equipoPablo);
        
        JugadorMio jugadorPablo=new JugadorMio("pablo");
        jugadorPablo.setEquipos(listaEquipoPablo);
        
        List<JugadorMio>juagdores=new ArrayList<>();
        juagdores.add(jugadorDiego);
        juagdores.add(jugadorPablo);
        
        JugadorMioRepositorio repositorio=new JugadorMioRepositorio(factory);
        Long idDiego=repositorio.save(jugadorDiego);
        Long idPablo=repositorio.save(jugadorPablo);
        juagdores=repositorio.getAll();
        repositorio.imprimirListaJugadores(juagdores);
            System.out.println();
        JugadorMio jugadorSeleccionado=repositorio.getEquipoById(idDiego);
        repositorio.imprimirEquipo(jugadorSeleccionado);
            System.out.println();
        }finally{
            factory.close();
        }
        
    }
    
}
