package application;

public class Preferences {

	int startinghours;
	int startingminutes;
	int endingminutes;
	int endinghours;
	
	Preferences()
	{
		startinghours=9;
		startingminutes=0;
		endinghours=17;
		endingminutes=0;
		
	}
	public void SetTime(int startinghours,int startingminutes,int endinghours,int endingminutes)
	{
		this.startinghours=startinghours;
		this.startingminutes=startingminutes;
		this.endinghours=endinghours;
		this.endingminutes=endingminutes;
	}
	public int getStartingHours()
	{
		return startinghours;
	}
	public int getStartingminutes()
	{
		return startingminutes;
	}
	public int getEndingHours()
	{
		return endingminutes;
	}
	public int getEndingminutes()
	{
		return endinghours;
	}
}
