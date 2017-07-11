/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAMU;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jxl.write.DateTime;

/**
 *
 * @author renansantos
 */
public class SamuOccurrence {

    private int serviceNumber;
    private LocalTime transmissionTime;
    private LocalTime placeArrivalTime;
    private LocalTime placeDepartureTime;
    private LocalTime hospitalArrivalTime;
    private LocalTime ambulanceReleaseTime;
    private String adress;
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

    public SamuOccurrence() {

    }

    public SamuOccurrence(int serviceNumber, LocalTime transmissionTime, LocalTime placeArrivalTime, LocalTime placeDepartureTime,
            LocalTime hospitalArrivalTime, LocalTime ambulanceReleaseTime,
            String adress, String neighborhood, String region1, String region2, String occurrence, String occurrenceDetail,
            Hospital hospital, String observation, boolean betweenHospitals, Ambulance ambulance, LocalDate occurrenceDate,
            String dayOfWeek) {

        this.serviceNumber = serviceNumber;
        this.transmissionTime = transmissionTime;
        this.placeArrivalTime = placeArrivalTime;
        this.placeDepartureTime = placeDepartureTime;
        this.hospitalArrivalTime = hospitalArrivalTime;
        this.ambulanceReleaseTime = ambulanceReleaseTime;
        this.adress = adress;
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
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public LocalTime getTransmissionTime() {
        return transmissionTime;
    }

    public LocalTime getPlaceArrivalTime() {
        return placeArrivalTime;
    }

    public LocalTime getPlaceDepartureTime() {
        return placeDepartureTime;
    }

    public LocalTime getHospitalArrivalTime() {
        return hospitalArrivalTime;
    }

    public LocalTime getAmbulanceReleaseTime() {
        return ambulanceReleaseTime;
    }

    public String getAdress() {
        return adress;
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

    public void setTransmissionTime(LocalTime transmissionTime) {
        this.transmissionTime = transmissionTime;
    }

    public void setPlaceArrivalTime(LocalTime placeArrivalTime) {
        this.placeArrivalTime = placeArrivalTime;
    }

    public void setPlaceDepartureTime(LocalTime placeDepartureTime) {
        this.placeDepartureTime = placeDepartureTime;
    }

    public void setHospitalArrivalTime(LocalTime hospitalArrivalTime) {
        this.hospitalArrivalTime = hospitalArrivalTime;
    }

    public void setAmbulanceReleaseTime(LocalTime ambulanceReleaseTime) {
        this.ambulanceReleaseTime = ambulanceReleaseTime;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

}
