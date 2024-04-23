package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class defectController implements Initializable {
	
	//this class intializes the defect controller with basic default values
	public defectController(){
		
	}
	@FXML 
	private Button consoleButton;
	
	@FXML 
    private ChoiceBox<String> ProjectSelect;
	@FXML
	private ChoiceBox<String> DefectAa;
	@FXML
	public void changeToConsole(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Home Page.fxml");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ProjectSelect.getItems().addAll(Main.projects);
        DefectAa.getItems().addAll(Main.DefectEntry);
	}
	
	
	
}
