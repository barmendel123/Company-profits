package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Departments {
	
	static ArrayList<String> departments = new ArrayList<String>();
	public static void LoadData() throws IOException
	{
		Departments.departments.clear();
		 File file = new File("DepartmentsDBFile.txt");
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  
		  String st;
		  while ((st = br.readLine()) != null)
			  Departments.departments.add(st);
		 }
	public static void WriteData()
	{
		try {
		      FileWriter myWriter = new FileWriter("DepartmentsDBFile.txt");
		      for(int i=0;i<departments.size();i++)
		      {
		    	  myWriter.write(departments.get(i));
		    	  myWriter.write("\n");
		      }
		
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }	
	}
}
