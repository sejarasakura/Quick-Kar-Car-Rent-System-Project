/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _control.domain;

import _manipulation.Path_Manipulate;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

/**
 *
 * @author ITSUKA KOTORI
 */
@XmlRootElement(name = "xml")
public class AdminControl {
    private List<Admin> admin;

    public AdminControl() {
    }

    public AdminControl(List<Admin> admin) {
        this.admin = admin;
    }

    @XmlElementWrapper(name = "admin-list")
    @XmlElement(name = "admin")
    public List<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(List<Admin> admin) {
        this.admin = admin;
    }
    
    private static AdminControl get_Admin(String filename) {
        try {
            File file = new File(filename);
            JAXBContext jabxContext = JAXBContext.newInstance(AdminControl.class);
            Unmarshaller jabxUnmarshaller = jabxContext.createUnmarshaller();
            return (AdminControl)jabxUnmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Object[] get_Admins(){
        AdminControl data = AdminControl.get_Admin(Path_Manipulate.getDatabaseDirectory() + "xml/admin_info.xml");
        return data == null ? null : data.getAdmin().toArray();
    }

}
