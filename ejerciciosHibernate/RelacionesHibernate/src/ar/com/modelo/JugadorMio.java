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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yo
 */
@Entity
@Table(name = "jugador")
public class JugadorMio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ju_id")
    private Long id;
    
    @Column(name = "ju_nombreJugador")
    private String nombreJugador;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ju")
    private List<EquipoMio>equipos;

    public JugadorMio() {
    }

    public JugadorMio(Long id, String nombreJugador) {
        this.id = id;
        this.nombreJugador = nombreJugador;
    }

    public JugadorMio(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public List<EquipoMio> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<EquipoMio> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "JugadorMio{" + "id=" + id + ", nombreJugador=" + nombreJugador + '}';
    }
    
    
}
