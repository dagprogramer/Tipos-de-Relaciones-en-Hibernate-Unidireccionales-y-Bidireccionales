/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author yo
 */
@Entity
@Table(name = "personaje")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonajeMio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pe_id")
    private Long id;
    
    @Column(name = "pe_nombre")
    private String nombre;
    
    @Column(name = "pe_vida")
    private Integer vida;

    public PersonajeMio() {
    }

    public PersonajeMio(String nombre, Integer vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public PersonajeMio(Long id, String nombre, Integer vida) {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return "PersonajeMio{" + "id=" + id + ", nombre=" + nombre + ", vida=" + vida + '}';
    }
    
    
}
