package org.fiap.produtos.Repository;

import org.fiap.produtos.model.Categoria;
import org.fiap.produtos.model.Produto;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.Arrays;

public class CategoriaCollectionRepository {

    private static List<Categoria> categorias;

    static {
        categorias = new Vector<>();
        Categoria eletronicos = new Categoria(1l, " eletronicos");
        Categoria celulares = new Categoria(2l, " celulares");
        Categoria livros = new Categoria(3l, " livros");
        categorias.add(eletronicos);
        categorias.add(celulares);
        categorias.add(livros);

    }

    public static Categoria save(String s) {
        Categoria c = new Categoria(s);
        if (!categorias.contains(c)) {
            c.setId((long) categorias.size() + 1);
            categorias.add(c);
            return c;
        } else {
            return null;
        }
    }
    public static List<Categoria> findAll() {
        return categorias;
    }

    public static Categoria findById (Long id) {
        return categorias.stream().filter(c ->c.getId().equals(id)).findFirst().orElse(null);
    }
    public static List<Categoria> findByNome (String nome) {
        return categorias.stream().filter(c -> c.getNome().equalsIgnoreCase(nome)).toList();
    }
    public static Categoria save(Categoria categoria) {
        if (!categorias.contains(categoria)) {
            categoria.setId((long) categorias.size() + 1);
            categorias.add(categoria);
            return categoria;
        }else {
            JOptionPane.showMessageDialog(null,"ja existe categoria com este nome ");
            return null;
        }
    }


}
