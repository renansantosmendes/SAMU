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
        
    }

}
