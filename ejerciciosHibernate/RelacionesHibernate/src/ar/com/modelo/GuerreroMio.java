/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author yo
 */
@Entity
@PrimaryKeyJoinColumn(name = "gue_id")
public class GuerreroMio extends PersonajeMio{
    @Column(name = "gue_fuerza")
    private Integer fuerza;

    public GuerreroMio() {
    }

    public GuerreroMio(Integer fuerza,String nombre, Integer vida) {
        super(nombre, vida);
        this.fuerza = fuerza;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public String toString() {
        return super.toString()+ " GuerreroMio{" + "fuerza=" + fuerza + '}';
    }
    
}
