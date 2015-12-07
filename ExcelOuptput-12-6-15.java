package senior.project;



/**
 * This class manipulates the Excel sheet outputs
 * 
 * @author Alex Hamblen
 */

import jxl.CellView;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;

public class ExcelOutput {
    WritableSheet sheet;
    int recordIndex;
    WritableFont times12 = new WritableFont(WritableFont.TIMES,12);
    WritableCellFormat times12format = new WritableCellFormat(times12);
    CellView autosize = new CellView();
    
    final int COL_LABEL = 0;
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
    // set up cells to autosize
    public ExcelOutput(WritableSheet ws, String s){
       sheet = ws;
       initSheet(sheet, s);
       autosize.setAutosize(true);
       recordIndex = 0;
    }
    
    // inits the master schedule with writable sheet ws
    // set up cells to autosize
    public ExcelOutput(WritableSheet ws){
        sheet = ws;
        initMaster(sheet);
        autosize.setAutosize(true);
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
                s.addCell(new Label(i, 0, label,times12format));
                
                
            }
            // write times down col 0
            for(int i = 0; i <= 24; i++){
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
                s.addCell(new Label(0, i + 1, label, times12format));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private String getTime(int time){
        String label;
        switch(time){
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
        return label;
    }
    
    // initialize a WritableSheet
    // S is the sheet name
    // subsequent columns are the days of the week
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
                ws.addCell(new Label(i, 0, label, new WritableCellFormat(times12)));
                recordIndex++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    // add data to the master schedule
    // String will be the class or tutor name. Boolean matrix will be when class
    // or tutor is scheduled.
    public void addToMaster(String s, boolean[][] b){
        String label;
        Label labelCell;
        autosize.setAutosize(true);
        try{
            recordIndex++;
            for(int col = 0; col < 7; col++){
                for(int row = 0; row < 24; row++){
                    if(b[col][row]){
                        if(sheet.getCell(col, row).getContents().isEmpty()){
                            label = s;
                            labelCell = new Label(col+1, row+1, label, times12format);
                            sheet.addCell(labelCell);
                        }
                        else{
                            label = sheet.getCell(col+1, row+1).getContents() +
                                    '\n' + s;
                            labelCell = new Label(col+1, row+1, label, times12format);
                            sheet.addCell(labelCell);
                        }
                    }
                    sheet.setRowView(row, autosize);
                }
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // writes the tutors to the tutor schedule
    // should put each time scheduled on a specific day in an autosize cell
    // separated by newline chars
    // potentially takes a while - runs through each time on each day for each
    // tutor
    public void writeTutors(int i, String s, boolean[][][] b){
        String label;
        Label labelCell;
        try{
            for(int tutorNum = 0; tutorNum < b.length; tutorNum++){
                for(int day = 0; day < 7; day++){
                    for(int timeSlot = 0; timeSlot < 24; timeSlot++){
                        if(b[tutorNum][day][timeSlot]){
                            if(sheet.getCell(day, timeSlot).getContents().isEmpty()){
                                label = getTime(timeSlot);
                                labelCell = new Label(day+1, tutorNum+1, label,
                                        times12format);
                                sheet.addCell(labelCell);
                            }
                            else{
                                label = sheet.getCell(day+1, tutorNum+1).getContents()
                                        + '\n' + getTime(timeSlot);
                                labelCell = new Label(day+1, tutorNum+1, label,
                                        times12format);
                                sheet.addCell(labelCell);
                            }
                        }
                    }
                    sheet.setRowView(i, autosize);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        
    // writes the classes to the class schedule
    // should put each time offered on a specific day in an autosize cell
    // separated by newline chars
    // potentially takes a while - runs through each time on each day for each
    // class
    public void writeClasses(int i, String s, boolean[][][] b){
        String label;
        Label labelCell;
        try{
            for(int classNum = 0; classNum < b.length; classNum++){
                for(int day = 0; day < 7; day++){
                    for(int timeSlot = 0; timeSlot < 24; timeSlot++){
                        if(b[classNum][day][timeSlot]){
                            if(sheet.getCell(day, timeSlot).getContents().isEmpty()){
                                label = getTime(timeSlot);
                                labelCell = new Label(day+1, classNum+1, label,
                                        times12format);
                                sheet.addCell(labelCell);
                            }
                            else{
                                label = sheet.getCell(day+1, classNum+1).getContents()
                                        + '\n' + getTime(timeSlot);
                                labelCell = new Label(day+1, classNum+1, label,
                                        times12format);
                                sheet.addCell(labelCell);
                            }
                        }
                    }
                    sheet.setRowView(i, autosize);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

