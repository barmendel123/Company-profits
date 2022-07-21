package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Role {
	
	static ArrayList<String> roles = new ArrayList<String>();
	public static void LoadData() throws IOException
	{
		 roles.clear();
		 File file = new File("RoleDBFile.txt");
		  
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  
		  String st;
		  while ((st = br.readLine()) != null)
			  Role.roles.add(st);
		 }
	public static void WriteData()
	{
		try {
		      FileWriter myWriter = new FileWriter("RoleDBFile.txt");
		      for(int i=0;i<roles.size();i++)
		      {
		    	  myWriter.write(roles.get(i));
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
