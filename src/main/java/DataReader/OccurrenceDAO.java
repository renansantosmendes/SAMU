/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import SAMU.Ambulance;
import SAMU.Hospital;
import SAMU.Occurrence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;

/**
 *
 * @author renansantos
 */
public class OccurrenceDAO {

    private Connection connection = new ConnectionFactory().getConnection();
    private String tableName = "OCCURRENCES_TEST";

    public void addOccurrenceIntoDataBase(Occurrence occurrence) {
        String sql = "insert into " + this.tableName + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);

            statement.setString(1, Integer.toString(occurrence.getServiceNumber()));
            statement.setString(2, occurrence.getTransmissionTime().toString());
            statement.setString(3, occurrence.getPlaceArrivalTime().toString());
            statement.setString(4, occurrence.getPlaceDepartureTime().toString());
            statement.setString(5, occurrence.getHospitalArrivalTime().toString());
            statement.setString(6, occurrence.getAmbulanceReleaseTime().toString());
            statement.setString(7, occurrence.getAddress());
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

    public void addOccurrenceIntoDataBase(List<Occurrence> occurrences) {
        String sql = "insert into " + this.tableName + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            for (Occurrence occurrence : occurrences) {
                try {
                    statement.setString(1, Integer.toString(occurrence.getServiceNumber()));

                    statement.setString(2, occurrence.getTransmissionTime().toLocalTime().toString());

                    statement.setString(3, occurrence.getPlaceArrivalTime().toLocalTime().toString());
                    statement.setString(4, occurrence.getPlaceDepartureTime().toLocalTime().toString());
                    statement.setString(5, occurrence.getHospitalArrivalTime().toLocalTime().toString());
                    statement.setString(6, occurrence.getAmbulanceReleaseTime().toLocalTime().toString());
                    statement.setString(7, occurrence.getAddress());
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

    public void addOccurrenceIntoDataBaseUsingIntegerTimes(List<Occurrence> occurrences) {
        String sql = "insert into " + this.tableName + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            for (Occurrence occurrence : occurrences) {
                try {
                    statement.setString(1, Integer.toString(occurrence.getServiceNumber()));

                    setString(occurrence.getTransmissionTime(), statement, 2);
                    setString(occurrence.getPlaceArrivalTime(), statement, 3);
                    setString(occurrence.getPlaceDepartureTime(), statement, 4);
                    setString(occurrence.getHospitalArrivalTime(), statement, 5);
                    setString(occurrence.getAmbulanceReleaseTime(), statement, 6);

//                    statement.setString(3, occurrence.getPlaceArrivalTime().toLocalTime().toString());
//                    statement.setString(4, occurrence.getPlaceDepartureTime().toLocalTime().toString());
//                    statement.setString(5, occurrence.getHospitalArrivalTime().toLocalTime().toString());
//                    statement.setString(6, occurrence.getAmbulanceReleaseTime().toLocalTime().toString());
                    statement.setString(7, occurrence.getAddress());
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

    private void setString(LocalDateTime localDateTime, PreparedStatement statement, int stringNumber) throws SQLException {
        if (localDateTime == null) {
            statement.setString(stringNumber, "-100");
        } else {
            statement.setString(stringNumber, Integer.toString(localDateTime.getHour() * 60
                    + localDateTime.getMinute()));
        }
    }

    public List<Occurrence> getListOfOccurrences() {
        try {
            //String sql = "select * from " + this.tableName + " where service_number = 8174137";
            String sql = "select * from " + this.tableName;
            List<Occurrence> listOfOccurrences = new ArrayList<>();
            PreparedStatement statement = this.connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer serviceNumber = resultSet.getInt("service_number");
                LocalDate occurrenceDate = resultSet.getDate("occurrence_date").toLocalDate();

                LocalDateTime transmissionTime = LocalDateTime.of(occurrenceDate,
                        resultSet.getTime("transmission_time").toLocalTime());

                LocalDateTime placeArrivalTime = LocalDateTime.of(occurrenceDate,
                        resultSet.getTime("place_arrival_time").toLocalTime());

                LocalDateTime placeDepartureTime = LocalDateTime.of(occurrenceDate,
                        resultSet.getTime("place_departure_time").toLocalTime());

                LocalDateTime hospitalArrivalTime = LocalDateTime.of(occurrenceDate,
                        resultSet.getTime("hospital_arrival_time").toLocalTime());

                LocalDateTime ambulanceReleaseTime = LocalDateTime.of(occurrenceDate,
                        resultSet.getTime("ambulance_release_time").toLocalTime());

                placeArrivalTime = correctDays(transmissionTime, placeArrivalTime);
                placeDepartureTime = correctDays(placeArrivalTime, placeDepartureTime);
                hospitalArrivalTime = correctDays(placeDepartureTime, hospitalArrivalTime);
                ambulanceReleaseTime = correctDays(hospitalArrivalTime, ambulanceReleaseTime);

                String address = resultSet.getString("address");
                String neighborhood = resultSet.getString("neighborhood");
                String region1 = resultSet.getString("region1");
                String region2 = resultSet.getString("region2");
                String occurrence = resultSet.getString("occurrence");
                String occurrenceDetail = resultSet.getString("occurrence_detail");
                String hospitalName = resultSet.getString("hospital_name");
                Hospital hospital = new Hospital(hospitalName, "");
                String observation = resultSet.getString("observation");
                boolean betweenHospitals = (resultSet.getInt("between_hospitals") == 1) ? true : false;

                String ambulanceType = resultSet.getString("ambulance_type");
                int ambulanceId = Integer.parseInt(resultSet.getString("ambulance_id"));

                Ambulance ambulance = new Ambulance(ambulanceType, ambulanceId);
                String dayOfWeek = resultSet.getString("day_of_week");

                Occurrence samuOccurrence = new Occurrence(serviceNumber, transmissionTime, placeArrivalTime, placeDepartureTime,
                        hospitalArrivalTime, ambulanceReleaseTime, address, neighborhood, region1, region2, occurrence, occurrenceDetail,
                        hospital, observation, betweenHospitals, ambulance, occurrenceDate, dayOfWeek);

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

    private LocalDateTime correctDays(LocalDateTime dateTime1, LocalDateTime dateTime2) throws SQLException {
        if (dateTime1 != null && dateTime2 != null) {
            if (correctTime(dateTime1, dateTime2)) return dateTime2.plusDays(1);
        }
        return dateTime2;
    }

    private boolean correctTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if (Duration.between(dateTime1, dateTime2).toMinutes() < 0) {
            return true;
        }
        return false;
    }

    public List<Occurrence> getListOfOccurrencesWithIntegerTimes() {
        try {
            //String sql = "select * from " + this.tableName + " where service_number = 8172400";
            String sql = "select * from " + this.tableName;
            List<Occurrence> listOfOccurrences = new ArrayList<>();
            PreparedStatement statement = this.connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer serviceNumber = resultSet.getInt("service_number");
                LocalDate occurrenceDate = resultSet.getDate("occurrence_date").toLocalDate();
                LocalDateTime transmissionTime, placeArrivalTime, placeDepartureTime, hospitalArrivalTime, ambulanceReleaseTime;

                transmissionTime = loadIntegerTime(resultSet.getInt("transmission_time"), occurrenceDate);
                placeArrivalTime = loadIntegerTime(resultSet.getInt("place_arrival_time"), occurrenceDate);
                placeDepartureTime = loadIntegerTime(resultSet.getInt("place_departure_time"), occurrenceDate);
                hospitalArrivalTime = loadIntegerTime(resultSet.getInt("hospital_arrival_time"), occurrenceDate);
                ambulanceReleaseTime = loadIntegerTime(resultSet.getInt("ambulance_release_time"), occurrenceDate);

                placeArrivalTime = correctDays(transmissionTime, placeArrivalTime);
                placeDepartureTime = correctDays(placeArrivalTime, placeDepartureTime);
                hospitalArrivalTime = correctDays(placeDepartureTime, hospitalArrivalTime);
                ambulanceReleaseTime = correctDays(hospitalArrivalTime, ambulanceReleaseTime);

                String address = resultSet.getString("address");
                String neighborhood = resultSet.getString("neighborhood");
                String region1 = resultSet.getString("region1");
                String region2 = resultSet.getString("region2");
                String occurrence = resultSet.getString("occurrence");
                String occurrenceDetail = resultSet.getString("occurrence_detail");
                String hospitalName = resultSet.getString("hospital_name");
                Hospital hospital = new Hospital(hospitalName, "");
                String observation = resultSet.getString("observation");
                boolean betweenHospitals = (resultSet.getInt("between_hospitals") == 1) ? true : false;

                String ambulanceType = resultSet.getString("ambulance_type");
                int ambulanceId = Integer.parseInt(resultSet.getString("ambulance_id"));

                Ambulance ambulance = new Ambulance(ambulanceType, ambulanceId);
                String dayOfWeek = resultSet.getString("day_of_week");

                Occurrence samuOccurrence = new Occurrence(serviceNumber, transmissionTime, placeArrivalTime, placeDepartureTime,
                        hospitalArrivalTime, ambulanceReleaseTime, address, neighborhood, region1, region2, occurrence, occurrenceDetail,
                        hospital, observation, betweenHospitals, ambulance, occurrenceDate, dayOfWeek);
                samuOccurrence.calculateDisplacementToThePlaceDuration();
                samuOccurrence.calculateAmbulanceAttendanceDuration();
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

    private LocalDateTime loadIntegerTime(int integerTime, LocalDate occurrenceDate) throws SQLException {
        LocalDateTime transmissionTime;
        if (integerTime < 0) {
            transmissionTime = null;
        } else {
            transmissionTime = LocalDateTime.of(occurrenceDate, LocalTime.of(integerTime / 60, integerTime % 60));
        }
        return transmissionTime;
    }
}
