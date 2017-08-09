/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataReader;

import SAMU.Ambulance;
import java.util.List;
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
        String ambulancesTable = "AMBULANCES";
        List<Ambulance> ambulances =  new AmbulanceDAO(ambulancesTable).getAmbulances();
        int id = 3;
        for(Ambulance ambulance: ambulances){
            if(id == ambulance.getAmbulanceId()){
                System.out.println(ambulance);
            }
        }
        
        assertEquals(6, ambulances.size());
    }
    
}
