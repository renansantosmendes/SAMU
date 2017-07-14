/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exceltest;

import DataReader.ExcelDataReader;
import DataReader.SamuOccurrenceDAO;
import SAMU.SamuOccurrence;
import java.io.*;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import jxl.read.biff.BiffException;

/**
 *
 * @author renansantos
 */
public class Main {

    public static void main(String[] args) throws IOException, BiffException, SQLException {
        //String filePath = "/home/renansantos/Área de Trabalho/Dados Samu/BD_SAMU_TESTE.xls";
        String filePath = "/home/renansantos/Área de Trabalho/BD_SAMU_FINAL.xls";

        List<SamuOccurrence> occurrences = new ExcelDataReader(filePath).readDataFromWorkSheet();
        occurrences.forEach(u -> System.out.println(u));
        //occurrences.forEach(u -> System.out.println(u.getAmbulance().getAmbulanceType()));
        
        //SamuOccurrence occurrence = occurrences.get(0);
        //new SamuOccurrenceDAO().addOccurrenceIntoDataBase(occurrences);
        
        //occurrences.forEach(u -> {System.out.println(Duration.between(u.getTransmissionTime(), u.getPlaceArrivalTime()).toMinutes());});
        System.out.println("Number of Occurrences = " + occurrences.size());

    }

}
