/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xps
 */
public class ContactUs extends AbstractDomain{

    private String id;
    private String name;
    private String email;
    private String phone;
    private String messagge;
    private Date contact_date;

    public ContactUs(String id, String name, String email, String phone, String messagge, Date contact_date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.messagge = messagge;
        this.contact_date = contact_date;
    }

    public ContactUs() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessagge() {
        return messagge;
    }

    public void setMessagge(String messagge) {
        this.messagge = messagge;
    }

    public Date getContact_date() {
        return contact_date;
    }

    public void setContact_date(Date contact_date) {
        this.contact_date = contact_date;
    }
    
    @Override
    public String toString() {
        return "ContactUp{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", messagge=" + messagge + ", contact_date=" + contact_date + '}';
    }
    
    @Override
    public boolean isNotNull() {
        return id != null && id.length() == 8;
    }

    @Override
    public boolean split(ResultSet rs) {
        try {
            this.id  = rs.getString("contact_no");
            this.name = rs.getString("name");
            this.email = rs.getString("email");
            this.phone = rs.getString("phone");
            this.messagge = rs.getString("message");
            this.contact_date = new Date(rs.getTimestamp("send_date").getTime());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ContactUs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.phone);
        hash = 59 * hash + Objects.hashCode(this.messagge);
        hash = 59 * hash + Objects.hashCode(this.contact_date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactUs other = (ContactUs) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.messagge, other.messagge)) {
            return false;
        }
        if (!Objects.equals(this.contact_date, other.contact_date)) {
            return false;
        }
        return true;
    }

    
}
