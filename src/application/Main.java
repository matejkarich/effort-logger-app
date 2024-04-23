package application;
	
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import java.util.Date;


public class Main extends Application {
	
	
	private static Stage stg;
	protected static Dictionary<String, String> users = new Hashtable<>(); //temporary data structure instead of a database
	protected static ArrayList<String> names = new ArrayList<String>();
	
	protected static String[] projects = {"Business Project","Development Project"};
    protected static String[] LifeCycle = {"Planning","Information Gathering","Information Gathering","Verifying","Outlining","Drafting","Finalizing","Team Meeting","Finalizing","Team Meeting","Coach Meeting","Stakeholder"};
    protected static String[] EffortCategory = {"Plans","Deliverables","Interruptions","Defects","Others"};
    protected static ArrayList<String> LogEntry = new ArrayList<String>(Arrays.asList("Abbbbbb"));
    protected static String[] DefectEntry = {"Bbbbbbb"};
    protected static String[] PLANS = {"Project Plan","Risk Management","Risk Managment","Conceptual Design Plan","Detailed Design Plan","Implementation Plan"};
    protected static ObservableList<LogEntry> Business = FXCollections.observableArrayList();
    protected static ObservableList<LogEntry> Development = FXCollections.observableArrayList();
    protected static ArrayList<String> businessString = new ArrayList<String>(Arrays.asList("testbus"));
    protected static ArrayList<String> developmentString = new ArrayList<String>(Arrays.asList("testdev"));
    protected static int index = 1;

    
    
    public void start(Stage primaryStage) throws Exception{
		try {
			stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
			Scene scene = new Scene(root, 875, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//protected static void addEntry(int indexed, LocalDate date , LocalTime start, LocalTime stop, String time, String Lifecyclestep, String EffortCategoryStep) {}
	
	public static ObservableList<LogEntry> getEntries(String choice)
    {
        /*
		ObservableList<LogEntry> entries = FXCollections.observableArrayList();
        entries.add(new LogEntry(1, LocalDate.of(1915, Month.DECEMBER, 12), 2, 3, "timer", "LifeCycle", "EffortCategory"));
        */
		if(choice == "Business Project") {
			return Business;
		}
		else if(choice == "Development Project") {
			return Development;
		}
		
        return Business;
    
    }
	
}
