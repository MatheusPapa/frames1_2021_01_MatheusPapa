/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.repository.areaRepository;
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
public class cursoController {

    private cursoModel cursoModel;
    private cursoRepository cursoRepository;
    private areaRepository areaRepository;
    private areaModel areaModel;
    private campusRepository campusRepository;
    private campusModel campusModel;
    private List<areaModel> listaDeAreas;
    private List<campusModel> listaDeCampus;
    private List<cursoModel> listaDeCursos;

    public cursoController() {
        this.cursoModel = new cursoModel();
        this.campusModel = new campusModel();
        this.areaModel = new areaModel();
        this.cursoRepository = new cursoRepository();
        this.campusRepository = new campusRepository();
        this.areaRepository = new areaRepository();
        this.listaDeCampus = new ArrayList<>();
        this.listaDeAreas = new ArrayList<>();
    }

    public String salvar() {
        this.cursoRepository.salvar(this.cursoModel);
        return "buscarCurso.xhtml?faces-redirect=true";
    }
    
    public String salvarEdicao() {
        this.cursoRepository.salvar(this.cursoModel);
        return "buscarCurso.xhtml?faces-redirect=true";
    }

    public void remover(long idCurso) {
        this.cursoRepository.remover(idCurso);
    }
    
    public String editar(long idCurso) {
        return "editarCurso.xhtml?faces-redirect=true&idCurso=" + idCurso;
    }
    
    public void getCampus() {
        this.campusModel = this.campusRepository.buscarPorId(this.campusModel.getIdCampus());
    }
    
    public void getArea() {
        this.areaModel = this.areaRepository.buscarPorId(this.areaModel.getIdArea());
    }
    
    public void getCurso() {
        this.cursoModel = this.cursoRepository.buscarPorId(this.cursoModel.getIdCurso());
    }

    public void buscarTodosCursos() {
        this.listaDeCursos = this.cursoRepository.buscarTodos();
    }
    
    public List<SelectItem> getCampi() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        this.listaDeCampus = this.campusRepository.buscarTodos();
        listaDeCampus.forEach((campus) -> {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        });
        return itens;
    }
    
    public List<SelectItem> getAreas() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        this.listaDeAreas = this.areaRepository.buscarTodos();
        listaDeAreas.forEach((area) -> {
            itens.add(new SelectItem(area.getIdArea(), area.getAreaNome()));
        });
        return itens;
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

    public List<campusModel> getListaDeCampus() {
        return listaDeCampus;
    }

    public void setListaDeCampus(List<campusModel> listaDeCampus) {
        this.listaDeCampus = listaDeCampus;
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

    public areaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public areaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(areaModel areaModel) {
        this.areaModel = areaModel;
    }

    public List<areaModel> getListaDeAreas() {
        return listaDeAreas;
    }

    public void setListaDeAreas(List<areaModel> listaDeAreas) {
        this.listaDeAreas = listaDeAreas;
    }

    public List<cursoModel> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<cursoModel> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

}
