package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;  


public class homeController implements Initializable {
	public homeController(){
		
	}
	
	@FXML 
	private Button logEditor;
	@FXML 
	private Button logDefect;
	@FXML   
	private Button logED;
	@FXML 
	private Button Definitions;
	@FXML 
	private Button activityStart;
	@FXML 
	private Button activityStop;
	@FXML
	private Button activityResume;
	@FXML
	private Button activityPause; 
	@FXML
	private Button logOut;
	@FXML 
	private Rectangle color;
	@FXML 
	private Label clockStatus;
	@FXML 
	 private ChoiceBox<String> LifeCycleA;
	@FXML 
	 private ChoiceBox<String> ProjectChoice;
	@FXML 
	 private ChoiceBox<String> Effort;
	@FXML 
	 private ChoiceBox<String> plan;
	
	boolean clockStopped = true;
	boolean clockPaused = false;
	
	Timer timer = new Timer();
	
	@FXML
	public void changeToEditor(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("LogEditor.fxml");
	}
	
	
	@FXML
	public void changeToDefect(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("DefectConsole.fxml");
	}
	
	@FXML
	public void changeToDefinitions(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Definitions.fxml");
	}
	
	@FXML
	public void changeToEDLog(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("EDLog.fxml");
	}
	
	@FXML
    public void logOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("LogInScreen.fxml");
    }
	
	@FXML 
	public void clockStart(ActionEvent event) throws IOException { //VEDANSH ADD START FUNCTION HERE
		if(clockStopped && !clockPaused) {
			timer.start();
			clockStatus.setText("CLOCK IS RUNNING");
			color.setFill(Color.GREEN);
			clockStopped = false;
			clockPaused = false;
			
		}
	}
	
	@FXML 
	public void clockStop(ActionEvent event) throws IOException { //VEDANSH add STOP FUNCTION HERE 
		if(!clockStopped || clockPaused) {
				clockStatus.setText("CLOCK IS STOPPED AT TIME: "+ timer.displayTime());
				String time = timer.displayTime();
				timer.clear();
				color.setFill(Color.RED);
				clockStopped = true;
				clockPaused = false;
				if(ProjectChoice.getValue()=="Business Project") {
					Main.Business.add(new LogEntry(Main.index, LocalDate.now(), timer.getStart(), timer.getStop(), time, LifeCycleA.getValue(), Effort.getValue(), plan.getValue()));
					Main.index++;	
				}
				else {
					Main.Development.add(new LogEntry(Main.index, LocalDate.now(), timer.getStart(), timer.getStop(), time, LifeCycleA.getValue(), Effort.getValue(), plan.getValue() ));
					Main.index++;
				}
		}
	}
	
	@FXML 
	public void clockResume(ActionEvent event) throws IOException { //VEDANSH ADD RESUME FUNCTION HERE
		if(clockPaused) {
			
			clockStatus.setText("CLOCK IS RUNNING");
			timer.resume();
			color.setFill(Color.GREEN);
			clockPaused = false;
			clockStopped = false;
		}
	}
	
	@FXML 
	public void clockPause(ActionEvent event) throws IOException { //VEDANSH add PAUSE FUNCTION HERE 
		if(!clockStopped) {
			timer.pause();
				clockStatus.setText("CLOCK IS PAUSED AT TIME: "+ timer.displayTime());
				color.setFill(Color.BLUE);
				clockPaused = true;
				clockStopped = true;
				
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		LifeCycleA.getItems().addAll(Main.LifeCycle);
		ProjectChoice.getItems().addAll(Main.projects);
		plan.getItems().addAll(Main.PLANS);
		Effort.getItems().addAll(Main.EffortCategory);
	}
	
}
