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

    public Ambulance(String ambalanceType, int ambulanceId) {
        this.ambulanceType = ambalanceType;
        this.ambulanceId = ambulanceId;
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
    
    
}
