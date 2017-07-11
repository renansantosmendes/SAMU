/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exceltest;

import DataReader.ExcelDataReader;
import java.io.*;
import java.sql.SQLException;
import jxl.read.biff.BiffException;

/**
 *
 * @author renansantos
 */
public class Main {

    public static void main(String[] args) throws IOException, BiffException, SQLException {
        String filePath = "/home/renansantos/Área de Trabalho/Dados Samu/BD_SAMU_TESTE.xls";
        new ExcelDataReader(filePath).readDataFromWorkSheet();

        
    }

}
