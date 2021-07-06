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
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table (name = "aluno")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class alunoModel extends pessoaInternaModel implements Serializable {
    
    @Column(nullable = false, length = 10)
    private String ra;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCampus", insertable = true, updatable = true)
    private campusModel campus;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCurso", insertable = true, updatable = true)
    private cursoModel curso;
    
    public alunoModel() {
        this.campus = new campusModel();
        this.curso = new cursoModel();
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public campusModel getCampus() {
        return campus;
    }

    public void setCampus(campusModel campus) {
        this.campus = campus;
    }

    public cursoModel getCurso() {
        return curso;
    }

    public void setCurso(cursoModel curso) {
        this.curso = curso;
    }
    
}
