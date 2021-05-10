/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.eventoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.eventoRepository;
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
public class eventoController {
    private eventoModel eventoModel;
    private eventoRepository eventoRepository;
    private campusModel campusModel;
    private campusRepository campusRepository;
    private List<campusModel> listaDeCampus;

    public eventoController() {
        this.eventoModel = new eventoModel();
        this.eventoRepository = new eventoRepository();
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
        this.listaDeCampus = new ArrayList<>();
    }
    
    public void salvar(){
        this.eventoRepository.salvar(this.eventoModel);
    }
    
    public List<SelectItem> getCampi() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        this.listaDeCampus = this.campusRepository.buscarTodos();
        for (campusModel campus : listaDeCampus) {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        }
        return itens;
    }

    public eventoModel getEventoModel() {
        return eventoModel;
    }

    public void setEventoModel(eventoModel eventoModel) {
        this.eventoModel = eventoModel;
    }

    public eventoRepository getEventoRepository() {
        return eventoRepository;
    }

    public void setEventoRepository(eventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
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
    
}
