/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.repository.areaRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author mathe
 */
@ManagedBean
@ViewScoped
public class areaController {
    private areaModel areaModel;
    private areaRepository areaRepository;
    private List<areaModel> listaDeAreas;

    public areaController() {
        this.areaModel = new areaModel();
        this.areaRepository = new areaRepository();
    }
    
    public String salvar(){
        this.areaRepository.salvar(this.areaModel);
        return "buscarArea.xhtml?faces-redirect=true";
    }
    
    public String salvarEdicao() {
        this.areaRepository.salvar(this.areaModel);
        return "buscarArea.xhtml?faces-redirect=true";
    }

    public String editar(long idArea) {
        return "editarArea.xhtml?faces-redirect=true&idArea=" + idArea;
    }
    
    public void remover(long idArea) {
        this.areaRepository.remover(idArea);
    }
    
    public void buscarTodasAreas() {
        this.listaDeAreas = this.areaRepository.buscarTodos();
    }
    
    public void getArea() {
        this.areaModel = this.areaRepository.buscarPorId(this.areaModel.getIdArea());
    }

    public areaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(areaModel areaModel) {
        this.areaModel = areaModel;
    }

    public areaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<areaModel> getListaDeAreas() {
        return listaDeAreas;
    }

    public void setListaDeAreas(List<areaModel> listaDeAreas) {
        this.listaDeAreas = listaDeAreas;
    }
    
}
