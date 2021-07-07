/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.alunoModel;
import edu.eventos.ifms.model.atividadeModel;
import edu.eventos.ifms.model.eventoModel;
import edu.eventos.ifms.model.externoModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.repository.alunoRepository;
import edu.eventos.ifms.repository.atividadeRepository;
import edu.eventos.ifms.repository.eventoRepository;
import edu.eventos.ifms.repository.externoRepository;
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
public class atividadeController  {
    private atividadeModel atividadeModel;
    private atividadeRepository atividadeRepository;
    private eventoModel eventoModel;
    private eventoRepository eventoRepository;
    private servidorModel servidorModel;
    private servidorRepository servidorRepository;
    private List<atividadeModel> listaDeAtividades;
    private List<SelectItem> listaDePessoas;
    private List<SelectItem> listaDeEventos;
    
    public atividadeController() {
        this.atividadeModel = new atividadeModel();
        this.atividadeRepository = new atividadeRepository();
        this.eventoModel = new eventoModel();
        this.eventoRepository = new eventoRepository();
        this.servidorModel = new servidorModel();
        this.servidorRepository = new servidorRepository();
        this.listaDePessoas = new ArrayList<>();
        this.listaDeEventos = new ArrayList<>();
    }
    
    public String salvar(){
        this.atividadeRepository.salvar(this.atividadeModel);
        return "buscarAtividade.xhtml?faces-redirect=true";
    }
    
    public String salvarEdicao() {
        this.atividadeRepository.salvar(this.atividadeModel);
        return "buscarAtividade.xhtml?faces-redirect=true";
    }

    public String editar(long idAtividade) {
        return "editarAtividade.xhtml?faces-redirect=true&idAtividade=" + idAtividade;
    }
    
    public void remover(long idAtividade) {
        this.atividadeRepository.remover(idAtividade);
    }
    
    public void buscarTodasAtividades() {
        this.listaDeAtividades = this.atividadeRepository.buscarTodos();
    }
    
    public void getAtividade() {
        this.atividadeModel = this.atividadeRepository.buscarPorId(this.atividadeModel.getIdAtividade());
    }
    
    public List<SelectItem> getEventos() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        List<eventoModel> eventosBD = this.eventoRepository.buscarTodos();
        eventosBD.forEach((evento) -> {
            itens.add(new SelectItem(evento.getIdEvento(), evento.getEventoNome()));
        });
        return itens;
    }
    
    public List<SelectItem> getMinistrantes() {
        ArrayList<SelectItem> itens = new ArrayList<>();
        List<servidorModel> servidoresBD = this.servidorRepository.buscarTodos();
        servidoresBD.forEach((servidor) -> {
            itens.add(new SelectItem(servidor.getIdPessoa(), servidor.getPessoaNome()));
        });
        return itens;
    }

    public atividadeModel getAtividadeModel() {
        return atividadeModel;
    }

    public void setAtividadeModel(atividadeModel atividadeModel) {
        this.atividadeModel = atividadeModel;
    }

    public atividadeRepository getAtividadeRepository() {
        return atividadeRepository;
    }

    public void setAtividadeRepository(atividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
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

    public List<atividadeModel> getListaDeAtividades() {
        return listaDeAtividades;
    }

    public void setListaDeAtividades(List<atividadeModel> listaDeAtividades) {
        this.listaDeAtividades = listaDeAtividades;
    }

    public List<SelectItem> getListaDePessoas() {
        return listaDePessoas;
    }

    public void setListaDePessoas(List<SelectItem> listaDePessoas) {
        this.listaDePessoas = listaDePessoas;
    }

    public List<SelectItem> getListaDeEventos() {
        return listaDeEventos;
    }

    public void setListaDeEventos(List<SelectItem> listaDeEventos) {
        this.listaDeEventos = listaDeEventos;
    }
    
}
