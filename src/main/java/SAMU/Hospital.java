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
public class Hospital {

    private String hospitalName;
    private String hospitalAdress;

    public Hospital(String hospitalName, String hospitalAdress) {
        this.hospitalName = hospitalName;
        this.hospitalAdress = hospitalAdress;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAdress() {
        return hospitalAdress;
    }

    public void setHospitalAdress(String hospitalAdress) {
        this.hospitalAdress = hospitalAdress;
    }

}
