package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

public class AddEmployeeController implements Initializable
{
	@FXML
	private TextField NameField;
	
	@FXML
    private ComboBox PreferencesComboBox;
	
	@FXML
    private ComboBox PaymentComboBox;
	
	@FXML
    private ComboBox DepartmentsComboBox;
	
	@FXML
    private ComboBox 	RolesComboBox;
	
	@FXML
    private ComboBox 	JobComboBox;

	boolean TimeStatus;
	@FXML 
	private Button EXIT;
	
	Alert Erroralert = new Alert(Alert.AlertType.ERROR);
	
	int StartingHour;
	int StartingMinute;
	
	int EndingHour;
	int EndingMinute;
	
	public void AskStartingTime()
	{
		TextInputDialog dialog = new TextInputDialog("Enter Starting Time: (In Format HH:MM)");
		 
        dialog.setTitle("Starting Time");
        dialog.setHeaderText("Enter Starting Time: (In Format HH:MM)");
        dialog.setContentText("Time:");
 
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
            
        	if(name.length()!=5)
        	{
        	
        		Erroralert.setContentText("You have not written Time In Correct Format");
        		Erroralert.show();
        	}
        	else 
        	{
        		StartingHour=Integer.parseInt((String) name.split(":",5)[0]);
        		StartingMinute=Integer.parseInt((String) name.split(":",5)[1]);
        		
        		TimeStatus=true;
        	}
        	
        });
	}

	public void AskEndingTime()
	{
		TextInputDialog dialog = new TextInputDialog("Enter Ending Time: (In Format HH:MM)");
		 
        dialog.setTitle("Ending Time");
        dialog.setHeaderText("Enter Ending Time: (In Format HH:MM)");
        dialog.setContentText("Time:");
 
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
            
        	if(name.length()!=5)
        	{
        		TimeStatus=false;
        		Erroralert.setContentText("You have not written Time In Correct Format");
        		Erroralert.show();
        	}
        	else 
        	{
        		EndingHour=Integer.parseInt((String) name.split(":",5)[0]);
        		EndingMinute=Integer.parseInt((String) name.split(":",5)[1]);
        		
        
        		if(EndingHour-StartingHour!=9)
        		{
        			Erroralert.setContentText("Total Working Time must be of 9 hours");
            		Erroralert.show();
            		TimeStatus=false;
        		}
        		else
        		{
        			TimeStatus=true;
        		}
        		
        	}
        	
        });
	}
	public void StartDayEarlier()
	{
		
	}
	@FXML
	 private void BackButton(ActionEvent event) throws IOException 
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomeMenu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setScene(new Scene(root1));  
        stage.show();
      ((Node) event.getSource()).getScene().getWindow().hide();
	}
	// This is OnClick listener
	@FXML
    private void AddEmployee(ActionEvent event) throws IOException 
	{
		
		int PrefMode;

		Preferences Pref=new Preferences();
		
		String Prefer=PreferencesComboBox.getSelectionModel().getSelectedItem().toString();
		
	System.out.println(Prefer);
	if(!Prefer.equals("keep the day as the initial state"))
		
	{

		AskStartingTime();
		AskEndingTime();
		
		if(TimeStatus)
			Pref.SetTime(StartingHour,StartingMinute,EndingHour,EndingMinute);
		
		System.out.println(StartingHour);
		System.out.println(StartingMinute);
		System.out.println(EndingHour);
		System.out.println(EndingMinute);
		
		
	}
	else
		TimeStatus=true;
		if(TimeStatus)
		{
			
		
	
		
		if(Prefer.equals("start the day earlier and finish the day earlier"))
				PrefMode=1;
		else if(Prefer.equals("start the day later and finish the day later"))
			PrefMode=2;
		else if(Prefer.equals("keep the day as the initial state"))
			PrefMode=3;
		else 
			PrefMode=4;
		
		Employee.Employees.add(new Employee(NameField.getText(),PrefMode,PaymentComboBox.getSelectionModel().getSelectedItem().toString(),DepartmentsComboBox.getSelectionModel().getSelectedItem().toString(),JobComboBox.getSelectionModel().getSelectedItem().toString(),RolesComboBox.getSelectionModel().getSelectedItem().toString(),Pref));		
		Employee.WriteData();
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText("Employee Added Succesffuly");
		alert.show();
		}
	}

	
	@FXML
    private void LoadGameButton(ActionEvent event) throws IOException 
	{
	
		
	}
	
	@FXML
    private void SettingsButton(ActionEvent event) throws IOException 
	{
	
		
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
		
		for(int i=0;i<Departments.departments.size();i++)
		{
			DepartmentsComboBox.getItems().add(Departments.departments.get(i));
			RolesComboBox.getItems().add(Role.roles.get(i));
		}
		DepartmentsComboBox.getSelectionModel().select(0);
		RolesComboBox.getSelectionModel().select(2);
		
		
		PreferencesComboBox.getItems().addAll("start the day earlier and finish the day earlier", "start the day later and finish the day later", "keep the day as the initial state","To work from home");
		PreferencesComboBox.getSelectionModel().select(2);
	
		PaymentComboBox.getItems().addAll("Global payment ", "Per hour payment", "Per hour+ commission per sales in the month");
		PaymentComboBox.getSelectionModel().select(0);
		
		JobComboBox.getItems().addAll("Internee","Junior","Senior","Manager","Supervistor");
		JobComboBox.getSelectionModel().select(1);
	}
	
	
	
}
