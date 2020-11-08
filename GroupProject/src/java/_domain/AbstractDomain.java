/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ITSUKA KOTORI
 */
public abstract class AbstractDomain {

    public AbstractDomain() {
    }
    public abstract boolean isNotNull();
    public abstract boolean split(ResultSet rs);
    @Override public abstract boolean equals(Object obj);
    @Override public abstract int hashCode();
    @Override public abstract String toString();
    
}
