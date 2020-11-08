/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _domain;
import org.w3c.dom.*;

/**
 *
 * @author ITSUKA KOTORI
 */
public class DistanceMatricRespond {
    private String origin_address;
    private String destination_address;
    private int duration_value;
    private int distance_value;
    private String duration_text;
    private String distance_text;

    public DistanceMatricRespond() {
    }

    public DistanceMatricRespond(Document dom) {
        
    }
    
    public DistanceMatricRespond(String origin_id, String destination_id, String duration_value, String distance_value, String duration_text, String distance_text) {
        this(origin_id, destination_id, Integer.parseInt(duration_value),Integer.parseInt(distance_value),duration_text, distance_text);
    }
    public DistanceMatricRespond(String origin_id, String destination_id, int duration_value, int distance_value, String duration_text, String distance_text) {
        this.origin_address = origin_id;
        this.destination_address = destination_id;
        this.duration_value = duration_value;
        this.distance_value = distance_value;
        this.duration_text = duration_text;
        this.distance_text = distance_text;
    }

    public String getOrigin_address() {
        return origin_address;
    }

    public void setOrigin_address(String origin_address) {
        this.origin_address = origin_address;
    }

    public String getDestination_address() {
        return destination_address;
    }

    public void setDestination_address(String destination_address) {
        this.destination_address = destination_address;
    }

    public int getDuration_value() {
        return duration_value;
    }

    public void setDuration_value(int duration_value) {
        this.duration_value = duration_value;
    }

    public void setDuration_value(String duration_value) {
        this.duration_value = Integer.parseInt(duration_value);
    }

    public int getDistance_value() {
        return distance_value;
    }

    public void setDistance_value(String distance_value) {
        this.distance_value = Integer.parseInt(distance_value);
    }

    public void setDistance_value(int distance_value) {
        this.distance_value = distance_value;
    }

    public String getDuration_text() {
        return duration_text;
    }

    public void setDuration_text(String duration_text) {
        this.duration_text = duration_text;
    }

    public String getDistance_text() {
        return distance_text;
    }

    public void setDistance_text(String distance_text) {
        this.distance_text = distance_text;
    }

    @Override
    public String toString() {
        return "DistanceMatricRespond{" + "origin_id=" + origin_address + ", destination_id=" + destination_address + ", duration_value=" + duration_value + ", distance_value=" + distance_value + ", duration_text=" + duration_text + ", distance_text=" + distance_text + '}';
    }
    
}
