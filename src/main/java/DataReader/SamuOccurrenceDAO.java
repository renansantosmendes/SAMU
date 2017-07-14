/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import SAMU.SamuOccurrence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;

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

    public List<SamuOccurrence> getListOfOccurrences() {
        try {
            String sql = "select * from " + this.tableName;
            List<SamuOccurrence> listOfOccurrences = new ArrayList<>();
            PreparedStatement statement = this.connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("service_number");
                //LocalTime transmitionTime = LocalTime.of(0, 0)resultSet.getTime("place_arrival_time").toLocalTime();
//                Cell placeArrivalTime = sheet.getCell(2, i);
//                Cell placeDepartureTime = sheet.getCell(3, i);
//                Cell hospitalArrivalTime = sheet.getCell(4, i);
//                Cell ambulanceReleaseTime = sheet.getCell(5, i);
//                Cell adress = sheet.getCell(6, i);
//                Cell neighborhood = sheet.getCell(7, i);
//                Cell region1 = sheet.getCell(8, i);
//                Cell region2 = sheet.getCell(9, i);
//                Cell occurrence = sheet.getCell(10, i);
//                Cell occurrenceDetail = sheet.getCell(11, i);
//                Cell hospitalName = sheet.getCell(12, i);
//                Cell observation = sheet.getCell(13, i);
//                Cell betweenHospital = sheet.getCell(14, i);
//                Cell ambulanceType = sheet.getCell(15, i);
//                Cell ambulanceId = sheet.getCell(16, i);
//                Cell occurrenceDay = sheet.getCell(18, i);
//                Cell occurrenceMonth = sheet.getCell(19, i);
//                Cell occurrenceYear = sheet.getCell(20, i);
//
//                Integer requestId = resultSet.getInt("id");
//
//                Integer deliveryTimeWindowUpper = 60 * (resultSet.getTime("deliveryTimeWindowUpper").toLocalTime().getHour())
//                        + resultSet.getTime("deliveryTimeWindowUpper").toLocalTime().getMinute() + valueAdded;
//                
                SamuOccurrence samuOccurrence = new SamuOccurrence();
                listOfOccurrences.add(samuOccurrence);
            }
            resultSet.close();
            statement.close();
            this.connection.close();
            return listOfOccurrences;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
