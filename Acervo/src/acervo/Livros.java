package acervo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Livros {
    
    private final String tabela = "livros";
    private final Connection conexao;
    private User usuario;
    
    Livros(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
    

    /**
     * Busca livro
     * @param termo
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<Livro> buscar(String termo) throws SQLException {
        
        ArrayList<Livro> livros = new ArrayList<>();
        
        String SQL = " SELECT * FROM " + this.tabela
                + " WHERE user = ? "
                + " AND ( titulo LIKE ?  OR autor LIKE ? )"
                + " ORDER BY id ";
        
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(SQL);

        stmt.setInt(1, this.usuario.getId());
        stmt.setString(2, '%' + termo + '%');
        stmt.setString(3, '%' + termo + '%');
        
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {

            Livro livro = new Livro();
            livro.setId(rs.getInt("id"));
            livro.setAutor(rs.getString("autor"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setUserId(rs.getInt("user"));
            
            livros.add(livro);

        }
        
        return livros;
    }


    /**
     * Insere um novo livro
     * @param livro
     * @throws SQLException 
     */
    public void inserir(Livro livro) throws SQLException {
        
        String SQL = "INSERT INTO " + this.tabela
                + " (user, titulo, autor) "
                + " VALUES (?, ?, ?) ";
        
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(SQL);
        
        stmt.setInt(1, this.usuario.getId());
        stmt.setString(2, livro.getTitulo());
        stmt.setString(3, livro.getAutor());

        stmt.execute();
            
    }
    
    
    public void apagar(int id) throws SQLException {
        
        String SQL = "DELETE FROM " + this.tabela
                + " WHERE user = ? "
                + " AND id = ? ";
        
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(SQL);
        
        stmt.setInt(1, this.usuario.getId());
        stmt.setInt(2, id);

        
        stmt.execute();
        
    }
    
}
