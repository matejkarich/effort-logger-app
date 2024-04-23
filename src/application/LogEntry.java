package application;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LogEntry {
	private SimpleIntegerProperty index;
	private LocalDate date;
	private LocalTime start;
	private LocalTime stop;
	private SimpleStringProperty time;
	private SimpleStringProperty LifeCycleLog;
	private SimpleStringProperty EffortCategoryLog;
	private SimpleStringProperty Plan;
	
	
	LogEntry(int index, LocalDate date, LocalTime start, LocalTime stop, String time, String LifeCycleLog, String EffortCategoryLog, String Plan) {
		this.index = new SimpleIntegerProperty(index);
		this.date = date;
		this.start = start;
		this.stop = stop;
		this.time =  new SimpleStringProperty(time);
		this.LifeCycleLog = new SimpleStringProperty(LifeCycleLog);				//constructor that creates the basis for entries into the effort log editor
		this.EffortCategoryLog = new SimpleStringProperty(EffortCategoryLog);
		this.Plan = new SimpleStringProperty(Plan);
	}
	
	
	public int getIndex() {			//necessary getters and setters
		return index.get();
	}

	public void setIndex(int index) {
		this.index = new SimpleIntegerProperty(index);
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getStop() {
		return stop;
	}

	public void setStop(LocalTime stop) {
		this.stop = stop;
	} 

	public String getTime() {
		return time.get();
	}

	public void setTime(SimpleStringProperty time) {
		this.time = time;
	}

	public String getLifeCycleLog() {
		return LifeCycleLog.get();
	}

	public void setLifeCycyleLog(String LifeCycleLog) {
		this.LifeCycleLog = new SimpleStringProperty(LifeCycleLog);
		
	}

	public String getEffortCategoryLog() {
		return EffortCategoryLog.get();
	}

	public void setEffortCategoryLog(String EffortCategoryLog) {
		this.EffortCategoryLog = new SimpleStringProperty(EffortCategoryLog);
	}


	public String getPlan() {
		return Plan.get();
	}


	public void setPlan(String Plan) {
		this.Plan = new SimpleStringProperty(Plan);
	}

	
	
}
