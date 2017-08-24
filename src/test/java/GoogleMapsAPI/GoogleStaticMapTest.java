/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleMapsAPI;

import DataReader.OccurrenceDAO;
import SAMU.Occurrence;
import java.io.File;
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
public class GoogleStaticMapTest {

    public GoogleStaticMapTest() {
    }

    @Test
    public void testGetPathForGoogleMap() {
        String geocodingApiKey = "AIzaSyBe73uIaOMxSt0rdHczRCbPZaR7hLAovb4";
        String staticMapKey = "AIzaSyBpval3mOcQgQ5PlCX8tV7Cm5k-E00_98A";
        
        List<Occurrence> occurrences = new OccurrenceDAO().getListOfOccurrencesWithIntegerTimes();
        List<Occurrence> occurrencesForTest = occurrences.subList(0, 10);
        System.out.println("Tamanho = " + occurrencesForTest.size());

        assertEquals(10, occurrencesForTest.size());
        occurrencesForTest.forEach(o -> o.getLatLongOfAddress(geocodingApiKey));
        
        //GoogleStaticMap map = new GoogleStaticMap(occurrencesForTest);
    }

}
