/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAMU;

/**
 *
 * @author renansantos
 */
public class Ambulance {

    private String ambulanceType;
    private int ambulanceId;
    private String baseAddress = null;

    public Ambulance(String ambalanceType, int ambulanceId) {
        this.ambulanceType = ambalanceType;
        this.ambulanceId = ambulanceId;
    }

    public Ambulance(String ambulanceType, int ambulanceId, String baseAddress) {
        this.ambulanceType = ambulanceType;
        this.ambulanceId = ambulanceId;
        this.baseAddress = baseAddress;
    }

    public String getAmbulanceType() {
        return ambulanceType;
    }

    public void setAmbulanceType(String ambulanceType) {
        this.ambulanceType = ambulanceType;
    }

    public int getAmbulanceId() {
        return ambulanceId;
    }

    public void setAmbulanceId(int ambulanceId) {
        this.ambulanceId = ambulanceId;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String toString() {
        return this.ambulanceType + "\t" + this.ambulanceId + "\t" + this.baseAddress;
    }
}
