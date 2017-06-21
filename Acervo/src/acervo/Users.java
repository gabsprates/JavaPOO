package acervo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Users {
    
    private final Connection conexao;
    
    Users(Connection conexao) {
        this.conexao = conexao;
    }
    
    /**
     * Busca usuário por ID
     * @param id
     * @return
     */
    public User getUserBy(Integer id) {
        return null;
    }
    

    /**
     * Busca usuário por username
     * @param username
     * @return
     */
    public User getUserBy(String username) {
        return null;
    }


    /**
     * Insere um novo usuário
     * @param user
     * @throws SQLException 
     */
    public void inserir(User user) throws SQLException {
        
        String SQL = "INSERT INTO users "
                + " (nome, user, senha) "
                + " VALUES (?, ?, ?) ";
        
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(SQL);

        stmt.setString(1, user.getNome());
        stmt.setString(2, user.getUser());
        stmt.setString(3, user.getSenha());

        stmt.execute();

    }
    
    
    
    
}
