package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");
        EntityManager em = factory.createEntityManager();

        Categoria cat = em.find(Categoria.class, 1);

        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();

        factory.close();
        em.close();
    }
}
