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
@PrimaryKeyJoinColumn(name = "ma_id")
public class MagoMio extends PersonajeMio{
    @Column(name = "ma_magia")
    private Integer magia;

    public MagoMio() {
    }

    public MagoMio(Integer magia,String nombre, Integer vida) {
        super(nombre, vida);
        this.magia = magia;
    }

    public Integer getMagia() {
        return magia;
    }

    public void setMagia(Integer magia) {
        this.magia = magia;
    }

    @Override
    public String toString() {
        return super.toString()+" MagoMio{" + "magia=" + magia + '}';
    }
    
    
}
