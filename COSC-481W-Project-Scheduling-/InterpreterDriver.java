/*
 * Used to test/debug Interpreter
 * makes a tutor x and y and plays with their classes and schedule
 */
package senior.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Orc 9
 */
public class InterpreterDriver 
{
    public static void main(String args[])
    {
        Object[][] objects = new Object[7][24];
        ArrayList<TutorInfo> tutors = new ArrayList<TutorInfo>();
        Object[] initArray = new Object[3];
        String key = "$&!";
        initArray[0] = "x"+key+"x"+key+"x"+key+"x"+key+"x"+key+"x"+key+"x"+key+"x";
        initArray[1] = new int[175];
        boolean[] bools = {true, true, false, true, false,true, true, false, true, false,true, true, false, true, false,true, true, false, true, false,true, true, false, true, false,true, true, false, true, false};
        initArray[2] = bools;
        Rules r = new Rules();
        r.setVisible(true);
        System.out.println("a");
        Scanner stdin = new Scanner(System.in);
        stdin.nextLine();
        System.out.println("b");
        TutorInfo tutorX = new TutorInfo(new seniorDatabase("C:\\Users\\Orc 9\\Desktop"), "Bob", initArray, r);
        tutors.add(tutorX);
        for(int i=0; i<objects.length; i++)
            for(int j=0; j<objects[i].length; j+=2)
                objects[i][j] = tutors;
        System.out.println("c");
        
        tutors = new ArrayList<TutorInfo>();
        initArray[0] = "y"+key+"x"+key+"x"+key+"x"+key+"x"+key+"x"+key+"x"+key+"x";
        tutors.add(new TutorInfo(new seniorDatabase("C:\\Users\\Orc 9\\Desktop"), "Joe", initArray, r));
        tutors.add(tutorX);
        
        for(int i=0; i<objects.length; i++)
            for(int j=0; j<objects[i].length; j+=3)
                objects[i][j] = tutors;
        new Interpreter(objects, r);
    }
}