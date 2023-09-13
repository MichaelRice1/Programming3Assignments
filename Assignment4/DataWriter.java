package data_Processing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class DataWriter {
	
	/**
	 * @author - Michael Rice
	 * @method  for writing data about land objects to the desired file
	 * @param filename - the filename of the file to be written to 
	 * @param landType - the type of land from csv file
	 * @param landValue - the value of the land from the csv file
	 * @functions 
	 * - instantiates print writer object and appends to the inputted filename
	 * - prints a formatted string to the file
	 * - catches all neccessary exceptions and closes stream
	 */
	public static void writeLandDataToFile(String filename,String landType,double landValue)
	{
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(filename,true));//boolean append is true
			pw.printf("%s   %.2f",landType,landValue);
			pw.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally
		{
			pw.close();
		}
	}
}
