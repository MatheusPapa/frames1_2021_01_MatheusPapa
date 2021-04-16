package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.campusModel;

public class campusRepository {
  
    public void salvar(campusModel campus){
        System.out.println("Campus nome: "+campus.getCampusNome()+
        " - Estado e Cidade Id´s: " + campus.getCampusEstadoId() +
        " - " + campus.getCampusCidadeId());
    }
    
}
