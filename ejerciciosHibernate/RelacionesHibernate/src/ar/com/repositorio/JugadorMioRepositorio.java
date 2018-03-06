/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.repositorio;

import ar.com.modelo.EquipoMio;
import ar.com.modelo.JugadorMio;
import ar.com.modelo.PersonajeMio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author yo
 */
public class JugadorMioRepositorio extends RepositorioGenericoMio<JugadorMio, Long>{

    public JugadorMioRepositorio(SessionFactory factory) {
        super(factory);
    }
    
    public JugadorMio getEquipoById(Long id){
        Session session=getFactory().openSession();
        String query="select j from JugadorMio j join fetch j.equipos eq where j.id=:id";
        Query q=session.createQuery(query);
        q.setParameter("id", id);
        JugadorMio jugador=(JugadorMio)q.uniqueResult();
        session.close();
        return jugador;
    }
    
    public void imprimirEquipo(JugadorMio j){
        System.out.println(j.toString()+"posee un equipo: ");
        for(EquipoMio e:j.getEquipos()){
            System.out.println(e.toString());
        }
    }
    
    public void imprimirListaJugadores(List<JugadorMio>juagadores){
        for (JugadorMio juagadore : juagadores) {
            System.out.println(juagadore.toString());
        }
    }
    
}
