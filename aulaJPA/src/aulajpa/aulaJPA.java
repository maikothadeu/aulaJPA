/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author maiko
 */
public class aulaJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("aulaJPAPU");
        EntityManager manager = fabrica.createEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Maiko");    
        
        EntityTransaction tran = manager.getTransaction();
        tran.begin();
        manager.persist(p);
        tran.commit();
        
        Query consulta = manager.createQuery("select p from Produto p"
                + "where p.preco < :preco"
                + "order by p.nome");
        
        consulta.setFirstResult(9);
        consulta.setMaxResults(3);
        
        consulta.setParameter("preco", 10);
        
        List<Produto> lista = consulta.getResultList();
        
      //  for(Produto p : lista ){
       //     System.out.print(p);
        //}
    }
    
    
}
