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

public class CompanyProfitLoss implements Initializable
{
	
	@FXML
	private Text EmployeeText;
	
	@FXML
	private Text ProfitText;
	
	@FXML
	private Text LossText;
	
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
		float profit=0;
		float loss=0;
		for(int i=0;i<Employee.Employees.size();i++)
		{
			profit=profit+Employee.Employees.get(i).GetEfficiency(8,17);
		}
		EmployeeText.setText("Total Employee: "+Employee.Employees.size());
		if(profit>90*Employee.Employees.size())
			loss=0;
		
		ProfitText.setText("Profit: "+profit+"$");
		LossText.setText("Loss: "+loss+"$");
	}
	
	
}
