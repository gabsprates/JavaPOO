package acervo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gabriel
 */
public class Users {
    
    private final String tabela = "users";
    private final Connection conexao;
    
    Users(Connection conexao) {
        this.conexao = conexao;
    }
    

    /**
     * Busca usuário por username
     * @param username
     * @return
     * @throws java.sql.SQLException
     */
    public User getUserBy(String username) throws SQLException {
        
        User usuario = null;
        
        String SQL = " SELECT * FROM " + this.tabela
                + " WHERE user = ? "
                + " ORDER BY id LIMIT 1 ";
        
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(SQL);

        stmt.setString(1, username);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            usuario = new User();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setUser(rs.getString("user"));
            usuario.setSenha(rs.getString("senha"));

        }
        
        return usuario;
    }


    /**
     * Insere um novo usuário
     * @param user
     * @throws SQLException 
     */
    public void inserir(User user) throws SQLException {
        
        String SQL = "INSERT INTO " + this.tabela
                + " (nome, user, senha) "
                + " VALUES (?, ?, ?) ";
        
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(SQL);
        
        if (null == this.getUserBy(user.getUser())) {

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getUser());
            stmt.setString(3, user.getSenha());

            stmt.execute();
            
        } else {
            throw new SQLException("Já existe um cadastro com este usuário.");
        }


    }
    
    
    
    
}
