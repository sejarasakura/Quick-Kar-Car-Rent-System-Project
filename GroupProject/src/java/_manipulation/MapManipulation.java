package _manipulation;

import _domain.DistanceMatricRespond;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import _domain.*;

public class MapManipulation {
    public static final String HTTP_WEB_URL = "https://maps.googleapis.com/maps/api/distancematrix/";
    public static final String API_KEY = "AIzaSyCG24EIIq1K0uhrWm2_LUTF3W3KeVcDqWw";
    public static final String REQUEST_DENIED = "REQUEST_DENIED";
    public static final String INVALID_REQUEST = "INVALID_REQUEST";
    public static final String OK = "OK";
    public static void main(String[] args) {
        DistanceMatricRespond x = MapManipulation.getResponse();
        String xx = "The distance is : " + x.getDistance_text();
        System.out.println(xx);
    }
    public static DistanceMatricRespond getResponse(String place_id_1, String place_id_2){
        String url= HTTP_WEB_URL 
                + "xml?units=metric&"
                + "origins=place_id:" + place_id_1
                + "&destinations=place_id:" + place_id_2 
                + "&language=en"
                + "&mode=driving"
                + "&key=" + API_KEY;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db;
            db = dbf.newDocumentBuilder();
             Document doc = db.parse(new URL(url).openStream());
             NodeList nl = doc.getElementsByTagName("DistanceMatrixResponse");
             for(int i = 0; i < nl.getLength(); i++){
                 Node nNode = nl.item(i);
                 System.out.println("This is the node name : " + nNode.getNodeName());
                 if(nNode.getNodeType() == Node.ELEMENT_NODE){
                     Element el = (Element)nNode;
                     if (el.getElementsByTagName("status").item(0).getTextContent().equals(OK)) {
                         DistanceMatricRespond result = new DistanceMatricRespond();
                         result.setOrigin_address(el.getElementsByTagName("origin_address").item(0).getTextContent());
                         result.setDestination_address(el.getElementsByTagName("destination_address").item(0).getTextContent());
                         result.setDistance_text(((Element) ((NodeList) el.getElementsByTagName("distance")).item(0)).getElementsByTagName("text").item(0).getTextContent());
                         result.setDistance_value(((Element) ((NodeList) el.getElementsByTagName("distance")).item(0)).getElementsByTagName("value").item(0).getTextContent());
                         result.setDuration_text(((Element) ((NodeList) el.getElementsByTagName("duration")).item(0)).getElementsByTagName("text").item(0).getTextContent());
                         result.setDuration_value(((Element) ((NodeList) el.getElementsByTagName("duration")).item(0)).getElementsByTagName("value").item(0).getTextContent());
                         System.out.println(result.toString());
                         return result;
                     } else {
                         JOptionPane.showConfirmDialog(null, el.getElementsByTagName("error_message").item(0).getTextContent(), "Error request found", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             }
             System.out.println();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MapManipulation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            Logger.getLogger(MapManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static DistanceMatricRespond getResponse(){
        return getResponse("ChIJMaC2v0M4zDERhKvjqmfgxS0", "Ek1KYWxhbiBCdWtpdCBCaW50YW5nLCBLdWFsYSBMdW1wdXIsIFdpbGF5YWggUGVyc2VrdXR1YW4gS3VhbGEgTHVtcHVyLCBNYWxheXNpYSIuKiwKFAoSCc9opIMuNswxETsLD5EGGFqREhQKEgn1aURY1DfMMRGx2mTigGLKUA");
    }
}
