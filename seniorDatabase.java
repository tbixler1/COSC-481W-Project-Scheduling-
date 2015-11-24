/**
 * Tyler Bixler, Thomas Gautz, Bryan Andrews, Alex Hamblen
 * COSC 481W, Fall 2015
 * This is the database class for the Math Lab tutoring software 
 * This class reads, writes, and "deletes" records
 * Writen by Tyler Bixler
 */
package senior.project;

import java.io.*;
import java.util.ArrayList;
public class seniorDatabase {
	String curPath;
	String dir;
        private static final int NUM_BOOLS = 30;
        private static final int NUM_INTS = 175;
	//constructor
	public seniorDatabase(String filePath){
		dir = filePath;
	}
		//Requires
			//Path
	
	
	//Write
	public void writeDatabase(String name, String stringData, int[] intData, boolean[] boolData){
		curPath = dir;
		try{
			RandomAccessFile writer = new RandomAccessFile(curPath, "rw");
			//int endRec = 0;
			
			writer.seek(writer.length());
			writer.writeUTF("0" + stringData);
			
			for(int j = 0; j < intData.length; j++){ //writes an int array to file
				writer.seek(writer.length());
				writer.writeInt(intData[j]);
			}
			
			for(int k = 0; k < boolData.length; k++){ //same as methods above, writes booleans to file
				writer.seek(writer.length());
				writer.writeBoolean(boolData[k]);
			}
			writer.close();
		}
		catch(FileNotFoundException e){
			throw new RuntimeException(e);
		}
		catch(IOException x){
			throw new RuntimeException(x);
		}
	}
		//Requires
			//Name of file
			//String Array, int Array, boolean Array
	
	
	//Read
	public Object[] readDatabase(String name){ //probably can get rid of name later, not sure
		curPath = dir;
		ArrayList<String> stringData = new ArrayList<String>();
		ArrayList<Integer> intData = new ArrayList<Integer>();
		ArrayList<Boolean> boolData = new ArrayList<Boolean>();
		
		try{
			RandomAccessFile reader = new RandomAccessFile(curPath, "r");
			reader.seek(0); //start at beginning of file
			
			do{
				String checkDel = reader.readUTF();
				if(checkDel.charAt(0) == '0'){
					stringData.add(checkDel);
			
					for(int k = 0;k < NUM_INTS;k++){
						intData.add(reader.readInt());
					}

					for(int x = 0; x < NUM_BOOLS;x++){
						boolData.add(reader.readBoolean());
					}
				}
				else{
					for(int k = 0;k<NUM_INTS;k++){
						reader.readInt();
					}
					for(int x = 0; x<NUM_BOOLS; x++){
						reader.readBoolean();
					}
				}
			}while(reader.getFilePointer()<reader.length());
			reader.close();
		}
		catch(IOException e){
			throw new RuntimeException(e);
		}
		Object[] info = new Object[3]; //stores ArrayList<String>, int array, and boolean array in object array
		info[0] = stringData;
		info[1] = intData;
		info[2] = boolData;
		return info; //returns object array
	}
    
		//Requires
			//Name of file
			//How to return
	//Delete
	public void deleteRecord(String fileName,String studentName){
		curPath = dir;
		boolean deleted = false;
		try{
			RandomAccessFile reader = new RandomAccessFile(curPath,"rw");
			while(!deleted){ //go until we have deleted something/end of file is reached
				long beginning = reader.getFilePointer(); //used for going back to beginning of string
				String compString = reader.readUTF(); //reads in string to compare name to
				if(compString.contains(studentName)){ //if studentName is in that string that is the record we are looking for
					String newRec = "1" + compString.substring(1, compString.length()); //new String where 1 is starting char(this indicates deleted record)
					reader.seek(beginning); //goes back to beginning of string and rewrites it in its place
					reader.writeUTF(newRec);
					deleted = true; //sets deleted to true to break loop
				}
				else{
					for(int i=0;i<NUM_INTS;i++){
						reader.readInt(); //if we didn't find it then move through ints/bools to find next string NUMBERS NEED CHANGED HERE THESE ARE PLACEHOLDERS
					}
					for(int x=0;x<NUM_BOOLS;x++){
						reader.readBoolean();
					}
				}
				if(reader.getFilePointer()==reader.length()){ //if we get to end of file before finding record
					deleted = true; //set deleted to true and output that tutor was not found
					System.out.println("Tutor was not in database.");
				}
			}
			reader.close();
		}
		catch(IOException e){
			throw new RuntimeException(e);
		}
	}
	public Object[] search(String fileName, String studentName){ //search function
		curPath = dir;
		Object[] info = new Object[3]; //holds return information
		Boolean found = false; //used to iterate through file
		ArrayList<Integer> holdInt = new ArrayList<Integer>();
		ArrayList<Boolean> holdBool = new ArrayList<Boolean>();
		try{
			RandomAccessFile searcher = new RandomAccessFile(curPath,"r");
			while(searcher.getFilePointer()<searcher.length() && !found){
				String compString = searcher.readUTF(); //holds string to compare to
				if(compString.contains(studentName)&&compString.charAt(0)!='1'){
					info[0] = compString; //if record is found then read information and store in Object[]
					for(int i=0;i<NUM_INTS;i++){
						holdInt.add(searcher.readInt()); //NUMBERS HERE NEED CHANGED THESE ARE PLACEHOLDERS
					}
					info[1] = holdInt;
					for(int x=0;x<NUM_BOOLS;x++){
						holdBool.add(searcher.readBoolean());
					}
					info[2] = holdBool;
					found = true;
				}
				else{
					for(int i =0;i<NUM_INTS;i++){
						searcher.readInt();
					}
					for(int x=0;x<NUM_BOOLS;x++){
						searcher.readBoolean();
					}
				}
			}
			searcher.close();
		}
		catch(IOException e){
			throw new RuntimeException(e);
		}
		if(!found){ //if we didn't find the record then return Object[] with no information
			info[0] = "No tutor";
			info[1] = 0;
			info[2] = false;
			return info;
		}
		return info; //otherwise return the information we got
	}
	public void updateRecord(String fileName, String fullName, String newRec, int[] newHours, boolean[] newClasses){
		curPath = dir;
		String searchName = fullName;
		boolean found = false;
		try{
			RandomAccessFile updater = new RandomAccessFile(curPath, "rw"); //creates RandomAccessFile object
			while(updater.getFilePointer()<updater.length()&&!found){ //searches for record
				long pointHold = updater.getFilePointer();
				String recHold = updater.readUTF(); //reads in string to check for substring
				if(recHold.contains(searchName)){ //if name is a substring of then continue with update
					updater.seek(pointHold); //goes back to start of string
					updater.writeUTF("0" + newRec); //writes string with 0 at beginning
					for(int i=0;i<newHours.length;i++) //writes new integers in place of others
						updater.writeInt(newHours[i]);
					for(int j=0;j<newClasses.length;j++) //writes new booleans in place of others
						updater.writeBoolean(newClasses[j]);
                                        found = true;
				}
				else
                                {
                                    for(int i=0;i<newHours.length;i++) //if it didn't find string then next two loops run, and gets past ints/bools
                                            updater.readInt();
                                    for(int i=0;i<newClasses.length;i++)
                                            updater.readBoolean();
                                }
				
				if(updater.getFilePointer()==updater.length())
					found = true;
			}
                        System.out.println("updater.getFilePointer(): "+updater.getFilePointer());
                        System.out.println("updater.length(): "+updater.length());
                        
			updater.close();
		}
		catch(IOException e){
			throw new RuntimeException(e);
		}
	}
}