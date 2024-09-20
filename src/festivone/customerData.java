/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festivone;

import java.sql.Date;

/**
 *
 * @author 
 */
public class customerData {
    
    private Integer customerNum;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNum;
    private Integer EventId;
    private String location;
    private String type;
    private Integer seatNum;
    private Double total;
    private Date date;
    
    public customerData(Integer customerNum, String firstName, String lastName, String gender, String phoneNum, Integer EventId, String location, String type, Integer seatNum, Double total, Date date){
        this.customerNum = customerNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.EventId = EventId;
        this.location = location;
        this.type = type;
        this.seatNum = seatNum;
        this.total = total;
        this.date = date;
    }
    
    public Integer getCustomerNum(){
        return customerNum;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getGender(){
        return gender;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public Integer getEventId(){
        return EventId;
    }
    public String getLocation(){
        return location;
    }
    public String getType(){
        return type;
    }
    public Integer getSeatNum(){
        return seatNum;
    }
    public Double getTotal(){
        return total;
    }
    public Date getDate(){
        return date;
    }
    
}
