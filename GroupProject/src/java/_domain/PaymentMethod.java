/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import _enum.PaymentMethodType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class PaymentMethod extends AbstractDomain{
    private String pay_method_id;
    private PaymentMethodType pay_method;
    private String card_num;
    private String user;

    public PaymentMethod() {
    }
    public PaymentMethod(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }
    public PaymentMethod(String pay_method_id, PaymentMethodType pay_method, String card_num, String user) {
        this.pay_method_id = pay_method_id;
        this.pay_method = pay_method;
        this.card_num = card_num;
        this.user = user;
    }
    @Override
    public boolean split(ResultSet rs) {
        try {
            this.pay_method_id = rs.getString("pay_method_id"); // string
            this.user = rs.getString("user_id"); // string
            this.pay_method = PaymentMethodType.getValue(rs.getString("payment_method")); // enum
            this.card_num = rs.getString("card_num"); // string
            return true;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex, "Error found in mysql", JOptionPane.ERROR_MESSAGE);
       }
        return false;
    }
    @Override
    public boolean isNotNull() {
        try {
            return this.pay_method_id.length() == 14;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.pay_method_id);
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
        final PaymentMethod other = (PaymentMethod) obj;
        if (!Objects.equals(this.pay_method_id, other.pay_method_id)) {
            return false;
        }
        return this.pay_method == other.pay_method;
    }
    @Override
    public String toString() {
        return "PaymentMethod{" + "pay_method_id=" + pay_method_id + ", pay_method=" + pay_method + ", card_num=" + card_num  + '}';
    }

    public String getPay_method_id() {
        return pay_method_id;
    }

    public PaymentMethodType getPay_method() {
        return pay_method;
    }

    public String getCard_num() {
        return card_num;
    }

    public String getUser() {
        return user;
    }

    public void setPay_method_id(String pay_method_id) {
        this.pay_method_id = pay_method_id;
    }

    public void setPay_method(PaymentMethodType pay_method) {
        this.pay_method = pay_method;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
