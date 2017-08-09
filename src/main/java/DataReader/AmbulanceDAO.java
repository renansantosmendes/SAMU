/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import SAMU.Ambulance;
import SAMU.Occurrence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renansantos
 */
public class AmbulanceDAO {

    private Connection connection = new ConnectionFactory().getConnection();
    private String tableName;

    public AmbulanceDAO(String tableName) {
        this.tableName = tableName;
    }

    public List<Ambulance> getAmbulances() throws SQLException {
        String sql = "select * from " + this.tableName;
        List<Ambulance> ambulances = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            String address = resultSet.getString("address");
            Ambulance ambulance = new Ambulance(type, id, address);
            ambulances.add(ambulance);
        }
        resultSet.close();
        statement.close();
        this.connection.close();
        return ambulances;
    }
}
