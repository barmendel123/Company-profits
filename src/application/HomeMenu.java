package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class HomeMenu implements Initializable
{
	 boolean found=false;
	
	@FXML
    private void AddEmployee(ActionEvent event) throws IOException 
	{
		
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeeAdd.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));  
        stage.show();
      ((Node) event.getSource()).getScene().getWindow().hide();
	}

	

	@FXML
    private void AddDepartment(ActionEvent event) throws IOException 
	{

		TextInputDialog dialog = new TextInputDialog("Enter Department Name");
		 
        dialog.setTitle("Department Addition");
        dialog.setHeaderText("Enter Department: ");
        dialog.setContentText("Department: ");
 
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
           
        	Departments.departments.add(name);
        	Departments.WriteData();
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	
			alert.setContentText("Department Added");
			alert.show();
        });
	}
	
	@FXML
    private void AddRole(ActionEvent event) throws IOException 
	{

		TextInputDialog dialog = new TextInputDialog("Enter Role Name");
		 
        dialog.setTitle("Role Addition");
        dialog.setHeaderText("Enter Role: ");
        dialog.setContentText("Role: ");
 
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
           
        	 Role.roles.add(name);
        	 Role.WriteData();
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	
			alert.setContentText("Role Added");
			alert.show();
        });
	}
	
	
	@FXML
    private void RemoveEmployee(ActionEvent event) throws IOException 
	{

		TextInputDialog dialog = new TextInputDialog("Enter Employee Name");
		 
        dialog.setTitle("Employee Removal");
        dialog.setHeaderText("Enter Employee: ");
        dialog.setContentText("Employee: ");
 
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
           
        	for(int i=0;i<Employee.Employees.size();i++)
        	{
        			if(Employee.Employees.get(i).GetName().equals(name))
        		{
        			found=true;
        			Employee.Employees.remove(i);
        			Alert alert = new Alert(Alert.AlertType.INFORMATION);
        			alert.setContentText("Employee Removed;");
        			alert.show();
        			Employee.WriteData();
        			break;
        		}
        	}
        	if(!found)
        	{
        		
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("Employee Not Found");
    			alert.show();
        	}
        });
	}
	
	@FXML
    private void CompanyRules(ActionEvent event) throws IOException 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ComapnyProfitLoss.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));  
        stage.show();
      ((Node) event.getSource()).getScene().getWindow().hide();
	}
	
	@FXML
    private void WorkerRules(ActionEvent event) throws IOException 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WorkerRules.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));  
        stage.show();
      ((Node) event.getSource()).getScene().getWindow().hide();
	}
	@FXML
    private void JobRules(ActionEvent event) throws IOException 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JobPreference.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));  
        stage.show();
      ((Node) event.getSource()).getScene().getWindow().hide();
	}
	@FXML
    private void RemoveDepartment(ActionEvent event) throws IOException 
	{

		TextInputDialog dialog = new TextInputDialog("Enter Department Name");
		 
        dialog.setTitle("Department Removal");
        dialog.setHeaderText("Enter Department: ");
        dialog.setContentText("Department: ");
 
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
           
        	for(int i=0;i<Departments.departments.size();i++)
        	{
        			if(Departments.departments.get(i).equals(name))
        		{
        			found=true;
        			Departments.departments.remove(i);
        			Alert alert = new Alert(Alert.AlertType.INFORMATION);
        			alert.setContentText("Department Removed;");
        			alert.show();
        			Departments.WriteData();
        			break;
        		}
        	}
        	if(!found)
        	{
        		
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("Department Not Found");
    			alert.show();
        	}
        });
	}
	
	
	@FXML
    private void RemoveRole(ActionEvent event) throws IOException 
	{

		TextInputDialog dialog = new TextInputDialog("Enter Role Name");
		 
        dialog.setTitle("Role Removal");
        dialog.setHeaderText("Enter Role: ");
        dialog.setContentText("Role: ");
 
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
           
        	for(int i=0;i<Role.roles.size();i++)
        	{
        			if(Role.roles.get(i).equals(name))
        		{
        			found=true;
        			 Role.roles.remove(i);
        			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        			 alert.setContentText("Role Removed;");
        			 alert.show();
        			 Role.WriteData();
        			break;
        		}
        	}
        	if(!found)
        	{
        		
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setContentText("Role Not Found");
    			alert.show();
        	}
        });
	}
	
	
	
	@FXML
    private void ExitButton(ActionEvent event) throws IOException 
	{
		
		Platform.exit();
		    
	}




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		try {
			Departments.LoadData();
			Role.LoadData();
			Employee.LoadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	
}
