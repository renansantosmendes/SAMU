/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exceltest;

import DataReader.ExcelDataReader;
import DataReader.OccurrenceDAO;
import SAMU.Occurrence;
import java.io.*;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jxl.read.biff.BiffException;

/**
 *
 * @author renansantos
 */
public class Main {

    public static void main(String[] args) throws IOException, BiffException, SQLException {
        //String filePath = "/home/renansantos/Área de Trabalho/Dados Samu/BD_SAMU_TESTE.xls";
        String filePath = "/home/renansantos/Área de Trabalho/BD_SAMU_FINAL.xls";

        //List<SamuOccurrence> occurrences = new ExcelDataReader(filePath).readDataFromWorkSheet();
        List<Occurrence> occurrences = new OccurrenceDAO().getListOfOccurrences();
        occurrences.forEach(u -> System.out.println(u));
        //occurrences.forEach(u -> u.calculateDisplacementToThePlaceDuration());
        //occurrences.forEach(u -> System.out.println(u.getDisplacementToThePlaceDuration().toMinutes()));
        //occurrences.forEach(u -> System.out.println(u.getAmbulance().getAmbulanceType()));
        //SamuOccurrence occurrence = occurrences.get(0);
        //new OccurrenceDAO().addOccurrenceIntoDataBase(occurrences);
        //occurrences.forEach(u -> {System.out.println(Duration.between(u.getTransmissionTime(), u.getPlaceArrivalTime()).toMinutes());});
        //System.out.println("Number of Occurrences = " + occurrences.size());
        LocalDate date = LocalDate.now();
        LocalDateTime ldt1 = LocalDateTime.of(date, LocalTime.now());
        LocalDateTime ldt2 = LocalDateTime.of(date, LocalTime.now().plusHours(1));
        System.out.println(date);
        System.out.println(ldt1);
        System.out.println(ldt2);

        System.out.println("Duration between = " + Duration.between(ldt1, ldt2));
        if(Duration.between(ldt1, ldt2).toMinutes() < 0){
            ldt2 = LocalDateTime.of(date.plusDays(1), LocalTime.now().plusHours(1));
        }else{
            System.out.println("Positive");
        }
        
        System.out.println(ldt2);
        System.out.println("Duration between = " + Duration.between(ldt1, ldt2).toMinutes());
    }

}
