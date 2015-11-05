package exceloutput;

/**
 * This class manipulates the Excel sheet outputs
 * 
 * @author Alex Hamblen
 */

import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;

public class ExcelOutput {
    WritableSheet sheet;
    int recordIndex;
    
    public ExcelOutput(){
       initSheet(sheet, "DEFAULT");
       recordIndex = 0;
    }
    
    public ExcelOutput(WritableSheet ws, String s){
       sheet = ws;
       initSheet(sheet, s);
       recordIndex = 0;
    }
    
    public ExcelOutput(WritableSheet ws){
        sheet = ws;
        initMaster(sheet);
        recordIndex = 0;
    }
            
    // initializes the master schedule sheet with times from 0800-2000 (8AM to 
    // 8PM in rows) and days from Sunday-Saturday (in cols)
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
                    case 0: label = "0800";
                        break;
                    case 1: label = "0900";
                        break;
                    case 2: label = "1000";
                        break;
                    case 3: label = "1100";
                        break;
                    case 4: label = "1200";
                        break;
                    case 5: label = "1300";
                        break;
                    case 6: label = "1400";
                        break;
                    case 7: label = "1500";
                        break;
                    case 8: label = "1600";
                        break;
                    case 9: label = "1700";
                        break;
                    case 10: label = "1800";
                        break;
                    case 11: label = "1900";
                        break;
                    case 12: label = "2000";
                        break;
                    default: label = "ERROR";
                }
                s.addCell(new Label(0, i + 1, label,
                    new WritableCellFormat(new WritableFont(WritableFont.TIMES,12))));
            }
            // i = cols, j = rows
            // fills out remaining cells
            for(int i = 1; i <= 7; i++){
                for(int j = 1; j <= 13; j++){
                    s.addCell(new Label(i, j, "", new WritableCellFormat(
                    new WritableFont(WritableFont.TIMES,12))));
                }
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
    
    // add data from a Record
    public void addData(Record r){
        String label;
        try{
            recordIndex++;
            for(int i = 0; i <= 7; i++){
                switch(i){
                    case 0: label = r.getName();
                        break;
                    case 1: label = r.getSunHrs();
                        break;
                    case 2: label = r.getMonHrs();
                        break;
                    case 3: label = r.getTueHrs();
                        break;
                    case 4: label = r.getWedHrs();
                        break;
                    case 5: label = r.getThuHrs();
                        break;
                    case 6: label = r.getFriHrs();
                        break;
                    case 7: label = r.getSatHrs();
                        break;
                    default: label = "ERROR";
                        break;
                }
                sheet.addCell(new Label(i, recordIndex, label, new WritableCellFormat(
                    new WritableFont(WritableFont.TIMES,12))));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

