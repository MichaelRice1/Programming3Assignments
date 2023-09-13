package data_Processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class DataReader {

	
	/**
	 * @author Michael Rice
	 * @enum - all of the different possible regions of land from the csv file
	 */
	public enum Regions
	{
		STATE,BORDER,MIDLAND,WEST,DUBLIN,MIDEAST,MIDWEST,SOUTHEAST,SOUTHWEST;
	}
	
	/**
	 * @author - Michael Rice
	 * @method - main method
	 * all code functionality for reading data is placed here 
	 * @functions
	 * - reads data from csv file
	 * - separates the data using a comma as the delimiter
	 * - converts the data into the required format(capitalised and no other charsacters)
	 * - inserts the tokens into appropriate array lists
	 * - uses switch case and a loop and compares the current region value to an enum variable
	 * - if case found, writes landtype and amount to the correct file using a preset string format
	 */
	public static void main(String[] args)
	{
		
		//String region;
		BufferedReader bufferedIn = null;
		ArrayList<String> reg = new ArrayList<String>();
		ArrayList<Double> amt = new ArrayList<Double>();
		ArrayList<String> type = new ArrayList<String>();
		
		try {
			bufferedIn = new BufferedReader(new FileReader("ass4.csv"));
			String line = null;
			while((line = bufferedIn.readLine()) != null)
			{	
				Scanner scan = new Scanner(line);
				scan.useDelimiter(",");
				while(scan.hasNext())
				{
					String landType = scan.next();
					String region = scan.next().toUpperCase().replace("-","");
					double amount1 = scan.nextDouble();
					type.add(landType);
					reg.add(region);
					amt.add(amount1);
					
				}
			}
			
			for(int i =0;i<reg.size();i++)
			{		
				String type1 = type.get(i);
				Double amt1 = amt.get(i);
				String str = reg.get(i);
				String sf1=String.format("%s.txt",str);
				
				
				Regions reg1 = Regions.valueOf(str);
				
				switch(reg1)
				{
				case STATE:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case BORDER:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case MIDLAND:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case WEST:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case DUBLIN:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case MIDEAST:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case MIDWEST:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case SOUTHEAST:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				case SOUTHWEST:
					DataWriter.writeLandDataToFile(sf1, type1, amt1);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
	}
		finally{
			try {
				bufferedIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

