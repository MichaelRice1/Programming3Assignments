import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Celebrity implements Serializable{

	private int id;
	private String name;
	private String profession;
	private LocalDate dateofBirth;
	private transient List<Award> awards = new ArrayList<Award>();
	private PrintWriter pw = null;
	private BufferedReader bufferedIn = null;
	
	/**
	 * 
	 * @param id - celebrity's id
	 * @param name - celebrity's name
	 * @param profession - celebrity's profession
	 * @param dateOfBirth - celebrity's date of birth
	 */
	public Celebrity(int id,String name,String profession,LocalDate dateOfBirth) {
		this.id = id;
		this.name = name;
		this.profession = profession;
		this.dateofBirth = dateOfBirth;
	}
	
	/**
	 * 
	 * @param a - Object of type Award, method adds this to a given Celebrity's instance of the Awards array list
	 */
	public void addAward(Award a)
	{
		this.awards.add(a);
	}
	
	/**
	 * 
	 * @return str - a string representation of an awards array list and the id of the celebrity associated with the awards
	 */
	public String getAwards()
	{
		String str = "";
		for(Award a : this.awards)
		{
			str += String.format("\n%s,%s,%s,%s,", a.getAwardName(),a.getAwardOrganisation(),a.getDateOfAward().toString(),this.getName());
		}
		return str;
	}
	
	
	/**
	 * method that customises the writeObject of the serializable interface
	 * implements the defaultWriteObject method initially
	 * then serializes objects of the users desire (id,name etc)
	 * print writer method used in aassociation with getAwards method to write awards to a csv file
	 * stream then closed 
	 * @param os - takes objectOutputStream object as an argument
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream os) throws IOException{
		os.defaultWriteObject();
		os.writeObject(getId());
		os.writeObject(getName());
		os.writeObject(getProfession());
		os.writeObject(getDateofBirth());
		pw = new PrintWriter(new FileWriter("awards.csv",true));
		pw.print(getAwards());
		pw.close();
	}
	
	
	/**
	 * method to deserialize objects from an object input stream
	 * implements defaultReadObject method first
	 * reads in the individual attributes and casts them to the appropriate type
	 * sets the current objects attributes to the ones that have been read in
	 * reads in awards from csv file using a buffered reader 
	 * uses comma as a delimiter
	 * reads in all attributes as tokens andcreates an award object 
	 * adds award to the correct instance of a Celebrity's awards array list
	 * @param is - takes objectInputStream object as an argument
	 * @throws IOException - thrown if an issue occurs with the I/O
	 * @throws ClassNotFoundException - thrown if a class that is being used cannot be found
	 * 
	 */
	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException{
		
		is.defaultReadObject();
		
		int id = (int) is.readObject();
		String name = (String) is.readObject();
		String job  = (String) is.readObject();
		LocalDate dob = (LocalDate) is.readObject();
		
		this.setId(id);
		this.setName(name);
		this.setProfession(job);
		this.setDateofBirth(dob);		
		
		
		bufferedIn = new BufferedReader(new FileReader("awards.csv"));
		String line = null;
		this.awards = new ArrayList<>();
		while((line = bufferedIn.readLine()) != null )
		{	
			Scanner scan = new Scanner(line);
			scan.useDelimiter(",");
			
			while(scan.hasNext())
			{
				String aName = scan.next();
				String org = scan.next();
				LocalDate date = LocalDate.parse(scan.next());
				String c = scan.next();
				
				if(c.equalsIgnoreCase(name))
				{
					Award a = new Award(aName,org,date);
					this.addAward(a);
				}
			}
		}
	}

	/**
	 * @author Michael Rice
	 * @param id - the ID number to be set for a celebrity object
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name - the name to be set for a celebrity object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param profession - the profession to be set for a celebrity object
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @param dateofBirth - the date of birth to be set for a celebrity object
	 */
	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	/**
	 * 
	 * @return - a celebrity object's id number
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return - a celebrity object's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return - a celebrity object's profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @return - a celebrity object's date of birth
	 */
	public LocalDate getDateofBirth() {
		return dateofBirth;
	}
	
	@Override
	/**
	 * toString method that overrides the default
	 * @return a formatted string with all details about a given celebrity object in the required format
	 */
	public String toString()
	{
		return String.format("ID:%d,Name:%s,Profession:%s,Date of Birth:%s", this.getId(),this.getName(),this.getProfession(),this.getDateofBirth().toString());
	}
	
	
}
