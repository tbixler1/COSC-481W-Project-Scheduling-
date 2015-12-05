package senior.project;



/**
 * This class manipulates the Excel sheet outputs
 * 
 * @author Alex Hamblen
 */

import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import java.util.Scanner;

public class ExcelOutput {
    WritableSheet sheet;
    int recordIndex;
    
    final int COL_SUN = 1;
    final int COL_MON = 2;
    final int COL_TUE = 3;
    final int COL_WED = 4;
    final int COL_THU = 5;
    final int COL_FRI = 6;
    final int COL_SAT = 7;
    
    final int ROW_0000 = 1;
    final int ROW_0100 = 2;
    final int ROW_0200 = 3;
    final int ROW_0300 = 4;
    final int ROW_0400 = 5;
    final int ROW_0500 = 6;
    final int ROW_0600 = 7;
    final int ROW_0700 = 8;
    final int ROW_0800 = 9;
    final int ROW_0900 = 10;
    final int ROW_1000 = 11;
    final int ROW_1100 = 12;
    final int ROW_1200 = 13;
    final int ROW_1300 = 14;
    final int ROW_1400 = 15;
    final int ROW_1500 = 16;
    final int ROW_1600 = 17;
    final int ROW_1700 = 18;
    final int ROW_1800 = 19;
    final int ROW_1900 = 20;
    final int ROW_2000 = 21;
    final int ROW_2100 = 22;
    final int ROW_2200 = 23;
    final int ROW_2300 = 24;
    
    // constructors
    
    //default
    public ExcelOutput(){
       initSheet(sheet, "DEFAULT");
       recordIndex = 0;
    }
    
    // inits a writable sheet ws with title s
    public ExcelOutput(WritableSheet ws, String s){
       sheet = ws;
       initSheet(sheet, s);
       recordIndex = 0;
    }
    
    // inits the master schedule with writable sheet ws
    public ExcelOutput(WritableSheet ws){
        sheet = ws;
        initMaster(sheet);
        recordIndex = 0;
    }
            
    // initializes the master schedule sheet with times from 0000-2300 (midnight
    // to 11PM in rows) and days from Sunday-Saturday (in cols)
    private void initMaster(WritableSheet s){
        try{
            String label;
            // write col labels across row 0
            for(int i = 0; i <= 7; i++){
                switch(i){
                    case 0: label = "Time";
                        break;
                    case 1: label = "Sun";
                        break;
                    case 2: label = "Mon";
                        break;
                    case 3: label = "Tues";
                        break;
                    case 4: label = "Wed";
                        break;
                    case 5: label = "Thurs";
                        break;
                    case 6: label = "Fri";
                        break;
                    case 7: label = "Sat";
                        break;
                    default: label = "ERROR";
                        break;
                }
                s.addCell(new Label(i, 0, label,
                    new WritableCellFormat(new WritableFont(WritableFont.TIMES,12))));
                
                
            }
            // write times down col 0
            for(int i = 0; i <= 12; i++){
                switch(i){
                    case 0: label = "0000";
                        break;
                    case 1: label = "0100";
                        break;
                    case 2: label = "0200";
                        break;
                    case 3: label = "0300";
                        break;
                    case 4: label = "0400";
                        break;
                    case 5: label = "0500";
                        break;
                    case 6: label = "0600";
                        break;
                    case 7: label = "0700";
                        break;
                    case 8: label = "0800";
                        break;
                    case 9: label = "0900";
                        break;
                    case 10: label = "1000";
                        break;
                    case 11: label = "1100";
                        break;
                    case 12: label = "1200";
                        break;
                    case 13: label = "1300";
                        break;
                    case 14: label = "1400";
                        break;
                    case 15: label = "1500";
                        break;
                    case 16: label = "1600";
                        break;
                    case 17: label = "1700";
                        break;
                    case 18: label = "1800";
                        break;
                    case 19: label = "1900";
                        break;
                    case 20: label = "2000";
                        break;
                    case 21: label = "2100";
                        break;
                    case 22: label = "2200";
                        break;
                    case 23: label = "2300";
                        break;
                    default: label = "ERROR";
                        break;
                }
                s.addCell(new Label(0, i + 1, label,
                    new WritableCellFormat(new WritableFont(WritableFont.TIMES,12))));
            }
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // initialize a WritableSheet
    private void initSheet(WritableSheet ws, String s){
        String label;
        try{
            for(int i = 0; i <= 7; i++){
                switch(i){
                    case 0: label = s;
                        break;
                    case 1: label = "Sunday";
                        break;
                    case 2: label = "Monday";
                        break;
                    case 3: label = "Tuesday";
                        break;
                    case 4: label = "Wednesday";
                        break;
                    case 5: label = "Thursday";
                        break;
                    case 6: label = "Friday";
                        break;
                    case 7: label = "Saturday";
                        break;
                    default: label = "ERROR";
                        break;
                }
                ws.addCell(new Label(i, 0, label, new WritableCellFormat(
                    new WritableFont(WritableFont.TIMES,12))));
                recordIndex++;
            }
                        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    // add data to the master schedule
    // String will be the class or tutor name. Boolean matrix will when class or
    // tutor is scheduled.
    public void addToMaster(String s, boolean[][] b){
        String label;
        try{
            recordIndex++;
            for(int col = 0; col < 7; col++){
                for(int row = 0; row < 24; row++){
                    if(b[col][row]){
                        if(sheet.getCell(col, row).getContents().isEmpty()){
                            label = s;
                            sheet.addCell(new Label(col+1, row+1, label,
                                    new WritableCellFormat(
                                            new WritableFont(WritableFont.TIMES,12))));
                        }
                        else{
                            label = sheet.getCell(col+1, row+1).getContents() +
                                    '\n' + s;
                            sheet.addCell(new Label(col+1, row+1, label,
                                    new WritableCellFormat(
                                            new WritableFont(WritableFont.TIMES,12))));
                        }
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // writes the tutors to the tutor schedule
    public void writeTutors(){
        
    }
        
    // writes the classes to the class schedule
    public void writeClasses(int i, String s, boolean b){
        
    }
}

