/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senior.project;

import java.util.ArrayList;

/**
 *
 * @author Orc 9
 */
public class Interpreter 
{
    //private instance variables
    private ExcelOutput xlOut;
    private Object[][] tutorLists;
    private Rules rules;
    
    //constructor
    public Interpreter(ExcelOutput x, Object[][] list, Rules r)
    {
        //initialize instance variables
        xlOut = x;
        tutorLists = list;
        rules = r;
        //interprets classes and tutors
        interpretClasses();
        interpretTutors();
    }
    
    /**constructor for testing
    public Interpreter(Object[][] list, Rules r)
    {
        xlOut = new ExcelOutput();
        tutorLists = list;
        rules = r;
        interpretClasses();
        interpretTutors();
    }*/
    
    //interprets a master schedule to view when each class is offered
    private void interpretClasses()
    {
        //create new list of when each class is offered
        //29 classes x 7 days x 24 hours
        boolean[][][] classes = new boolean[29][7][24];
        //for each day
        for(int i=0; i<tutorLists.length; i++)
            //for each hour (in each day)
            for(int j=0; j<tutorLists[i].length; j++)
                //for each tutor in this specific day&hour ArrayList
                for(int k=0; true; k++)
                {
                    //if the list is empty, break inner for loop
                    if(((ArrayList<TutorInfo>)tutorLists[i][j]) == null)
                        break;
                    //if we checked all of the tutors in this list, break inner for loop
                    if(k>=((ArrayList<TutorInfo>)tutorLists[i][j]).size())
                        break;
                    
                    //get a tutor's info from the list of people working
                    Object[] temp = ((ArrayList<TutorInfo>)tutorLists[i][j]).get(k).getAllInfo();
                    //grab tutorable classes from this person
                    boolean[] boolTemp = (boolean[])temp[2];
                    //for each of these tutorable classes, mark as tutored at this time frame
                    //c=1 because boolTemp[0] = isLeadTutor
                    for(int c=1; c<boolTemp.length; c++)
                        if(boolTemp[c]) //if tutorable at this time
                            classes[c-1][i][j] = true; //mark as tutorable at day&time i,j
                }
        
        //classes[][][] is completely full and ready for writing
        //write classes to Excel File
        xlOut.writeClasses(1,  "MATH 097",classes[0]);
        xlOut.writeClasses(2,  "MATH 098",classes[1]);
        xlOut.writeClasses(3,  "MATH 104",classes[2]);
        xlOut.writeClasses(4,  "MATH 105",classes[3]);
        xlOut.writeClasses(5,  "MATH 107",classes[4]);
        xlOut.writeClasses(6,  "MATH 110",classes[5]);
        xlOut.writeClasses(7,  "MATH 112",classes[6]);
        xlOut.writeClasses(8,  "MATH 120",classes[7]);
        xlOut.writeClasses(9,  "MATH 121",classes[8]);
        xlOut.writeClasses(10, "MATH 122",classes[9]);
        xlOut.writeClasses(11, "MATH 140",classes[10]);
        xlOut.writeClasses(12, "MATH 170",classes[11]);
        xlOut.writeClasses(13, "MATH 211",classes[12]);
        xlOut.writeClasses(14, "MATH 223",classes[13]);
        xlOut.writeClasses(15, "MATH 325",classes[14]);
        xlOut.writeClasses(16, "MATH 360",classes[15]);
        xlOut.writeClasses(17, "MATH 370",classes[16]);
        xlOut.writeClasses(18, "MATH 411",classes[18]);
        xlOut.writeClasses(19, "MATH 471",classes[19]);
        xlOut.writeClasses(20, "MATH 400+",classes[20]);
        xlOut.writeClasses(21, "General Physics",classes[17]);
        //no need to print this one to file
        //xlOut.writeClasses(22, "Check All Classes",classes[21]);
        
        //grab number of custom classes and print the right number of them to the Excel File
        String[] newClasses = rules.getNewClassNames();
        switch(Integer.parseInt(newClasses[0]))
        {
            case 7:
                xlOut.writeClasses(28, newClasses[7],classes[28]);
            case 6:
                xlOut.writeClasses(27, newClasses[6],classes[27]);
            case 5:
                xlOut.writeClasses(26, newClasses[5],classes[26]);
            case 4:
                xlOut.writeClasses(25, newClasses[4],classes[25]);
            case 3:
                xlOut.writeClasses(24, newClasses[3],classes[24]);
            case 2:
                xlOut.writeClasses(23, newClasses[2],classes[23]);
            case 1:
                xlOut.writeClasses(22, newClasses[1],classes[22]);
                break;
        }
    }
    
    //interprets a master schedule to view when each tutor is scheduled
    private void interpretTutors()
    {
        //declare variables
        //keep track of which tutors are already recorded
        ArrayList<String> alreadyChecked = new ArrayList<String>();
        //temporary, reused variables
        boolean[][] thisTutorWorking;
        TutorInfo thisTutor;
        //keeps track of next line to write in Excel File
        int iterator = 0;
        
        //for each day
        for(int i=0; i<tutorLists.length; i++)
            //for each time in each day
            for(int j=0; j<tutorLists[i].length; j++)
                //for each tutor in this day&time
                for(int k=0; true; k++)
                {
                    //if the tutor list is empty, break
                    if(((ArrayList<TutorInfo>)tutorLists[i][j]) == null)
                        break;
                    //if we finished grabbing all the tutors in this list, break
                    if(k>=((ArrayList<TutorInfo>)tutorLists[i][j]).size())
                        break;
                    //get the next tutor in the list
                    thisTutor = ((ArrayList<TutorInfo>)tutorLists[i][j]).get(k);
                    //if we've already recorded this tutor from a different day&time,
                    //  don't re-record, just continue to next tutor
                    if(alreadyChecked.contains(thisTutor.toString()))
                        continue;
                    //else, add to the list of recorded tutors
                    alreadyChecked.add(thisTutor.toString());
                    //create a fresh day&time array of when this tutor is working
                    thisTutorWorking = new boolean[7][24];
                    //for each day and time
                    for(int x=0; x<tutorLists.length; x++)
                        for(int y=0; y<tutorLists[x].length; y++)
                            //if the tutor list on this day&time is not empty and contains this tutor, mark that this tutor is working this day&time
                            if(((ArrayList<TutorInfo>)tutorLists[x][y])!=null && ((ArrayList<TutorInfo>)tutorLists[x][y]).contains(thisTutor))
                                thisTutorWorking[x][y] = true;
                    //write this tutor to the Excel File
                    xlOut.writeTutors(++iterator, thisTutor.toString(), thisTutorWorking);
                }
    }
    /**used for debugging the above code by making up a text version of the Excel File printing
     * take note that writing tutors and writing classes is the same code, but different tabs on the excel sheet
    private class ExcelOutput
    {
        public void writeClasses(int row, String name, boolean[][] classes)
        {
            System.out.println(name);
            for(int i=0; i<classes.length; i++)
            {
                for(int j=0; j<classes[i].length; j++)
                {
                    if(classes[i][j])
                        System.out.print(classes[i][j]+"  ");
                    else
                        System.out.print(classes[i][j]+" ");
                }
                System.out.println();
            }
        }
        
        public void writeTutors(int row, String name, boolean[][] schedule)
        {
            System.out.println("\n\n");
            writeClasses(row, name, schedule);
        }
    }*/
}