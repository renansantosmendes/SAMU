/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author renansantos
 */
public class ConnectionFactory {

    private String password = "dnweapons";
    private String database = "SAMU";
    private String user = "root";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?useLegacyDatetimeCode=true"
                    + "&serverTimezone=Brazil/East", user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
