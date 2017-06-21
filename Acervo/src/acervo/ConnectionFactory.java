package acervo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author gabriel
 */
public class ConnectionFactory {
    
    private final String hostaddr = "172.17.0.2";
    private final String hostport = "3306";
    private final String database = "acervo";
    private final String username = "root";
    private final String password = "teste";
    
    public Connection getConnection() throws SQLException {
    
        String url = "jdbc:mysql://" + this.hostaddr + '/' + this.database;

        return DriverManager.getConnection(url, this.username, this.password);
    
    }

}
