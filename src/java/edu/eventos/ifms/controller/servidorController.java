/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.servidorRepository;
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
public class servidorController {
    private servidorModel servidorModel;
    private servidorRepository servidorRepository;
    private campusModel campusModel;
    private campusRepository campusRepository;
    private areaModel areaModel;
    private areaRepository areaRepository;
    private List<campusModel> listaDeCampus;
    private List<servidorModel> listaDeServidores;
    private List<areaModel> listaDeAreas;
    
    public servidorController() {
        this.servidorModel = new servidorModel();
        this.servidorRepository = new servidorRepository();
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
        this.areaModel = new areaModel();
        this.areaRepository = new areaRepository();
        this.listaDeCampus = new ArrayList<>();
        this.listaDeAreas = new ArrayList<>();
        this.listaDeServidores = new ArrayList<>();
    }
    
    public String salvar(){
        this.servidorRepository.salvar(this.servidorModel);
        return "buscarServidor.xhtml?faces-redirect=true";
    }
    
    public String salvarEdicao() {
        this.servidorRepository.salvar(this.servidorModel);
        return "buscarServidor.xhtml?faces-redirect=true";
    }

    public String editar(long idServidor) {
        return "editarServidor.xhtml?faces-redirect=true&idServidor=" + idServidor;
    }
    
    public void remover(long idServidor) {
        this.servidorRepository.remover(idServidor);
    }
    
    public void buscarTodosServidores() {
        this.listaDeServidores = this.servidorRepository.buscarTodos();
    }
    
    public void getServidor() {
        this.servidorModel = this.servidorRepository.buscarPorId(this.servidorModel.getIdPessoa());
    }
    
    public List<SelectItem> getCampi() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        this.listaDeCampus = this.campusRepository.buscarTodos();
        listaDeCampus.forEach((campus) -> {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        });
        return itens;
    }
    
    public List<SelectItem> getAreas() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        this.listaDeAreas = this.areaRepository.buscarTodos();
        listaDeAreas.forEach((area) -> {
            itens.add(new SelectItem(area.getIdArea(), area.getAreaNome()));
        });
        return itens;
    }

    public servidorModel getServidorModel() {
        return servidorModel;
    }

    public void setServidorModel(servidorModel servidorModel) {
        this.servidorModel = servidorModel;
    }

    public servidorRepository getServidorRepository() {
        return servidorRepository;
    }

    public void setServidorRepository(servidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
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

    public List<campusModel> getListaDeCampus() {
        return listaDeCampus;
    }

    public void setListaDeCampus(List<campusModel> listaDeCampus) {
        this.listaDeCampus = listaDeCampus;
    }

    public List<servidorModel> getListaDeServidores() {
        return listaDeServidores;
    }

    public void setListaDeServidores(List<servidorModel> listaDeServidores) {
        this.listaDeServidores = listaDeServidores;
    }

    public List<areaModel> getListaDeAreas() {
        return listaDeAreas;
    }

    public void setListaDeAreas(List<areaModel> listaDeAreas) {
        this.listaDeAreas = listaDeAreas;
    }
    
    
}
