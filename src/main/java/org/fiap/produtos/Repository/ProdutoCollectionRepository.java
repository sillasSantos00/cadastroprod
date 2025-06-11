package org.fiap.produtos.Repository;

import org.fiap.produtos.model.Categoria;
import org.fiap.produtos.model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

import static org.fiap.produtos.Repository.CategoriaCollectionRepository.save;

public class ProdutoCollectionRepository {
    private static List<Produto> produtos;

    static{
        produtos = new Vector<>();
        Produto celular = new Produto();

        celular.setNome("iphone 14 ")
                .setDescricao("celular da aple")
                .setCategoria(CategoriaCollectionRepository.findById(2l))
                .setDatacadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(1200));

        save(celular);
    }

    public static List<Produto> findAll () {
        return produtos;
    }
    public static Produto save (Produto produto){
        if (produtos.contains(produto)){
            produto.setId(produtos.size() + 1);
            produtos.add(produto);
            return produto;
        }else {
            JOptionPane.showMessageDialog(null, "ja existe produto cadastrado "
            );
            return null;
        }
    }

    public static List<Produto> findByCategoria(Categoria categoria) {
        return produtos.stream().filter(p->p.getCategoria().equals(categoria)).toList();
    }
}
