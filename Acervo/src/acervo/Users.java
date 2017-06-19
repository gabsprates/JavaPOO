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
    
    
    public ArrayList<Livros> getUsers() {
        return new ArrayList<>();
    }
    
    
    public void inserir(User user) {
        
        String SQL = "INSERT INTO users "
                + " (nome, user, senha) "
                + " VALUES (?, ?, ?) ";
        
        PreparedStatement stmt = null;

        try {

            stmt = this.conexao.prepareStatement(SQL);

            stmt.setString(0, user.getNome());
            stmt.setString(1, user.getUser());
            stmt.setString(2, user.getSenha());
            
            boolean executou = stmt.execute();
            
            if (!executou) {
                throw new SQLException("deu erro aqui");
            }

        } catch (SQLException ex) {

            System.out.println(Users.class.getName() + " :: " + ex.getMessage());

        }
        
    }
    
}
