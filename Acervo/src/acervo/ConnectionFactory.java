/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acervo;

import java.sql.*;

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
