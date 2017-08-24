/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renansantos
 */
public class InstanceReaderUsingExcelTest {
    
    public InstanceReaderUsingExcelTest() {
    }

    @Test
    public void testReadDataFromWorkSheet() throws Exception {
        String filePath = "/home/renansantos/Área de Trabalho/Planilhas SAMU/Instancia.xls";
        InstanceReaderUsingExcel reader = new InstanceReaderUsingExcel(filePath);

        assertEquals(639, reader.getDemand().size());
        assertEquals(1684, reader.getFacilities().size());
    }
    
}
