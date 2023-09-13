import java.time.LocalDate;

public class Award {

	String awardName;
	String awardOrganisation;
	LocalDate dateOfAward;
	
	/**
	 * 
	 * @param awardName - the name of the award 
	 * @param awardOrganisation - the organisation of the award
	 * @param dateOfAward - the date the award was given
	 */
	public Award(String awardName,String awardOrganisation,LocalDate dateOfAward)
	{
		this.awardName = awardName;
		this.awardOrganisation = awardOrganisation;
		this.dateOfAward = dateOfAward;
	}


	/**
	 * @return the name of a given award
	 */
	public String getAwardName() {
		return awardName;
	}

	/**
	 * 
	 * @return the organisation of a given award
	 */
	public String getAwardOrganisation() {
		return awardOrganisation;
	}

	/**
	 * 
	 * @return the date of a given award
	 */
	public LocalDate getDateOfAward() {
		return dateOfAward;
	}

	/**
	 * 
	 * @param awardName - sets the name of an award
	 */
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	/**
	 * 
	 * @param awardOrganisation - sets the organisation of an award
	 */
	public void setAwardOrganisation(String awardOrganisation) {
		this.awardOrganisation = awardOrganisation;
	}

	/**
	 * 
	 * @param dateOfAward - sets the date of a given award
	 */
	public void setDateOfAward(LocalDate dateOfAward) {
		this.dateOfAward = dateOfAward;
	}

}
