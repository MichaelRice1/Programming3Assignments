package tests;

import org.junit.jupiter.api.Test;
import data_Processing.DataWriter;
import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataWriterTests {
	
	
	
	/**
	 * @author - Michael Rice
	 * @method - tests the functionality of a correct write to file operation
	 * @functions
	 * - writes data to a test file
	 * - creates a new file reader
	 * - reads from the test file and if the end of file index isnt read, the write operation has been successful.
	 * - handles exceptions
	 */
	@Test
	void correctWrite()
	{
		DataWriter.writeLandDataToFile("testfile.txt", "MidEast",10000.00);
		FileReader fr;
		try {
			fr = new FileReader("testfile.txt");
			try {
				assertTrue( fr.read() != -1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
	}

}
