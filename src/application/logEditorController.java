package application;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class logEditorController implements Initializable {
	public logEditorController(){
		
	}
	
	@FXML 
	private Button logConsole;
	@FXML 
    private ChoiceBox<String> LIFE;
	@FXML 
    private ChoiceBox<String> PR;
	@FXML 
    private ChoiceBox<String> LOGE;
	@FXML 
    private ChoiceBox<String> EFFORT;
	@FXML 
    private ChoiceBox<String> PLANS;
	
	@FXML
    private TextField dateField = new TextField();

    @FXML
    private TextField startField;
    
    @FXML
    private TextField stopField;
	
    @FXML 
    private Label updated;
	@FXML 
	private Button clearLog;
	@FXML 
	private Button updateLog;
	
	
	
	@FXML
	public void changeToConsole(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Home Page.fxml");
	}
	@FXML
	public void changeLogEntry(ActionEvent event) throws IOException {
		//if(Main.Development.isEmpty()){ 
			//LogEntry test 
			//System.out.println(Main.Business.get(Main.index).getEffortCategoryLog());
			LogEntry test; 
			if(PR.getValue() == "Business Project") {
				test = Main.Business.get(Main.index);
			}
			else {
				test = Main.Development.get(Main.index);
			}
            //updated.setText("The attributes have been saved");
            String lcs = LIFE.getValue();
            String ec = EFFORT.getValue();
            String plan = PLANS.getValue();
            String inDate = dateField.getText().toString();
            String inStart = startField.getText().toString();
            String inStop = stopField.getText().toString();
            
            LocalDate date = LocalDate.parse(inDate);
            LocalTime start = LocalTime.parse(inStart);
            LocalTime stop = LocalTime.parse(inStop);
            
            test.setLifeCycyleLog(lcs);
            test.setEffortCategoryLog(ec);
            test.setPlan(plan);
            test.setStart(start);
            test.setDate(date);
            test.setStop(stop);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	//the following code updates the content of drop down menus and initializes the log editor
		// TODO Auto-generated method stub
		PR.getItems().addAll(Main.projects);
		PR.setValue("Business Project");
		
		LIFE.getItems().addAll(Main.LifeCycle);
        PLANS.getItems().addAll(Main.PLANS);
        EFFORT.getItems().addAll(Main.EffortCategory);
        //LOGE.getItems().addAll(Main.businessString);
        
        PR.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {	//the following code adds a listener which can track live changes to our software
        	//PR.getItems().addAll(Main.projects);
    		//PR.setValue("Business Project");
    		String info = "";
        	Main.businessString.clear();	//resets the values within the choiceboxes depending on the specified selection
        	Main.developmentString.clear();
        	for (int i = 0; i < Main.getEntries(PR.getValue()).size(); i++) {
    			info = Main.getEntries(PR.getValue()).get(i).getDate() + " " + Main.getEntries(PR.getValue()).get(i).getStart() + " " + Main.getEntries(PR.getValue()).get(i).getStop() + " " + Main.getEntries(PR.getValue()).get(i).getLifeCycleLog() + " " + Main.getEntries(PR.getValue()).get(i).getEffortCategoryLog();
    			
    			//Main.businessString.add(info);
    			if (newSelection.equals("Business Project")) {
    				Main.businessString.add(info);
    				
    			}
    			else {
    				Main.developmentString.add(info);
    			}
    			//LOGE.getItems().add(info);
    		}
        	if(newSelection == "Business Project") {
        		LOGE.getItems().clear();
        		LOGE.getItems().addAll(Main.businessString);	
        	}
        	else {
        		LOGE.getItems().clear();
        		LOGE.getItems().addAll(Main.developmentString);
        	}
        	
        	LOGE.getSelectionModel().selectedItemProperty().addListener((obs1, oldSelection1, newSelection1) -> {	//another listener which can update the content of the controller page based off of user input
        	if(newSelection.equals("Business Project")) {
	        	Main.index = Main.businessString.indexOf(newSelection1);
	        	LIFE.setValue(Main.Business.get(Main.index).getLifeCycleLog());
	            EFFORT.setValue(Main.Business.get(Main.index).getEffortCategoryLog());	//the following two pieces of code take the data from the effort logs and automatically input them 
	            PLANS.setValue(Main.Business.get(Main.index).getPlan());
	            dateField.setText(Main.Business.get(Main.index).getDate().toString());
	            stopField.setText(Main.Business.get(Main.index).getStop().toString());
	            startField.setText(Main.Business.get(Main.index).getStart().toString());
	            
        	}
        	else {
        		Main.index = Main.developmentString.indexOf(newSelection1);
	        	LIFE.setValue(Main.Development.get(Main.index).getLifeCycleLog());
	            EFFORT.setValue(Main.Development.get(Main.index).getEffortCategoryLog());
	            PLANS.setValue(Main.Development.get(Main.index).getPlan());
	            dateField.setText(Main.Development.get(Main.index).getDate().toString());
	            stopField.setText(Main.Development.get(Main.index).getStop().toString());
	            startField.setText(Main.Development.get(Main.index).getStart().toString());
        	}
        	});
        }); 
        
	}
	
}
