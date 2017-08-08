/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAMU;

import DataReader.OccurrenceDAO;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author renansantos
 */
public class OccurrenceTest {

    public OccurrenceTest() {
    }
    @Test
    public void getLatLongTest() {
        String geocodingApiKey = "AIzaSyBe73uIaOMxSt0rdHczRCbPZaR7hLAovb4";
        List<Occurrence> occurrences = new OccurrenceDAO().getListOfOccurrencesWithIntegerTimes();
        
        List<Occurrence> occurrencesForTest = occurrences.subList(0, 10);
        System.out.println("Tamanho = " + occurrencesForTest.size());
        
        
        assertEquals(10, occurrencesForTest.size());
        occurrencesForTest.forEach(o -> o.getLatLongOfAddress(geocodingApiKey));
    }
}
