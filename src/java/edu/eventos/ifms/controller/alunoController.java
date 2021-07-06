/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.alunoModel;
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.repository.alunoRepository;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cursoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author mathe
 */
@ManagedBean
@ViewScoped
public class alunoController {
    private alunoModel alunoModel;
    private alunoRepository alunoRepository;
    private campusModel campusModel;
    private campusRepository campusRepository;
    private cursoModel cursoModel;
    private cursoRepository cursoRepository;
    private List<campusModel> listaDeCampus;
    private List<cursoModel> listaDeCursos;
    private List<alunoModel> listaDeAlunos;
    
    public alunoController() {
        this.alunoModel = new alunoModel();
        this.alunoRepository = new alunoRepository();
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
        this.cursoModel = new cursoModel();
        this.cursoRepository = new cursoRepository();
        this.listaDeCampus = new ArrayList<>();
        this.listaDeCursos = new ArrayList<>();
    }
    
    public String salvar(){
        this.alunoRepository.salvar(this.alunoModel);
        return "buscarAluno.xhtml?faces-redirect=true";
    }
    
    public String salvarEdicao() {
        this.alunoRepository.salvar(this.alunoModel);
        return "buscarAluno.xhtml?faces-redirect=true";
    }

    public String editar(long idAluno) {
        return "editarAluno.xhtml?faces-redirect=true&idAluno=" + idAluno;
    }
    
    public void remover(long idEvento) {
        this.alunoRepository.remover(idEvento);
    }
    
    public void buscarTodosAlunos() {
        this.listaDeAlunos = this.alunoRepository.buscarTodos();
    }
    
    public void getAluno() {
        this.alunoModel = this.alunoRepository.buscarPorId(this.alunoModel.getIdPessoa());
    }
    
    public List<SelectItem> getCampi() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        this.listaDeCampus = this.campusRepository.buscarTodos();
        listaDeCampus.forEach((campus) -> {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        });
        return itens;
    }
    
    public List<SelectItem> getCursos() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        this.listaDeCursos = this.cursoRepository.buscarTodos();
        listaDeCursos.forEach((curso) -> {
            itens.add(new SelectItem(curso.getIdCurso(), curso.getCursoNome()));
        });
        System.out.println(itens);
        return itens;
    }

    public alunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(alunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public alunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(alunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public campusModel getCampusModel() {
        return campusModel;
    }

    public void setCampusModel(campusModel campusModel) {
        this.campusModel = campusModel;
    }

    public campusRepository getCampusRepository() {
        return campusRepository;
    }

    public void setCampusRepository(campusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    public cursoModel getCursoModel() {
        return cursoModel;
    }

    public void setCursoModel(cursoModel cursoModel) {
        this.cursoModel = cursoModel;
    }

    public cursoRepository getCursoRepository() {
        return cursoRepository;
    }

    public void setCursoRepository(cursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<campusModel> getListaDeCampus() {
        return listaDeCampus;
    }

    public void setListaDeCampus(List<campusModel> listaDeCampus) {
        this.listaDeCampus = listaDeCampus;
    }

    public List<cursoModel> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<cursoModel> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public List<alunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<alunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }
    
}
