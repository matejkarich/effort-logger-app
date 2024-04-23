package application;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EDLogController implements Initializable {

    @FXML private TableView<LogEntry> tableView;
	@FXML private TableColumn<LogEntry, Integer> index;
    @FXML private TableColumn<LogEntry, LocalDate> date;
    @FXML private TableColumn<LogEntry, Integer> start;
    @FXML private TableColumn<LogEntry, Integer> stop;
    @FXML private TableColumn<LogEntry, String> time;
    @FXML private TableColumn<LogEntry, String> LifeCycleLog;
    @FXML private TableColumn<LogEntry, String> EffortCategoryLog;
    @FXML private TableColumn<LogEntry, String> Plan;
    @FXML private ChoiceBox<String> ProjectChoice;
    @FXML private Button screenChange;

    
    @FXML
	public void changeToConsole(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Home Page.fxml");
	}
    
	@Override
	public void initialize(URL location, ResourceBundle rb) { 		//the following code initializes the log controller by setting default values for all control objects
		index.setCellValueFactory(new PropertyValueFactory<>("index"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		start.setCellValueFactory(new PropertyValueFactory<>("start"));
		stop.setCellValueFactory(new PropertyValueFactory<>("stop"));
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		LifeCycleLog.setCellValueFactory(new PropertyValueFactory<>("LifeCycleLog"));
		EffortCategoryLog.setCellValueFactory(new PropertyValueFactory<>("EffortCategoryLog"));
		Plan.setCellValueFactory(new PropertyValueFactory<>("Plan"));
		
		ProjectChoice.getItems().addAll(Main.projects);
		ProjectChoice.setValue("Business Project");
		tableView.setItems(Main.getEntries("Business Project"));
		
		ProjectChoice.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tableView.setItems(Main.getEntries(newSelection));
        });
	}
	/*
	public ObservableList<LogEntry> getEntries()
    {
        ObservableList<LogEntry> entries = FXCollections.observableArrayList();
        		entries.add(new LogEntry(1, LocalDate.of(1915, Month.DECEMBER, 12), 2, 3, 4, "hello", "world"));
        		entries.add(new LogEntry(1, LocalDate.of(1915, Month.DECEMBER, 14), 5, 6, 7, "hello", "world"));
        
        return entries;
    }
	*/
	
}
	

