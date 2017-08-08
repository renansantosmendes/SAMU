/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleMapsAPI;

import SAMU.Occurrence;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author renansantos
 */
public class GoogleStaticMap {

    private List<Occurrence> occurrences;
    private final String URLRoot = "https://maps.googleapis.com/maps/api/staticmap?center=";
    private final String directionsApiKey = "AIzaSyCgaZr9fRAUs3_8lftkt026_MfZ3yZVN4E";
    private final String staticMapKey = "AIzaSyBpval3mOcQgQ5PlCX8tV7Cm5k-E00_98A";
    private final String geocodingApiKey = "AIzaSyBe73uIaOMxSt0rdHczRCbPZaR7hLAovb4";
    private StringBuilder stringOfMarkers = new StringBuilder();
    private StringBuilder polylines = new StringBuilder();
    private StringBuilder polylinesForAllRotes = new StringBuilder();
    private String mapCenter;
    private String city;
    private String state;
    private String country;
    private int zoom;
    private int scale = 2;
    private int width = 1200;
    private int height = 1200;
    private String mapType = "roadmap";
    private int weight = 5;
    private StringBuilder waypoints = new StringBuilder();
    private StringBuilder encodedPolylines = new StringBuilder();
    private StringBuilder pathGeneratedForAllRoutes = new StringBuilder();
    private static int totalOfRoutes = 0;
    private String staticMapsFolder = "StaticMaps";
    private Set<List<Integer>> routesOfStopPoints;
    private List<Integer> route;
    private String adjacenciesTable;
    private String nodesTable;

    public GoogleStaticMap(List<Occurrence> occurrences) {
        this.occurrences = occurrences;
        boolean successForCreateStaticMapsFolder = (new File(staticMapsFolder)).mkdirs();

        buildStringWithNodeMarkets();
        setParametersForMediumInstances();
        try {
            this.buildMapInWindow();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void buildStringWithNodeMarkets() {
        for (int i = 0; i < this.occurrences.size(); i++) {
            stringOfMarkers.append(this.occurrences.get(i).getLatLongOfAddress(geocodingApiKey));
        }
    }

    private URL buildURL() throws MalformedURLException, IOException {
        URL url = new URL(URLRoot + mapCenter + "," + city + "," + state + "," + country + "&zoom=" + zoom + "&scale=" + scale
                + "&size=" + width + "x" + height + "&maptype=" + mapType + stringOfMarkers.toString()
                + pathGeneratedForAllRoutes + "&key=" + staticMapKey + "&format=jpg");
        return url;
    }

    private void buildMapInWindow() throws IOException {
        JFrame frame = new JFrame("Google Maps");

        String destinationFile = staticMapsFolder + "/occurrences.jpg";

        try {
            String imageUrl = this.buildURL().toString();
            System.out.println(imageUrl);

            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (this.routesOfStopPoints == null) {
            frame.add(new JLabel(new ImageIcon((new ImageIcon(destinationFile)).getImage()
                    .getScaledInstance(730, 700, java.awt.Image.SCALE_SMOOTH))));
            System.out.println(destinationFile);
        } else {
            frame.add(new JLabel(new ImageIcon(new ImageIcon(destinationFile).getImage()
                    .getScaledInstance(730, 700, java.awt.Image.SCALE_SMOOTH))));
        }

        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setParametersForMediumInstances() {
        this.mapCenter = "centro";
        this.city = "Belo+Horizonte";
        this.state = "Minas+Gerais";
        this.country = "Brasil";
        this.zoom = 11;
        this.scale = 2;
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
