package exceloutput;

import jxl.*;
import jxl.write.*;
import jxl.write.WritableFont;
import java.io.File;



/**
 * Creates and writes to disk the output of the scheduler as a spreadsheet.
 * @author Alex Hamblen
 */
public class ExcelOutputDriver {

    /**
     * @param args the command line arguments
     */
    private static String path;
    private static File file;
    private static WritableWorkbook wbook;
    public static void main(String[] args) {
        
        
        
        try{
            // File path will be chosen through GUI by user
            // for testing purposes if GUI not available, set to your desired
            // directory. Spreadsheet is created at that location.
            path = "C:\\Users\\Psybernetic\\Desktop\\" + "schedule.xls";
            file = new File(path);
            wbook = Workbook.createWorkbook(file);
            WritableSheet master = wbook.createSheet("Master", 0);
            WritableSheet tutors = wbook.createSheet("Tutors", 1);
            WritableSheet courses = wbook.createSheet("Courses", 2);
            
            // initialize the master schedule
            ExcelOutput masterSched = 
                    new ExcelOutput(master);
            
            // initialize the tutor schedule
            ExcelOutput tutorSched = 
                    new ExcelOutput(tutors, "Tutor Name");
            
            // initialize the course schedule
            ExcelOutput courseSched =
                    new ExcelOutput(courses, "Course Number");

            Record tutor1 = new Record(1, "Bryan", "1400-1600", 
                "1800-2000", "1000-1200", "off","1000-1400","off", "off");
            
            tutorSched.addData(tutor1);
            
            wbook.write();
            wbook.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }  

}
