package application;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class DefinitionsController implements Initializable {
	public DefinitionsController(){
		
	}
	
	@FXML 
	private Button logConsole;		//this is a skeleton since the definitions tab in our software has no interactive features
	
	@FXML
	public void changeToConsole(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Home Page.fxml");
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}