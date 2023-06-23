package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");
        EntityManager em = factory.createEntityManager();
//find vai procurar a pk da classe o @ID
        Categoria cat = em.find(Categoria.class, 1);

        em.getTransaction().begin();
        cat.setNome("Livros");
        em.getTransaction().commit();

//        Categoria cat = new Categoria();
//        cat.setId(1);
//        cat.setNome("Livros");
//
//        em.getTransaction().begin();
//        em.merge(cat);
//        em.getTransaction().commit();
//a

//a


        factory.close();
        em.close();
    }
}
