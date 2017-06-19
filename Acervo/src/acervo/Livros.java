/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acervo;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Livros {
    
    private final Connection conexao;
    
    Livros(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public ArrayList<Livros> getLivros() {
        return new ArrayList<>();
    }
    
    
    public void insertLivro(Livro livro) {
        
        String SQL = "INSERT INTO livros "
                + " () "
                + " VALUES () ";
        
    }
}
