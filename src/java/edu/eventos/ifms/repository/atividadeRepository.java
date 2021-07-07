/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.atividadeModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mathe
 */
public class atividadeRepository {
    private Session session;
    private Transaction transaction;
    
    public void salvar(atividadeModel atividade){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        this.session.saveOrUpdate(atividade);

        this.transaction.commit();
        this.session.close();

    }
    
    public List<atividadeModel> buscarTodos(){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<atividadeModel> listaDeAtividades = this.session.createQuery("from atividadeModel").list();
        this.transaction.commit();
        this.session.close();
        return listaDeAtividades;
    }
    
    public atividadeModel buscarPorId(long idAtividade){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        atividadeModel atividade = (atividadeModel) this.session.get(atividadeModel.class, idAtividade);
        
        this.transaction.commit();
        this.session.close();
        return atividade;
    }
    
    public void remover(long idAtividade) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        atividadeModel atividade = (atividadeModel) this.session.get(atividadeModel.class, idAtividade);
        this.session.delete(atividade);

        this.transaction.commit();
        this.session.close();
    }
}
