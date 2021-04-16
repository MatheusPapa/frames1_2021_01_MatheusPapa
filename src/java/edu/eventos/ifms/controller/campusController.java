/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.repository.campusRepository;
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
public class campusController {
    protected campusModel campusModel;
    protected campusRepository campusRepository;

    public campusController(){
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
    }

    public void salvar(){
        this.campusRepository.salvar(this.campusModel);
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
    
    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(1, "São Paulo"));
        itens.add(new SelectItem(2, "Minas Gerais"));
        itens.add(new SelectItem(3, "Paraná"));
        return itens;
    }

    public List<SelectItem> getCidades() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(1, "Cidade 1"));
        itens.add(new SelectItem(2, "Cidade 2"));
        itens.add(new SelectItem(3, "Cidade 3"));
        return itens;
    }
}
