/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import SAMU.Occurrence;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/**
 *
 * @author renansantos
 */
public class InstanceReaderUsingExcel {

    private List<String> facilities = new ArrayList<>();
    private List<String> demand = new ArrayList<>();
    private String filePath;

    public InstanceReaderUsingExcel(String filePath) {
        this.filePath = filePath;

        try {
            readDataFromWorkSheet();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (BiffException ex) {
            ex.printStackTrace();
        }
    }

    private void readDataFromWorkSheet() throws IOException, BiffException {
        WorkbookSettings conf = new WorkbookSettings();
        conf.setEncoding("ISO-8859-1");
        Workbook workbook = Workbook.getWorkbook(new File(this.filePath), conf);
        Sheet demandSheet = workbook.getSheet(0);
        Sheet facilitySheet = workbook.getSheet(1);
        int demandRows = demandSheet.getRows();
        int demandColumns = demandSheet.getColumns();

        int facilityRows = facilitySheet.getRows();
        int facilityColumns = facilitySheet.getColumns();

        System.out.println("Número de Linhas = " + demandRows);
        System.out.println("Iniciando a leitura da planilha XLS:");

        for (int i = 1; i < demandRows; i++) {
            Cell demandAddress = demandSheet.getCell(0, i);
            demand.add(demandAddress.getContents());
        }

        for (int i = 1; i < facilityRows; i++) {
            Cell facilityAddress = facilitySheet.getCell(1, i);
            facilities.add(facilityAddress.getContents());
        }
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public List<String> getDemand() {
        return demand;
    }
    
    

}
