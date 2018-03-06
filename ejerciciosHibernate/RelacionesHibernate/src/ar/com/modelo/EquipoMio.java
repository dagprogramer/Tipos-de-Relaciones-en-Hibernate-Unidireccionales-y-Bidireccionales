/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author yo
 */
@Entity
@Table(name = "equipo")
public class EquipoMio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eq_id")
    private Long id;
    
    @Column(name = "eq_nombreEquipo")
    private String nombreEquipo;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "equipo_personaje",joinColumns = @JoinColumn(name = "fk_equipo"),inverseJoinColumns = @JoinColumn(name = "fk_personaje"))
    private List<PersonajeMio>personajes;

    public EquipoMio() {
    }

    public EquipoMio(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public EquipoMio(Long id, String nombreEquipo) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<PersonajeMio> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<PersonajeMio> personajes) {
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return "EquipoMio{" + "id=" + id + ", nombreEquipo=" + nombreEquipo + '}';
    }
    
    
}
