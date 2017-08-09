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
public class AmbulanceDAOTest {
    
    public AmbulanceDAOTest() {
    }

    @Test
    public void testGetAmbulances() throws Exception {
        String table = "AMBULANCES";
        assertEquals(6, new AmbulanceDAO(table).getAmbulances().size());
    }
    
}
