package _control.domain;

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
import _manipulation.*;

public class DefualtValue{
    private static DefualtValue df = new DefualtValue();
    private String xml_content;
    private DefualtValue(){
        xml_content = read_xml(Path_Manipulate.getResourceDirectory() + "defualt.xml");
    }

    private String read_xml(String file_position){
        return "";
    }
}