/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author mathe
 */
@Entity
@Table (name = "evento")
public class eventoModel implements Serializable {
    
    @Id
    @GeneratedValue
    private Long idEvento;
    
    @Column(nullable = false, length = 80)
    private String eventoNome;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCampus", insertable = true, updatable = true)
    private campusModel campus;
    
    public eventoModel() {
        this.campus = new campusModel();
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getEventoNome() {
        return eventoNome;
    }

    public void setEventoNome(String eventoNome) {
        this.eventoNome = eventoNome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public campusModel getCampus() {
        return campus;
    }

    public void setCampus(campusModel campus) {
        this.campus = campus;
    }
    
    
}
