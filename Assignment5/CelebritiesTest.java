import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @apiNote  Celebrity and Award objects hard coded into class.
 * Class for testing serialization
 * @author Michael Rice 
 * 
 */
public class CelebritiesTest {

	Celebrity c;
	Award poty = new Award("Player of the Year","Premier League",LocalDate.parse("2022-06-09"));
	Award cL = new Award("Champions League Winner","UEFA",LocalDate.parse("2019-06-01"));
	Celebrity c2;
	Award oscar = new Award("Oscar","Academy Awards",LocalDate.parse("2020-08-14"));
	Celebrity c3;
	Award wdc = new Award("World Drivers Champion","FIA",LocalDate.parse("2019-10-14"));
	Award wcc = new Award("World Constructors Champion","FIA",LocalDate.parse("2019-10-14"));
	Celebrity c4;
	Award gg = new Award("Golden Globe","Hollywood",LocalDate.parse("2018-07-05"));
	Celebrity c5;
	Award olympics = new Award("Olympic Gold Medal","IOC",LocalDate.parse("2012-08-09"));
	Award belt = new Award("Lightweight Champion of the World","WBO",LocalDate.parse("2022-05-01"));

	
	@BeforeEach
	/**
	 * @apiNote init method to create celebrity objects and to add the relevant awards to each of their array lists
	 */
	void init()
	{
		c = new Celebrity(1,"Mo Salah","Footballer",LocalDate.parse("1992-07-15"));
		c.addAward(cL);
		c.addAward(poty);
		c2 = new Celebrity(2,"The Rock","Actor",LocalDate.parse("1972-05-02"));
		c2.addAward(oscar);
		c3 = new Celebrity(3,"Lewis Hamilton","F1 Driver",LocalDate.parse("1985-01-07"));
		c3.addAward(wcc);
		c3.addAward(wdc);
		c4 = new Celebrity(4,"Saoirse Ronan","Actress",LocalDate.parse("1992-04-12"));
		c4.addAward(gg);
		c5 = new Celebrity(5,"Katie Taylor","Boxer",LocalDate.parse("1986-07-02"));
		c5.addAward(belt);
		c5.addAward(olympics);
	}
	
	/**
	 * @apiNote
	 * test method to test correct serialization.
	 * creates object input and output streams.
	 * writes the 5 celebrity objects to the stream using a fileoutputstream.
	 * reads objects back in using a fileinputstream and casts them to celebrity.
	 * readObject method also reads in awards for each celebrity.
	 * these awards are are compared to the originals. 
	 * compares the read in objects to the originals.
	 * test only passes if all the read in awards and objects are equal to the originals.
	 * catches all exceptions.
	 */
	@Test
	void correctSerializationTest()
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("celebrities.ser"));
			oos.writeObject(c);
			oos.writeObject(c2);
			oos.writeObject(c3);
			oos.writeObject(c4);
		    oos.writeObject(c5);

			
			ois = new ObjectInputStream(new FileInputStream("celebrities.ser"));
			Celebrity celeb = (Celebrity) ois.readObject();
			Celebrity celeb2 = (Celebrity) ois.readObject();
			Celebrity celeb3 = (Celebrity) ois.readObject();
			Celebrity celeb4 = (Celebrity) ois.readObject();
			Celebrity celeb5 = (Celebrity) ois.readObject();

			assertEquals(celeb.getAwards(),c.getAwards());
			assertEquals(celeb2.getAwards(),c2.getAwards());
			assertEquals(celeb3.getAwards(),c3.getAwards());
			assertEquals(celeb4.getAwards(),c4.getAwards());
			assertEquals(celeb5.getAwards(),c5.getAwards());

			assertEquals(c.toString(), celeb.toString());
			assertEquals(c2.toString(), celeb2.toString());
			assertEquals(c3.toString(), celeb3.toString());
			assertEquals(c4.toString(), celeb4.toString());
			assertEquals(c5.toString(), celeb5.toString());
			
			
			System.out.println(celeb.toString());
			System.out.println(celeb.getAwards());
			System.out.println();
			System.out.println(celeb2.toString());
			System.out.println(celeb2.getAwards());
			System.out.println();
			System.out.println(celeb3.toString());
			System.out.println(celeb3.getAwards());
			System.out.println();
			System.out.println(celeb4.toString());
			System.out.println(celeb4.getAwards());
			System.out.println();
			System.out.println(celeb5.toString());
			System.out.println(celeb5.getAwards());



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
