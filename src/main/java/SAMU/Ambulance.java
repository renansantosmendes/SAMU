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
    private String ambalanceType;
    private int ambulanceId;

    public Ambulance(String ambalanceType, int ambulanceId) {
        this.ambalanceType = ambalanceType;
        this.ambulanceId = ambulanceId;
    }

    public String getAmbalanceType() {
        return ambalanceType;
    }

    public void setAmbalanceType(String ambalanceType) {
        this.ambalanceType = ambalanceType;
    }

    public int getAmbulanceId() {
        return ambulanceId;
    }

    public void setAmbulanceId(int ambulanceId) {
        this.ambulanceId = ambulanceId;
    }
    
    
}
