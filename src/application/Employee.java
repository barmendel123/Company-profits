package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Employee {

	
	String Name;
	int PreferenceMode;
	String PaymentMethod;
	String Department;
	String Job;
	String Role;
	Preferences Preference;
	
	static ArrayList<Employee> Employees = new ArrayList<Employee>();
	
	Employee(String Name,int PreferenceMode,String PaymentMethod,String Department,String job,String Role,Preferences  Pref)
	{
		this.Name=Name;
		this.PreferenceMode=PreferenceMode;
		this.PaymentMethod=PaymentMethod;
		this.Department=Department;
		this.Job=job;
		this.Role=Role;
		this.Preference=Pref;
		
	}
	public String GetName()
	{
		return Name;
	}
	public int getPreference()
	{
		return PreferenceMode;
	}
	public String getPaymentMethod()
	{
		return PaymentMethod;
	}
	public String GetDepartment()
	{
		return Department;
	}
	public String GetJob()
	{
		return Job;
	}
	public String GetRole()
	{
		return Role;
	}
	public Preferences GetPreference()
	{
		return Preference;
	}
	public static void LoadData() throws IOException
	{
		 File file = new File("EmployeeDBFile.txt");
		 Employees.clear();
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  
		  String st;
		  while ((st = br.readLine()) != null)
		  {
		
			  if(st.length()>3)
			  {
			
			  Preferences temp=new Preferences();
			  temp.SetTime(Integer.parseInt(st.split(",",10)[6]),Integer.parseInt(st.split(",",10)[7]),Integer.parseInt(st.split(",",13)[8]),Integer.parseInt(st.split(",",13)[9]));
			  Employees.add(new Employee(st.split(",",10)[0],Integer.parseInt(st.split(",",10)[1]),st.split(",",10)[2],st.split(",",10)[3],st.split(",",10)[4],st.split(",",10)[5],temp));
			  
			  }
			  }
	}
	public static void WriteData()
	{
		try {
		      FileWriter myWriter = new FileWriter("EmployeeDBFile.txt");
		   
		    	
		      
		      for(int i=0;i<Employees.size();i++)
		      {
		    	  myWriter.write(Employees.get(i).GetName());
		    	  myWriter.write(",");
		    	
		    	  myWriter.write(String.valueOf(Employees.get(i).getPreference()));
		    	  myWriter.write(",");
		    	
		    	  myWriter.write(String.valueOf(Employees.get(i).getPaymentMethod()));
		    	  myWriter.write(",");
		    	  
		    	  myWriter.write(String.valueOf(Employees.get(i).GetDepartment()));
		    	  myWriter.write(",");
		    	  
		    	  myWriter.write(String.valueOf(Employees.get(i).GetJob()));
		    	  myWriter.write(",");
		    	  myWriter.write(String.valueOf(Employees.get(i).GetRole()));
		    	  myWriter.write(",");
		    	  
		    	  myWriter.write(String.valueOf(Employees.get(i).GetPreference().getStartingHours()));
		    	  myWriter.write(",");
		    	  myWriter.write(String.valueOf(Employees.get(i).GetPreference().getStartingminutes()));
		    	  myWriter.write(",");
		     	  myWriter.write(String.valueOf(Employees.get(i).GetPreference().getEndingminutes()));
		    	  myWriter.write(",");
				   
		    	  myWriter.write(String.valueOf(Employees.get(i).GetPreference().getEndingHours()));
		    

		    	
		    	  myWriter.write("\n");
		    	
		      }
		      
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public float GetEfficiency(int startingtime ,int endingtime)
	{
		float efficiency=0;
		int h;
		
		if(PreferenceMode==3)
		{
			efficiency=(12*9);
		}
		else if(PreferenceMode!=4)
		{
			if(startingtime>Preference.startinghours)
			{
				
				int hours=startingtime-Preference.startinghours;
				efficiency=efficiency+(8*hours);
				efficiency=efficiency+(12*(9-hours));
			}
			else
			{
				int hours=Preference.endinghours-endingtime;
				efficiency=efficiency+(8*hours);
				efficiency=efficiency+(12*(9-hours));
			}
		}
		else
		{
			efficiency=(11*9);
		}
		return efficiency;
	}

	public float GetEfficiency()
	{
		
			int efficiency=(12*9);
			return efficiency;
	}
		
}
