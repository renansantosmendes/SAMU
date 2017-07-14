/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import SAMU.SamuOccurrence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author renansantos
 */
public class SamuOccurrenceDAO {

    private Connection connection = new ConnectionFactory().getConnection();
    private String tableName = "OCCURRENCES_1617";

    public void addOccurrenceIntoDataBase(SamuOccurrence occurrence) {
        String sql = "insert into " + this.tableName + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);

            statement.setString(1, Integer.toString(occurrence.getServiceNumber()));
            statement.setString(2, occurrence.getTransmissionTime().toString());
            statement.setString(3, occurrence.getPlaceArrivalTime().toString());
            statement.setString(4, occurrence.getPlaceDepartureTime().toString());
            statement.setString(5, occurrence.getHospitalArrivalTime().toString());
            statement.setString(6, occurrence.getAmbulanceReleaseTime().toString());
            statement.setString(7, occurrence.getAdress());
            statement.setString(8, occurrence.getNeighborhood());
            statement.setString(9, occurrence.getRegion1());
            statement.setString(10, occurrence.getRegion2());
            statement.setString(11, occurrence.getOccurrence());
            statement.setString(12, occurrence.getOccurrenceDetail());
            statement.setString(13, occurrence.getHospital().getHospitalName());
            statement.setString(14, occurrence.getObservation());
            if (occurrence.isBetweenHospitals()) {
                statement.setString(15, "1");
            } else {
                statement.setString(15, "0");
            }
            statement.setString(16, occurrence.getAmbulance().getAmbulanceType());
            statement.setString(17, Integer.toString(occurrence.getAmbulance().getAmbulanceId()));
            statement.setString(18, occurrence.getOccurrenceDate().toString());
            statement.setString(19, occurrence.getDayOfWeek());

            //statement.setString(7, deliveryTimeWindowUpper.toLocalTime().toString());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addOccurrenceIntoDataBase(List<SamuOccurrence> occurrences) {
        String sql = "insert into " + this.tableName + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            for (SamuOccurrence occurrence : occurrences) {
                try {
                    statement.setString(1, Integer.toString(occurrence.getServiceNumber()));
                    statement.setString(2, occurrence.getTransmissionTime().toString());
                    statement.setString(3, occurrence.getPlaceArrivalTime().toString());
                    statement.setString(4, occurrence.getPlaceDepartureTime().toString());
                    statement.setString(5, occurrence.getHospitalArrivalTime().toString());
                    statement.setString(6, occurrence.getAmbulanceReleaseTime().toString());
                    statement.setString(7, occurrence.getAdress());
                    statement.setString(8, occurrence.getNeighborhood());
                    statement.setString(9, occurrence.getRegion1());
                    statement.setString(10, occurrence.getRegion2());
                    statement.setString(11, occurrence.getOccurrence());
                    statement.setString(12, occurrence.getOccurrenceDetail());
                    statement.setString(13, occurrence.getHospital().getHospitalName());
                    statement.setString(14, occurrence.getObservation());
                    if (occurrence.isBetweenHospitals()) {
                        statement.setString(15, "1");
                    } else {
                        statement.setString(15, "0");
                    }
                    statement.setString(16, occurrence.getAmbulance().getAmbulanceType());
                    statement.setString(17, Integer.toString(occurrence.getAmbulance().getAmbulanceId()));
                    statement.setString(18, occurrence.getOccurrenceDate().toString());
                    statement.setString(19, occurrence.getDayOfWeek());
                    statement.execute();
                } catch (SQLException e) {
                    System.out.println("Ocorrencia com erro = " + occurrence);
                    throw new RuntimeException(e);
                }
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
