package senior.project;

/*
 * Tyler Bixler, Thomas Gautz, Bryan Andrews, Alex Hamblen
 * COSC 481W, Fall 2015
 * This is the database class for the Math Lab tutoring software 
 * This class reads, writes, and "deletes" records
 * Writen by Tyler Bixler
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
public class seniorDatabase {
	String curPath;
	String dir;
	private int stringLength, intLength = 175, boolLength = 30;

	//constructor
	public seniorDatabase(String filePath){
		dir = filePath;
	}
		//Requires
			//Path
	
	
	//Write
	public void writeDatabase(String name, String stringData, int[] intData, boolean[] boolData){
		curPath = dir + "\\" + name + ".tut";
		//stringLength = stringData.length;
		intLength = intData.length;
		boolLength = boolData.length;
		try{
			RandomAccessFile writer = new RandomAccessFile(curPath, "rw");
			int endRec = 0;
			/*for(int i = 0;i < stringData.length;i++){ //writes a string array to file
				writer.seek(writer.length()); //finds end of file first, then writes next string
				writer.writeChars(stringData[i]);
			}*/
			writer.seek(writer.length());
			writer.writeUTF(stringData);
			
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
		//System.out.println("wrote it");
	}
		//Requires
			//Name of file
			//String Array, int Array, boolean Array
	
	
	//Read
	public Object[] readDatabase(String name){ //probably can get rid of name later, not sure
		curPath = dir + "\\" + name;
		String stringData;
		int[] intData = new int[intLength];
		boolean[] boolData = new boolean[boolLength];
		try{
			char[] hold = new char[200];
			RandomAccessFile reader = new RandomAccessFile(curPath, "r");
			reader.seek(0); //start at beginning of file
			boolean run = true;
			int spotCount = 0, count = 0, stringCount = 0;
			
			/*for(int k=0;k<80;k++){ //runs 80 times and finds all ascii characters, saves them in an array
				if(reader.readChar() != 0x00){ //if it finds a ascii character move back 2 bytes then print
					reader.seek(reader.getFilePointer()-2);
					hold[spotCount] = reader.readChar();
					spotCount++;
					count++;
				}
			}*/
			//stringData = new String(hold); //converts char array to string
			stringData = reader.readUTF();
			
			for(int i=0; i<intLength;i++){
				intData[i] = reader.readInt();
			}
			//int intOffset = intLength * INTOFF + 89; //finds end of strings + end of ints before starting booleans
			
			//reader.seek(intOffset);
			for(int j=0;j<boolLength;j++){
				boolData[j] = reader.readBoolean();
			}
			reader.close();
		}
		catch(IOException e){
			throw new RuntimeException(e);
		}
		Object[] info = new Object[3]; //stores string, int array, and boolean array in object array
		info[0] = stringData;
		info[1] = intData;
		info[2] = boolData;
		return info; //returns object array
	}
		//Requires
			//Name of file
			//How to return
	//Delete
	public void deleteRecord(String name){
		curPath = dir + "\\" + name;
	}
		//Requires
			//Name of file
		//Changes byte from 0 to 1 or vice versa, whatever client wants
}

/*
 * To try:
 * Try finding file pointer after writing one string and saving that
 * Use difference in file pointers to find exact length needed
 */