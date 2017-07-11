/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import SAMU.Hospital;
import SAMU.SamuOccurrence;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;

/**
 *
 * @author renansantos
 */
public class ExcelDataReader {

    private String filePath;

    public ExcelDataReader(String filePath) {
        this.filePath = filePath;
    }

    public List<SamuOccurrence> readDataFromWorkSheet() throws IOException, BiffException {
        WorkbookSettings conf = new WorkbookSettings();
        conf.setEncoding("ISO-8859-1");
        Workbook workbook = Workbook.getWorkbook(new File(this.filePath),conf);
        Sheet sheet = workbook.getSheet(0);
        int rows = sheet.getRows();
        int columns = sheet.getColumns();
        System.out.println("Número de Linhas = " + rows);
        System.out.println("Iniciando a leitura da planilha XLS:");
        List<SamuOccurrence> occurrences = new ArrayList<>();
        for (int i = 1; i < rows; i++) {
            Cell id = sheet.getCell(0, i);
            Cell transmitionTime = sheet.getCell(1, i);
            Cell placeArrivalTime = sheet.getCell(2, i);
            Cell placeDepartureTime = sheet.getCell(3, i);
            Cell hospitalArrivalTime = sheet.getCell(4, i);
            Cell ambulanceReleaseTime = sheet.getCell(5, i);
            Cell adress = sheet.getCell(6, i);
            Cell neighborhood = sheet.getCell(7, i);
            Cell region1 = sheet.getCell(8, i);
            Cell region2 = sheet.getCell(9, i);
            Cell occurrence = sheet.getCell(10, i);
            Cell occurrenceDetail = sheet.getCell(11, i);
            Cell hospitalName = sheet.getCell(12, i);
            Cell observation = sheet.getCell(13, i);
            Cell betweenHospital = sheet.getCell(14, i);
            Cell ambulanceType = sheet.getCell(15, i);
            Cell ambulanceId = sheet.getCell(15, i);
            Cell occurrenceDay = sheet.getCell(18, i);
            Cell occurrenceMonth = sheet.getCell(19, i);
            Cell occurrenceYear = sheet.getCell(20, i);

            SamuOccurrence samuOccurrence = new SamuOccurrence();
            int nullValuesCounter = 0;

            if (id.getContents() == "") {
                samuOccurrence.setServiceNumber(0);
                nullValuesCounter++;
            } else {
                samuOccurrence.setServiceNumber(Integer.parseInt(id.getContents()));
            }

            if (transmitionTime.getContents() == "") {
                samuOccurrence.setTransmissionTime(LocalTime.of(0, 0));
                nullValuesCounter++;
            } else {
                String[] transmitionTimeString = transmitionTime.getContents().split(":");
                samuOccurrence.setTransmissionTime(LocalTime
                        .of(Integer.parseInt(transmitionTimeString[0]), Integer.parseInt(transmitionTimeString[1])));
            }

            if (placeArrivalTime.getContents() == "") {
                samuOccurrence.setPlaceArrivalTime(LocalTime.of(0, 0));
                nullValuesCounter++;
            } else {
                String[] placeArrivalTimeString = placeArrivalTime.getContents().split(":");
                samuOccurrence.setPlaceArrivalTime(LocalTime
                        .of(Integer.parseInt(placeArrivalTimeString[0]), Integer.parseInt(placeArrivalTimeString[1])));
            }

            if (placeDepartureTime.getContents() == "") {
                samuOccurrence.setPlaceDepartureTime(LocalTime.of(0, 0));
                nullValuesCounter++;
            } else {
                String[] placeDepartureTimeString = placeDepartureTime.getContents().split(":");
                samuOccurrence.setPlaceDepartureTime(LocalTime
                        .of(Integer.parseInt(placeDepartureTimeString[0]), Integer.parseInt(placeDepartureTimeString[1])));
            }

            if (hospitalArrivalTime.getContents() == "") {
                samuOccurrence.setHospitalArrivalTime(LocalTime.of(0, 0));
                nullValuesCounter++;
            } else {
                String[] transmitionTimeString = hospitalArrivalTime.getContents().split(":");
                samuOccurrence.setHospitalArrivalTime(LocalTime
                        .of(Integer.parseInt(transmitionTimeString[0]), Integer.parseInt(transmitionTimeString[1])));
            }

            if (ambulanceReleaseTime.getContents() == "") {
                samuOccurrence.setAmbulanceReleaseTime(LocalTime.of(0, 0));
                nullValuesCounter++;
            } else {
                String[] ambulanceReleaseTimeString = ambulanceReleaseTime.getContents().split(":");
                samuOccurrence.setAmbulanceReleaseTime(LocalTime
                        .of(Integer.parseInt(ambulanceReleaseTimeString[0]), Integer.parseInt(ambulanceReleaseTimeString[1])));
            }

            if (adress.getContents() == "") {
                samuOccurrence.setAdress("");
                nullValuesCounter++;
            } else {
                samuOccurrence.setAdress(adress.getContents());
            }

            if (neighborhood.getContents() == "") {
                samuOccurrence.setNeighborhood("");
                nullValuesCounter++;
            } else {
                samuOccurrence.setNeighborhood(neighborhood.getContents());
            }

            if (region1.getContents() == "") {
                samuOccurrence.setRegion1("");
                nullValuesCounter++;
            } else {
                samuOccurrence.setRegion1(region1.getContents());
            }

            if (region2.getContents() == "") {
                samuOccurrence.setRegion2("");
                nullValuesCounter++;
            } else {
                samuOccurrence.setRegion2(region2.getContents());
            }

            if (occurrence.getContents() == "") {
                samuOccurrence.setOccurrence("");
                nullValuesCounter++;
            } else {
                samuOccurrence.setOccurrence(occurrence.getContents());
            }

            if (occurrenceDetail.getContents() == "") {
                samuOccurrence.setOccurrenceDetail("");
                nullValuesCounter++;
            } else {
                samuOccurrence.setOccurrenceDetail(occurrenceDetail.getContents());
            }

            if (hospitalName.getContents() == "") {
                Hospital hospital = new Hospital("", "");
                samuOccurrence.setHospital(hospital);
                nullValuesCounter++;
            } else {
                Hospital hospital = new Hospital(hospitalName.getContents(), null);
                samuOccurrence.setHospital(hospital);
            }

            if (observation.getContents() == "") {
                samuOccurrence.setObservation("");
                nullValuesCounter++;
            } else {
                samuOccurrence.setObservation(observation.getContents());
            }

            if (betweenHospital.getContents().compareTo("") == 0) {
                System.out.println(betweenHospital.getContents());
                samuOccurrence.setBetweenHospitals(false);
                nullValuesCounter++;
            } else if (betweenHospital.getContents().toUpperCase().compareTo("SIM") == 0) {
                samuOccurrence.setBetweenHospitals(true);
            } else {
                samuOccurrence.setBetweenHospitals(false);
            }

            //TODO implements methods to ambulance type and id
            LocalDate occurrenceDate;
            if (occurrenceDay.getContents() == "" && occurrenceMonth.getContents() == "" && occurrenceYear.getContents() == "") {
                occurrenceDate = LocalDate.of(2000, 1, 1);
                samuOccurrence.setOccurrenceDate(occurrenceDate);
            } else {
                occurrenceDate = LocalDate.of(Integer.parseInt(occurrenceYear.getContents()),
                        Integer.parseInt(occurrenceMonth.getContents()), Integer.parseInt(occurrenceDay.getContents()));
                samuOccurrence.setOccurrenceDate(occurrenceDate);
            }

            if (nullValuesCounter >= 12) {
                i++;
            } else {
                occurrences.add(samuOccurrence);
            }
        }

        workbook.close();
        return occurrences;
    }
}
