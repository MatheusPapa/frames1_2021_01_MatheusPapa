/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author mathe
 */
@Entity
@Table (name = "servidor")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class servidorModel extends pessoaInternaModel implements Serializable {
    
    @Column(nullable = false, length = 10)
    private String siape;
    
    @Column(nullable = false, length = 30)
    private String cargo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idArea", insertable = true, updatable = true)
    private areaModel area;
    
    @ManyToMany(mappedBy = "servidores")
    private List<campusModel> campusAoQualPertence;
    
    public servidorModel() {
        this.area = new areaModel();
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public areaModel getArea() {
        return area;
    }

    public void setArea(areaModel area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<campusModel> getCampusAoQualPertence() {
        return campusAoQualPertence;
    }

    public void setCampusAoQualPertence(List<campusModel> campusAoQualPertence) {
        this.campusAoQualPertence = campusAoQualPertence;
    }
    
}
