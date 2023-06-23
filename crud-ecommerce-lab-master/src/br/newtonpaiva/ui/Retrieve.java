package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Retrieve {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");
        EntityManager em = factory.createEntityManager();
//find vai procurar o PK da classe o @ID
        Categoria cat = em.find(Categoria.class, 1);

        System.out.println(cat);

        em.close();
        factory.close();
    }
}
