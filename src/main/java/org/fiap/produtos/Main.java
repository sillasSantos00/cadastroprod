package org.fiap.produtos;

import org.fiap.produtos.Repository.CategoriaCollectionRepository;
import org.fiap.produtos.Repository.ProdutoCollectionRepository;
import org.fiap.produtos.model.Categoria;
import org.fiap.produtos.model.Produto;
import org.fiap.produtos.view.CategoriaView;
import org.fiap.produtos.view.Opcao;
import org.fiap.produtos.view.OpcaoView;
import org.fiap.produtos.view.ProdutoView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Opcao opcao = null;
        do {
            opcao = OpcaoView.select();
            switch (opcao){
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_SISTEMA -> encerrarOSistema();

            }

        }while (opcao != Opcao.ENCERRAR_SISTEMA);
    }

    private static void alterarProduto() {
        Produto produto = ProdutoView.select(null);
        ProdutoView.update(produto);
    }

    private static void encerrarOSistema() {
        System.exit(0);
    }

    private static void consultarProdutoPorCategoria() {
        Categoria categoria = CategoriaView.select(null);

       List<Produto> produtos =  ProdutoCollectionRepository.findByCategoria(categoria);

       if (produtos.isEmpty()) {
           JOptionPane.showMessageDialog(null, "nao encontramos produtos com a categoria  " + categoria.getNome());
       }else {
           produtos.forEach(ProdutoView::show);
           produtos.forEach(System.out::println);
       }
    }

    private static void consultarProdutoPorId() {
        
    }

    private static void cadastrarProduto() {
        Produto produto = ProdutoView.form(new Produto());
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
    }

    private static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form(new Categoria());
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
    }
}
