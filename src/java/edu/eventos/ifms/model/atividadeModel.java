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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author mathe
 */
@Entity
@Table (name = "atividade")
public class atividadeModel implements Serializable {
    @Id
    @GeneratedValue
    private Long idAtividade;
    
    @Column(nullable = false, length = 80)
    private String atividadeNome;
    
    @Column(nullable = false, length = 255)
    private String descricao;
    
    @Column(nullable = false)
    private int quantidade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idEvento", insertable = true, updatable = true)
    private eventoModel evento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idPessoa", insertable = true, updatable = true)
    private servidorModel pessoa;
    
    @ManyToMany
    @JoinTable(name = "atividade_pessoa",
            joinColumns = @JoinColumn(name = "idAtividade"),
            inverseJoinColumns = @JoinColumn(name = "idPessoa"))
    private List<alunoModel> alunos;

    public atividadeModel() {
        this.evento = new eventoModel();
        this.pessoa = new servidorModel();
    }
    
    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Long idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getAtividadeNome() {
        return atividadeNome;
    }

    public void setAtividadeNome(String atividadeNome) {
        this.atividadeNome = atividadeNome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public eventoModel getEvento() {
        return evento;
    }

    public void setEvento(eventoModel evento) {
        this.evento = evento;
    }

    public pessoaModel getMinistrante() {
        return pessoa;
    }

    public void setMinistrante(servidorModel pessoa) {
        this.pessoa = pessoa;
    }

    public List<alunoModel> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<alunoModel> aluno) {
        this.alunos = aluno;
    }
    
}
