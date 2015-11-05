/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceloutput;

/**
 *
 * @author Alex Hamblen
 */
public class Record {
    int recordNumber;
    String name;
    String monHrs;
    String tueHrs;
    String wedHrs;
    String thuHrs;
    String friHrs;
    String satHrs;
    String sunHrs;
    String defaultName = "DO NOT USE";
    boolean hasSunHrs;
    boolean hasMonHrs;
    boolean hasTueHrs;
    boolean hasWedHrs;
    boolean hasThuHrs;
    boolean hasFriHrs;
    boolean hasSatHrs;
    
    
    //default constructor
    public Record(){
        recordNumber = 50;
        name = defaultName;
        hasSunHrs = false;
        hasMonHrs = false;
        hasTueHrs = false;
        hasWedHrs = false;
        hasThuHrs = false;
        hasFriHrs = false;
        hasSatHrs = false;
        
    }
    public Record(int rn, String n, String sunHrs, String monHrs, String tueHrs,
            String wedHrs, String thuHrs, String friHrs, String satHrs){
        setRecordNumber(rn);
        setName(n);
        setSunHrs(sunHrs);
        setMonHrs(monHrs);
        setTueHrs(tueHrs);
        setWedHrs(wedHrs);
        setThuHrs(thuHrs);
        setFriHrs(friHrs);
        setSatHrs(satHrs);
               
        
    }
    
    // setters
    private void setRecordNumber(int i){
        recordNumber = i;
    }
    private void setName(String s){
        name = s;
    }
    private void setSunHrs(String s){
        sunHrs = s;
        hasSunHrs = true;
    }
    private void setMonHrs(String s){
        monHrs = s;
        hasMonHrs = true;
    }
    private void setTueHrs(String s){
        if(hasTueHrs)
            tueHrs = this.getTueHrs() + ", " + s;
        else
            tueHrs = s;
        hasTueHrs = true;
    }
    private void setWedHrs(String s){
        wedHrs = s;
        hasWedHrs = true;
    }
    private void setThuHrs(String s){
        thuHrs = s;
        hasThuHrs = true;
    }
    private void setFriHrs(String s){
        friHrs = s;
        hasFriHrs = true;
    }
    private void setSatHrs(String s){
        satHrs = s;
        hasSatHrs = true;
    }
    
    
    // add to existing hours
    public void addSunHrs(String s){
        if(hasSunHrs)
            sunHrs = this.getSunHrs() + ", " + s;
        else
            sunHrs = s;
        hasSunHrs = true;
    }
    public void addMonHrs(String s){
        if(hasMonHrs)
            monHrs = this.getMonHrs() + ", " + s;
        else
            monHrs = s;
        hasMonHrs = true;
    }
    public void addTueHrs(String s){
        if(hasTueHrs)
            tueHrs = this.getTueHrs() + ", " + s;
        else
            tueHrs = s;
        hasTueHrs = true;
    }
    public void addWedHrs(String s){
        if(hasWedHrs)
            wedHrs = this.getWedHrs() + ", " + s;
        else
            wedHrs = s;
        hasWedHrs = true;
    }
    public void addThuHrs(String s){
        if(hasThuHrs)
            thuHrs = this.getThuHrs() + ", " + s;
        else
            thuHrs = s;
        hasThuHrs = true;
    }
    public void addFriHrs(String s){
        if(hasFriHrs)
            friHrs = this.getFriHrs() + ", " + s;
        else
            friHrs = s;
        hasFriHrs = true;
    }
    public void addSatHrs(String s){
        if(hasSatHrs)
            satHrs = this.getSatHrs() + ", " + s;
        else
            satHrs = s;
        hasSatHrs = true;
    }
    
    
    // getters
    public int getRecordNumber(){
        return recordNumber;
    }
    public String getName(){
        return name;
    }
    public String getMonHrs(){
        return monHrs;
    }
    public String getTueHrs(){
        return tueHrs;
    }
    public String getWedHrs(){
        return wedHrs;
    }
    public String getThuHrs(){
        return thuHrs;
    }
    public String getFriHrs(){
        return friHrs;
    }
    public String getSatHrs(){
        return satHrs;
    }
    public String getSunHrs(){
        return sunHrs;
    }
}
