/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.model.externoModel;
import edu.eventos.ifms.repository.cidadeRepository;
import edu.eventos.ifms.repository.estadoRepository;
import edu.eventos.ifms.repository.externoRepository;
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
public class externoController {
    private externoModel externoModel;
    private externoRepository externoRepository;
    private cidadeModel cidadeModel;
    private cidadeRepository cidadeRepository;
    private estadoModel estadoModel;
    private estadoRepository estadoRepository;
    private List<externoModel> listaDeExternos;
    private List<SelectItem> listaDeCidades;
    private List<estadoModel> listaDeEstados;
    
    public externoController() {
        this.externoModel = new externoModel();
        this.externoRepository = new externoRepository();
        this.cidadeModel = new cidadeModel();
        this.cidadeRepository = new cidadeRepository();
        this.estadoModel = new estadoModel();
        this.estadoRepository = new estadoRepository();
        this.listaDeExternos = new ArrayList<>();
        this.listaDeCidades = new ArrayList<>();
        this.listaDeEstados = new ArrayList<>();
    }
    
    public String salvar(){
        System.out.println(this.externoModel);
        this.externoRepository.salvar(this.externoModel);
        return "buscarExterno.xhtml?faces-redirect=true";
    }
    
    public String salvarEdicao() {
        this.externoRepository.salvar(this.externoModel);
        return "buscarExterno.xhtml?faces-redirect=true";
    }

    public String editar(long idExterno) {
        return "editarExterno.xhtml?faces-redirect=true&idExterno=" + idExterno;
    }
    
    public void remover(long idExterno) {
        this.externoRepository.remover(idExterno);
    }
    
    public void buscarTodosExternos() {
        this.listaDeExternos = this.externoRepository.buscarTodos();
    }
    
    public void getExterno() {
        this.externoModel = this.externoRepository.buscarPorId(this.externoModel.getIdPessoa());
        this.listaDeCidades = this.getCidades(this.externoModel.getEstado().getIdEstado());
    }
    
    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        List<estadoModel> estadosBD = this.estadoRepository.buscar();
        estadosBD.forEach((estado) -> {
            itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
        });
        return itens;
    }
    
    public void onChangeEstado() {
        this.listaDeCidades = this.getCidades(this.externoModel.getEstado().getIdEstado());
    }
    
    public List<SelectItem> getCidades(long idEstado) {
        ArrayList<SelectItem> itens = new ArrayList<>();
        List<cidadeModel> cidadesBD = this.cidadeRepository.buscar(idEstado);
        cidadesBD.forEach((cidade) -> {
            itens.add(new SelectItem(cidade.getIdCidade(), cidade.getCidadeNome()));
        });

        return itens;
    }

    public externoModel getExternoModel() {
        return externoModel;
    }

    public void setExternoModel(externoModel externoModel) {
        this.externoModel = externoModel;
    }

    public externoRepository getExternoRepository() {
        return externoRepository;
    }

    public void setExternoRepository(externoRepository externoRepository) {
        this.externoRepository = externoRepository;
    }

    public cidadeModel getCidadeModel() {
        return cidadeModel;
    }

    public void setCidadeModel(cidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public cidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(cidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public estadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(estadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public estadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(estadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<externoModel> getListaDeExternos() {
        return listaDeExternos;
    }

    public void setListaDeExternos(List<externoModel> listaDeExternos) {
        this.listaDeExternos = listaDeExternos;
    }

    public List<SelectItem> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<SelectItem> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }

    public List<estadoModel> getListaDeEstados() {
        return listaDeEstados;
    }

    public void setListaDeEstados(List<estadoModel> listaDeEstados) {
        this.listaDeEstados = listaDeEstados;
    }
    
}
