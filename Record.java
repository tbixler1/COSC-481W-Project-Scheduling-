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
    String sunHrs;
    String monHrs;
    String tueHrs;
    String wedHrs;
    String thuHrs;
    String friHrs;
    String satHrs;
    
    String defaultName = "DEFAULT";
    String defaultHours = "-1";
    boolean hasSunHrs;
    boolean hasMonHrs;
    boolean hasTueHrs;
    boolean hasWedHrs;
    boolean hasThuHrs;
    boolean hasFriHrs;
    boolean hasSatHrs;
    
    final int SUN = 1;
    final int MON = 2;
    final int TUE = 3;
    final int WED = 4;
    final int THU = 5;
    final int FRI = 6;
    final int SAT = 7;
    
    
    //default constructor
    public Record(){
        recordNumber = 50;
        name = defaultName;
        setSunHrs(defaultHours);
        setMonHrs(defaultHours);
        setTueHrs(defaultHours);
        setWedHrs(defaultHours);
        setThuHrs(defaultHours);
        setFriHrs(defaultHours);
        setSatHrs(defaultHours);
        
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
    public void setName(String s){
        name = s;
    }
    
    private void setHrs(int i){
        //todo make individual set hours methods obsolete
    }
    private void setSunHrs(String s){
        if(!s.equalsIgnoreCase("-1")) {
            hasSunHrs = true;
        } else {
            hasSunHrs = false;
        }
        sunHrs = s;
    }
    private void setMonHrs(String s){
        if(!s.equalsIgnoreCase("-1")){
            hasMonHrs = true;
        } else {
            hasMonHrs = false;
        }
        monHrs = s;
    }
    private void setTueHrs(String s){
        if(!s.equals("-1")){
            hasTueHrs = true;
        } else {
            hasTueHrs = false;
        }
        tueHrs = s;
    }
    private void setWedHrs(String s){
        if(!s.equalsIgnoreCase("-1")){
            hasWedHrs = true;
        } else {
            hasWedHrs = false;
        }
        wedHrs = s;
    }
    private void setThuHrs(String s){
        if(!s.equalsIgnoreCase("-1")){
            hasThuHrs = true;
        } else {
            hasThuHrs = false;
        }
        thuHrs = s;
    }
    private void setFriHrs(String s){
        if(!s.equalsIgnoreCase("-1")){
            hasFriHrs = true;
        } else {
            hasFriHrs = false;
        }
        friHrs = s;
    }
    private void setSatHrs(String s){
        if(!s.equalsIgnoreCase("-1")){
            hasSatHrs = true;
        } else {
            hasSatHrs = false;
        }
        satHrs = s;
    }
    
    
    // add to existing hours
    public void addHrs(int i, String s){
        if(hasHrs(i)){
            switch(i){
                case SUN: sunHrs = this.getHrs(SUN) + ", " + s;
                case MON: monHrs = this.getHrs(MON) + ", " + s;
                case TUE: tueHrs = this.getHrs(TUE) + ", " + s;
                case WED: wedHrs = this.getHrs(WED) + ", " + s;
                case THU: thuHrs = this.getHrs(THU) + ", " + s;
                case FRI: friHrs = this.getHrs(FRI) + ", " + s;
                case SAT: satHrs = this.getHrs(SAT) + ", " + s;
            }
        }
        else{
            switch(i){
                //todo call new setHrs(int);
            }
        }
    }
    public void addSunHrs(String s){
        if(hasSunHrs)
            sunHrs = this.getHrs(SUN) + ", " + s;
        else
            setSunHrs(s);
    }
    public void addMonHrs(String s){
        if(hasMonHrs)
            monHrs = this.getHrs(MON) + ", " + s;
        else
            setMonHrs(s);
    }
    public void addTueHrs(String s){
        if(hasTueHrs)
            tueHrs = this.getHrs(TUE) + ", " + s;
        else
            setTueHrs(s);
    }
    public void addWedHrs(String s){
        if(hasWedHrs)
            wedHrs = this.getHrs(WED) + ", " + s;
        else
            setWedHrs(s);
    }
    public void addThuHrs(String s){
        if(hasThuHrs)
            thuHrs = this.getHrs(THU) + ", " + s;
        else
            setThuHrs(s);
    }
    public void addFriHrs(String s){
        if(hasFriHrs)
            friHrs = this.getHrs(FRI) + ", " + s;
        else
            setFriHrs(s);
    }
    public void addSatHrs(String s){
        if(hasSatHrs)
            satHrs = this.getHrs(SAT) + ", " + s;
        else
            setSatHrs(s);
    }
    
    
    // getters
    public int getRecordNumber(){
        return recordNumber;
    }
    public String getName(){
        return name;
    }
    public String getHrs(int i){
        switch(i){
            case 1: return sunHrs;
            case 2: return monHrs;
            case 3: return tueHrs;
            case 4: return wedHrs;
            case 5: return thuHrs;
            case 6: return friHrs;
            case 7: return satHrs;
            default: return "off";
        }
    }
    public boolean hasHrs(int i){
        switch(i){
            case 1: return hasSunHrs;
            case 2: return hasMonHrs;
            case 3: return hasTueHrs;
            case 4: return hasWedHrs;
            case 5: return hasThuHrs;
            case 6: return hasFriHrs;
            case 7: return hasSatHrs;
            default: return false;
        }
    }
    
}
