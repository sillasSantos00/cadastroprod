package org.fiap.produtos.view;

public enum Opcao {
    CADASTRAR_CATEGORIA(1,"cadastrar"),
    CADASTRAR_PRODUTO(2, "cadastrar produto"),
    ALTERAR_PRODUTO(3, "alterar produto "),
    CONSULTAR_PRODUTO_POR_ID(4, "consultar produto por id "),
    CONSULTAR_PRODUTO_POR_CATEGORIA(5, "consultar por categoria"),
    ENCERRAR_SISTEMA(6, "encerrar o sistema ");

    int id;
    String nome;

    Opcao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public Opcao setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Opcao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
