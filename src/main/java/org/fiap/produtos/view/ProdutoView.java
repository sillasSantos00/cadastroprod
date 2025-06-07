package org.fiap.produtos.view;

import org.fiap.produtos.Repository.ProdutoCollectionRepository;
import org.fiap.produtos.model.Categoria;
import org.fiap.produtos.model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {

    public static Produto form(Produto produto) {

        Categoria categoria = null;

        do {
            categoria = CategoriaView.form(produto.getCategoria());
        }while (categoria==null);

        String nome = "";

        do {
            nome = JOptionPane.showInputDialog(null, "informe o nome do produto", produto.getNome());
        }while (nome.equals(""));


        String descricao = "";

        do {
            descricao = JOptionPane.showInputDialog(null, "informe a descricao do produto", produto.getDescricao() );
        }while (descricao.equals(""));


        double preco = 0;

        do {
        try {
            preco = Double.parseDouble(JOptionPane.showInputDialog(null, "informe a descricao do produto", produto.getPreco()));
        }catch (Exception e) {
            preco= 0;
        }
        }while (preco<=0);


        Produto ret = new Produto();
        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDatacadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(preco));
        return ret;
    }

    public static void  sucesso () {
        JOptionPane.showMessageDialog(null, "produto  salva");
    }
    public static void sucesso(Produto produto) {
        System.out.println(produto);
        JOptionPane.showMessageDialog(null, "produto " + produto.getNome().toUpperCase() + "foi salvo com sucesso ");
    }


    public static Produto select(Produto produto) {

        Produto ret = (Produto) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Selecione uma Produto",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                ProdutoCollectionRepository.findAll().toArray(), // Número da opção
                produto == null ? 1 : produto);
        return ret;
    }
    public static void  update (Produto produto) {
        form(produto);
        sucesso(produto);
        show(produto);

    }
    private static void show(Produto p) {
        System.out.println(p);
            String textoFormatado = String.format(
                    "PRODUTO: " + p.getNome() + System.lineSeparator() +
                            "DESCRIÇÃO: " + p.getDescricao() + System.lineSeparator() +
                            "CATEGORIA: " + p.getCategoria().toString() + System.lineSeparator() +
                            "PREÇO: %,.2f", p.getPreco()
            );
            JOptionPane.showMessageDialog(null, textoFormatado);
        }

}
