package org.fiap.produtos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Produto {
    public String nome ;
    public BigDecimal preco;
    public LocalDateTime datacadastro;
    public String descricao ;
    public Categoria categoria;
    public long id;

    public Produto() {
    }

    public Produto(String nome, Categoria categoria, String descricao, LocalDateTime datacadastro, BigDecimal preco, long id) {
        this.setNome(nome);
        this.setCategoria(categoria);
        this.setDescricao(descricao);
        this.setDatacadastro(datacadastro);
        this.setPreco(preco);
        this.setId(id);
    }

    public Produto(String nome, BigDecimal preco, LocalDateTime datacadastro, String descricao, Categoria categoria) {
        this.setNome(nome);
        this.setPreco(preco);
        this.setDatacadastro(datacadastro);
        this.setDescricao(descricao);
        this.setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDateTime getDatacadastro() {
        return datacadastro;
    }

    public Produto setDatacadastro(LocalDateTime datacadastro) {
        this.datacadastro = datacadastro;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Produto setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public long getId() {
        return id;
    }

    public Produto setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getNome(), produto.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
