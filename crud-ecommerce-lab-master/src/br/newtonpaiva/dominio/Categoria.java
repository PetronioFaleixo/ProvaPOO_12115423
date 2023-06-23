package br.newtonpaiva.dominio;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//Entity e para conectar no banco tudo que ta aqui em baixo jogar no banco de dados
@Entity
//renomear a tabela se não usar vai com o nome da classe
@Table(name = "tb_categoria")
public class Categoria {
    //e para a chave primaria da tabela
    @Id
    //gerar o id altomaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //definnir o nome da coluna se não usar vai ser o nome do elemento
    @Column(name="categoria_id")
    private Integer id;
    //colun e para mudar a config da coluna, nullable = false não pode ser vazio
    // e ser unico e não pode ter outro igual
    @Column(name = "nom_cat", nullable = false, unique = true)
    private String nome;

    //um para muitos e relação entre classes
    @OneToMany(cascade = CascadeType.ALL)
    //JoinColumn nomeia a Foreng key a chave estranjeira
    @JoinColumn(name="categoria_id")
    private List<Produto> produtos;


    //isso e gerado altomatico
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
