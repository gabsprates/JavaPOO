package acervo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author gabriel
 */
public class ConnectionFactory {
    
    public Connection getConnection() throws SQLException, FileNotFoundException, IOException {

        FileInputStream file = new FileInputStream("ConfigDB.xml");

        Properties props = new Properties();        
        props.loadFromXML(file);
        
        String hostaddr = props.getProperty("hostaddr");
        String hostport = props.getProperty("hostport");
        String database = props.getProperty("database");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        
        String url = "jdbc:mysql://" + hostaddr + ':' + hostport + '/' + database;

        return DriverManager.getConnection(url, username, password);
    
    }

}
