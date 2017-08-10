/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataReader.AmbulanceDAO;
import DataReader.ExcelDataReader;
import DataReader.OccurrenceDAO;
import GoogleMapsAPI.GoogleStaticMap;
import SAMU.Ambulance;
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
        String geocodingApiKey = "AIzaSyBe73uIaOMxSt0rdHczRCbPZaR7hLAovb4";
        String directionsApiKey = "AIzaSyD9W0em7H723uVOMD6QFe_1Mns71XAi5JU";
        String staticMapKey = "AIzaSyBpval3mOcQgQ5PlCX8tV7Cm5k-E00_98A";
        String ambulancesTable = "AMBULANCES";
        //String filePath = "/home/renansantos/Área de Trabalho/Dados Samu/BD_SAMU_TESTE.xls";
        //String filePath = "/home/renansantos/Área de Trabalho/BD_SAMU_FINAL.xls";

        //List<Occurrence> occurrences = new ExcelDataReader(filePath).readDataFromWorkSheet();
        List<Ambulance> ambulances = new AmbulanceDAO(ambulancesTable).getAmbulances();
        List<Occurrence> occurrences = new OccurrenceDAO().getListOfOccurrencesWithIntegerTimes(ambulances);
        
        //occurrences.forEach(u -> System.out.println(u.getDisplacementToThePlaceDuration()));
        //System.out.println("Tamanho = " + occurrences.size());
        List<Occurrence> occurrencesForTest = occurrences.subList(0, 50);
        occurrencesForTest.forEach(o -> o.calculateDisplacementToThePlaceUsingAPI());
        occurrencesForTest.forEach(o -> o.saveDataInFile());
        //GoogleStaticMap map = new GoogleStaticMap(occurrencesForTest);
        //occurrencesForTest.forEach(o -> System.out.println(o.getLatLongOfAddress(geocodingApiKey)));
        //new OccurrenceDAO().addOccurrenceIntoDataBaseUsingIntegerTimes(occurrences);
    }

}
