/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mathe
 */
@Entity
@Table(name = "area")
public class areaModel implements Serializable {
    @Id
    @GeneratedValue
    private Long idArea;
    
    @Column(nullable = false, length = 80)
    private String areaNome;
    
    public areaModel() {
        this.areaNome = "";
    }

    public String getAreaNome() {
        return areaNome;
    }

    public void setAreaNome(String areaNome) {
        this.areaNome = areaNome;
    }
    
}
