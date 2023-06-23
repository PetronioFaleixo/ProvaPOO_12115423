package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Categoria;
import br.newtonpaiva.dominio.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Create {
    //essa parte e geral unica coisa que muda e o "EC-PU"
    //<persistence-unit name="EC-PU"> e o caminho quue o banco via gerar
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");

        EntityManager em = factory.createEntityManager();


        em.getTransaction().begin();
//aqui e onde cria e conecta as clases
        Produto p = new Produto();
        p.setNome("DOTA2");

        List<Produto> produtos = new ArrayList<>();
        produtos.add(p);

        Categoria c = new Categoria();
        c.setNome("Jogos");
        c.setProdutos(produtos);

        em.persist(c);
//aqui e para comitar e fechar os dados tem que ter
        em.getTransaction().commit();
        em.close();
        factory.close();

    }
}
