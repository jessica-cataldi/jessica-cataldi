package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Classroom implements Serializable
{   
    private String roomNumber, buildingName;
    
    public Classroom(String roomNumber, String buildingName)
    {
        this.roomNumber = roomNumber;
        this.buildingName = buildingName;
    }
    public Classroom(){}


    public String getRoomNumber()
    {
        return roomNumber;
    }
    public String getBuildingName()
    {
        return buildingName;
    }


    public void setRoomNumber(String roomNumber)
    {
        this.roomNumber = roomNumber;
    }
    public void setBuildingName(String buildingName)
    {
        this.buildingName = buildingName;
    }  
}
