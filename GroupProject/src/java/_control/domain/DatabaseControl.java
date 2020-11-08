/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _control.domain;

import java.io.File;
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
@XmlRootElement(name = "database")
public class DatabaseControl {
    private String host;
    private String username;
    private String password;
    private String databaseName;
    private String jdbcDrive; 

    public DatabaseControl() {
    }
    
    public DatabaseControl(String host, String username, String password, String databaseName, String jdbcDrive) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.jdbcDrive = jdbcDrive;
    }

    public static DatabaseControl get_Database(String filename) {
        try {
            File file = new File(filename);
            JAXBContext jabxContext = JAXBContext.newInstance(DatabaseControl.class);
            Unmarshaller jabxUnmarshaller = jabxContext.createUnmarshaller();
            return (DatabaseControl)jabxUnmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public void setJdbcDrive(String jdbcDrive) {
        this.jdbcDrive = jdbcDrive;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getJdbcDrive() {
        return jdbcDrive;
    }

    @Override
    public String toString() {
        return "Database{" + "host=" + host + ", username=" + username + ", password=" + password + ", databaseName=" + databaseName + ", jdbcDrive=" + jdbcDrive + '}';
    }    
}
