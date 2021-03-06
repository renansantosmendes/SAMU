/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAMU;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.GeocodingResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.write.DateTime;

/**
 *
 * @author renansantos
 */
public class Occurrence {

    private int serviceNumber;
    private LocalDateTime transmissionTime;
    private LocalDateTime placeArrivalTime;
    private LocalDateTime placeDepartureTime;
    private LocalDateTime hospitalArrivalTime;
    private LocalDateTime ambulanceReleaseTime;
    private String address;
    private String neighborhood;
    private String region1;
    private String region2;
    private String occurrence;
    private String occurrenceDetail;
    private Hospital hospital;
    private String observation;
    private boolean betweenHospitals;
    private Ambulance ambulance;
    private LocalDate occurrenceDate;
    private String dayOfWeek;
    private Duration displacementToThePlaceDuration;
    private long displacementToThePlaceDistance;
    private Duration displacementToThePlaceDurationUsingAPI;
    private Duration ambulanceAttendanceDuration;
    private Duration displacementToTheHospitalDuration;
    private Duration displacementToTheHospitalDurationUsingAPI;
    private static String geocodingApiKey = "AIzaSyBe73uIaOMxSt0rdHczRCbPZaR7hLAovb4";
    private static String directionsApiKey = "AIzaSyD9W0em7H723uVOMD6QFe_1Mns71XAi5JU";
    private String formatedAddress;
    private static PrintStream file = null;
    private String folderName = "Results";
    private String fileName = "Test";

    public Occurrence() {

    }

    public Occurrence(int serviceNumber, LocalDateTime transmissionTime, LocalDateTime placeArrivalTime, LocalDateTime placeDepartureTime,
            LocalDateTime hospitalArrivalTime, LocalDateTime ambulanceReleaseTime,
            String adress, String neighborhood, String region1, String region2, String occurrence, String occurrenceDetail,
            Hospital hospital, String observation, boolean betweenHospitals, Ambulance ambulance, LocalDate occurrenceDate,
            String dayOfWeek) {

        this.serviceNumber = serviceNumber;
        this.transmissionTime = transmissionTime;
        this.placeArrivalTime = placeArrivalTime;
        this.placeDepartureTime = placeDepartureTime;
        this.hospitalArrivalTime = hospitalArrivalTime;
        this.ambulanceReleaseTime = ambulanceReleaseTime;
        this.address = adress;
        this.neighborhood = neighborhood;
        this.region1 = region1;
        this.region2 = region2;
        this.occurrence = occurrence;
        this.occurrenceDetail = occurrenceDetail;
        this.hospital = hospital;
        this.observation = observation;
        this.betweenHospitals = betweenHospitals;
        this.ambulance = ambulance;
        this.occurrenceDate = occurrenceDate;
        this.dayOfWeek = dayOfWeek;
        createFolderForData();
        initializeStream();
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public LocalDateTime getTransmissionTime() {
        return transmissionTime;
    }

    public LocalDateTime getPlaceArrivalTime() {
        return placeArrivalTime;
    }

    public LocalDateTime getPlaceDepartureTime() {
        return placeDepartureTime;
    }

    public LocalDateTime getHospitalArrivalTime() {
        return hospitalArrivalTime;
    }

    public LocalDateTime getAmbulanceReleaseTime() {
        return ambulanceReleaseTime;
    }

    public String getAddress() {
        return address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getRegion1() {
        return region1;
    }

    public String getRegion2() {
        return region2;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public String getOccurrenceDetail() {
        return occurrenceDetail;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public String getObservation() {
        return observation;
    }

    public boolean isBetweenHospitals() {
        return betweenHospitals;
    }

    public Ambulance getAmbulance() {
        return ambulance;
    }

    public LocalDate getOccurrenceDate() {
        return occurrenceDate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public void setTransmissionTime(LocalDateTime transmissionTime) {
        this.transmissionTime = transmissionTime;
    }

    public void setPlaceArrivalTime(LocalDateTime placeArrivalTime) {
        this.placeArrivalTime = placeArrivalTime;
    }

    public void setPlaceDepartureTime(LocalDateTime placeDepartureTime) {
        this.placeDepartureTime = placeDepartureTime;
    }

    public void setHospitalArrivalTime(LocalDateTime hospitalArrivalTime) {
        this.hospitalArrivalTime = hospitalArrivalTime;
    }

    public void setAmbulanceReleaseTime(LocalDateTime ambulanceReleaseTime) {
        this.ambulanceReleaseTime = ambulanceReleaseTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
    }

    public void setOccurrenceDetail(String occurrenceDetail) {
        this.occurrenceDetail = occurrenceDetail;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setBetweenHospitals(boolean betweenHospitals) {
        this.betweenHospitals = betweenHospitals;
    }

    public void setAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    public void setOccurrenceDate(LocalDate occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void calculateDisplacementToThePlaceDuration() {
        if (transmissionTime != null && placeArrivalTime != null) {
            this.displacementToThePlaceDuration = Duration.between(transmissionTime, placeArrivalTime);
        }
    }

    public long getDisplacementToThePlaceDistance() {
        return displacementToThePlaceDistance;
    }

    public String getFormatedAddress() {
        return formatedAddress;
    }

    public void calculateDisplacementToThePlaceUsingAPI() {
        String origin = this.ambulance.getBaseAddress();
        String destination = this.region2 + ",belo+horizonte";
        //String destination = this.address + "," + this.neighborhood + "," + this.region1 + ",belo+horizonte";

        GeoApiContext contextOrigin = new GeoApiContext().setApiKey(geocodingApiKey);
        GeoApiContext contextDestination = new GeoApiContext().setApiKey(geocodingApiKey);
        GeoApiContext geoApiContextSAMU = new GeoApiContext().setApiKey(directionsApiKey);
        GeocodingApiRequest originGeocoding = GeocodingApi.newRequest(contextOrigin);
        GeocodingApiRequest destinationGeocoding = GeocodingApi.newRequest(contextDestination);
        originGeocoding.address(origin);
        destinationGeocoding.address(destination);

        GeocodingResult[] originResult = null;
        GeocodingResult[] destinationResult = null;

        try {
            originResult = originGeocoding.await();
            destinationResult = destinationGeocoding.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("Origin = " + originResult[0].formattedAddress);
//        System.out.println("Destination = " + destinationResult[0].formattedAddress);

        this.formatedAddress = destinationResult[0].formattedAddress;

        DirectionsApiRequest directionsApiRequestSAMU = DirectionsApi.getDirections(geoApiContextSAMU,
                originResult[0].formattedAddress, destinationResult[0].formattedAddress);
        directionsApiRequestSAMU.alternatives(true);

        DirectionsResult routesBetweenNodesSAMU = null;
        try {
            routesBetweenNodesSAMU = directionsApiRequestSAMU.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        DirectionsRoute[] route = routesBetweenNodesSAMU.routes;
        DirectionsLeg[] directionsLeg = route[0].legs;

        this.displacementToThePlaceDurationUsingAPI = Duration.ofSeconds(directionsLeg[0].duration.inSeconds);
        this.displacementToThePlaceDistance = directionsLeg[0].distance.inMeters;
    }

    public void saveDataInFile() {
        file.print(this.serviceNumber + "\t" + this.displacementToThePlaceDuration.toMinutes()
                + "\t" + this.displacementToThePlaceDurationUsingAPI.toMinutes() + "\t" 
                + this.displacementToThePlaceDistance + "\t" + this.formatedAddress +"\n");
    }

    private void initializeStream() {
        try {
            file = new PrintStream(folderName + "/" + fileName + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createFolderForData() {
        boolean success = (new File(folderName)).mkdirs();
    }

    public Duration getDisplacementToThePlaceDuration() {
        return this.displacementToThePlaceDuration;
    }

    public Duration getDisplacementToThePlaceDurationUsingAPI() {
        return displacementToThePlaceDurationUsingAPI;
    }

    public void calculateAmbulanceAttendanceDuration() {
        if (placeArrivalTime != null && placeDepartureTime != null) {
            this.ambulanceAttendanceDuration = Duration.between(placeArrivalTime, placeDepartureTime);
        }

    }

    public Duration getAmbulanceAttendanceDuration() {
        return this.ambulanceAttendanceDuration;
    }

    public void calculateDisplacementToTheHospitalDuration() {
        if (placeDepartureTime != null && hospitalArrivalTime != null) {
            this.displacementToTheHospitalDuration = Duration.between(placeDepartureTime, hospitalArrivalTime);
        }
    }

    public Duration getDisplacementToTheHospitalDuration() {
        return this.displacementToTheHospitalDuration;
    }

    public String getLatLongOfAddress(String geocodingApiKey) {
        GeoApiContext contextForGeocoding = new GeoApiContext().setApiKey(geocodingApiKey);
        String address = this.address + "," + this.neighborhood + "," + this.region1 + ",belo+horizonte";
        GeocodingApiRequest geocoding = GeocodingApi.newRequest(contextForGeocoding);
        geocoding.address(address);

        GeocodingResult[] geocodingResult = null;
        try {
            geocodingResult = geocoding.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Original Adress = " + address);
        if (geocodingResult.length == 0) {
            return "&markers=color:red|" + "";
        } else {
            return "&markers=color:red|" + geocodingResult[0].geometry.location.toString();
        }

    }

    @Override
    public String toString() {
        return this.serviceNumber + "\t"
                + this.transmissionTime + "\t"
                + this.placeArrivalTime + "\t"
                + this.placeDepartureTime + "\t"
                + this.hospitalArrivalTime + "\t"
                + this.ambulanceReleaseTime + "\t"
                + this.address + "\t"
                + this.neighborhood + "\t"
                + this.region1 + "\t"
                + this.region2 + "\t"
                + this.occurrence + "\t"
                + this.occurrenceDetail + "\t"
                + this.hospital + "\t"
                + this.observation + "\t"
                + this.betweenHospitals + "\t"
                + this.ambulance + "\t"
                + this.occurrenceDate + "\t"
                + this.dayOfWeek;
    }
}
