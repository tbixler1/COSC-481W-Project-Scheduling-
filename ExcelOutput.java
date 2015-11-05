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
import java.util.Scanner;

public class ExcelOutput {
    WritableSheet sheet;
    Record record;
    int recordIndex;
    
    final int COL_SUN = 1;
    final int COL_MON = 2;
    final int COL_TUE = 3;
    final int COL_WED = 4;
    final int COL_THU = 5;
    final int COL_FRI = 6;
    final int COL_SAT = 7;
    
    final int ROW_0800 = 1;
    final int ROW_0900 = 2;
    final int ROW_1000 = 3;
    final int ROW_1100 = 4;
    final int ROW_1200 = 5;
    final int ROW_1300 = 6;
    final int ROW_1400 = 7;
    final int ROW_1500 = 8;
    final int ROW_1600 = 9;
    final int ROW_1700 = 10;
    final int ROW_1800 = 11;
    final int ROW_1900 = 12;
    final int ROW_2000 = 13;
    
    
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
//            for(int i = 1; i <= 7; i++){
//                for(int j = 1; j <= 13; j++){
//                    s.addCell(new Label(i, j, "", new WritableCellFormat(
//                    new WritableFont(WritableFont.TIMES,12))));
//                }
//            }
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
                if(i == 0)
                    label = r.getName();
                else{
                    if(r.hasHrs(i))
                        label = r.getHrs(i);
                    else
                        label = "NO HOURS";
                }
                sheet.addCell(new Label(i, recordIndex, label, new WritableCellFormat(
                    new WritableFont(WritableFont.TIMES,12))));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // add data to the master schedule
    // data passed from Record class must use comma delimiter
    public void addToMaster(Record r){
        int hrs;
        int row;
        int col;
        String label;
        try{
            recordIndex++;
            Scanner scanner;
            for(col = 1; col <= 7; col++){
                scanner = new Scanner(r.getHrs(col));
                scanner.useDelimiter(",");
                while(scanner.hasNextInt()){
                    hrs = scanner.nextInt();
                    switch(hrs){
                        case  800: row = ROW_0800;
                            break;
                        case  900: row = ROW_0900;
                            break;
                        case 1000: row = ROW_1000;
                            break;
                        case 1100: row = ROW_1100;
                            break;
                        case 1200: row = ROW_1200;
                            break;
                        case 1300: row = ROW_1300;
                            break;
                        case 1400: row = ROW_1400;
                            break;
                        case 1500: row = ROW_1500;
                            break;
                        case 1600: row = ROW_1600;
                            break;
                        case 1700: row = ROW_1700;
                            break;
                        case 1800: row = ROW_1800;
                            break;
                        case 1900: row = ROW_1900;
                            break;
                        case 2000: row = ROW_2000;
                            break;
                        default: row = 40;    
                    }
                    if(sheet.getCell(col, row).getContents().isEmpty() && row != 40){
                        label = r.getName();
                        sheet.addCell(new Label(col, row, label, new WritableCellFormat(
                        new WritableFont(WritableFont.TIMES,12))));
                    }
                    else if(row != 40){
                        label = sheet.getCell(col, row).getContents() +
                            ", " + r.getName();
                        sheet.addCell(new Label(col,row, label, new WritableCellFormat(
                            new WritableFont(WritableFont.TIMES,12))));
                    }
                }
                scanner.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
    }
}

