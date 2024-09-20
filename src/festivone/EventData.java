/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festivone;

import java.sql.Date;

/**
 *
 * @author */
public class EventData {
    
    private Integer EventId;
    private String location;
    private String status;
    private Double price;
    private Date date;
    
    public EventData(Integer EventId, String location, String status, Double price, Date date){
        this.EventId= EventId;
        this.location = location;
        this.status = status;
        this.price = price;
        this.date = date;
    }
    
    public Integer getEventId(){
        return EventId;
    }
    public String getLocation(){
        return location;
    }
    public String getStatus(){
        return status;
    }
    public Double getPrice(){
        return price;
    }
    public Date getDate(){
        return date;
    }
}
