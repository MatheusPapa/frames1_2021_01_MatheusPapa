package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campus")
public class campusModel implements Serializable {
    @Id
    @GeneratedValue
    private Long idCampus;
    
    @Column(nullable = false, length = 80)
    private String campusNome;
    private int campusCidadeId;
    private int campusEstadoId;
    
    public campusModel() {
        this.setIdCampus(0);
        this.campusNome = "";
        this.campusCidadeId = 0;
        this.campusEstadoId = 0;
    }
    
    public long getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(long idCampus) {
        this.idCampus = idCampus;
    }

    public String getCampusNome() {
        return campusNome;
    }

    public void setCampusNome(String campusNome) {
        this.campusNome = campusNome;
    }

    public int getCampusCidadeId() {
        return campusCidadeId;
    }

    public void setCampusCidadeId(int campusCidadeId) {
        this.campusCidadeId = campusCidadeId;
    }

    public int getCampusEstadoId() {
        return campusEstadoId;
    }
    
    public void setCampusEstadoId(int campusEstadoId) {
        this.campusEstadoId = campusEstadoId;
    }
    
}
