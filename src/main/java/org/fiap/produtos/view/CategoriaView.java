package org.fiap.produtos.view;

import org.fiap.produtos.Repository.CategoriaCollectionRepository;
import org.fiap.produtos.model.Categoria;

import javax.swing.*;

public class CategoriaView {
     static CategoriaCollectionRepository repository;

     public static Categoria select(Categoria categoria) {

            Categoria ret = (Categoria) JOptionPane.showInputDialog(
                    null, // componente pai. Como não temos será null
                    "Selecione uma categoria",
                    "Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null, // icone
                    repository.findAll().toArray(), // Número da opção
                    categoria == null ? 1 : categoria);
            return ret;
     }
     public void sucesso () {
             JOptionPane.showMessageDialog(null, "Categoria salva");
     }
     public void sucesso (Categoria categoria) {
         JOptionPane.showMessageDialog(null, "Categoria " + categoria.getNome() + "foi salva com sucesso ");
     }
     public static Categoria form (Categoria categoria) {
         String nome = JOptionPane.showInputDialog(null, " informe o nome a categoria", categoria!=null? categoria.getNome():"");
         return new Categoria(nome);
     }
}

