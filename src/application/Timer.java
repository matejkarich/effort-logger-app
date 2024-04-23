package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;  


public class Timer 
{

	private Text time;
	private int hours;
	private int minutes;
	private int seconds;
	private Timeline timeline;
	private LocalTime startTime; 
	private LocalTime stopTime;
   
	public Timer() 
	{
	      hours = 0;
	      minutes = 0;
	      seconds = 0;

	      //time display set up
	      time = new Text();
	      time.setFont(Font.font(50));
	      displayTime();
	}
	
	public void start() 
	   {
			startTime = LocalTime.now();
			KeyFrame kf = new KeyFrame(Duration.millis(1000), e -> 
			{
				seconds++;
				displayTime();
			});

	      timeline = new Timeline(kf);
	      timeline.setCycleCount(Timeline.INDEFINITE);
	      timeline.play();
	   }

	   public void pause() 
	   {
	      timeline.pause();
	   }

	   public void resume() 
	   {
	      timeline.play();
	   }

	   public void clear() 
	   {
	      displayTime();
	      timeline.stop();
	      stopTime = LocalTime.now();
	      hours = 0;
	      minutes = 0;
	      seconds = 0;
	   }
	
	   public String displayTime() 
	   {
	      // flip 60 seconds over to a minute
	      if (seconds == 60) 
	      {
	         seconds = 0;
	         minutes++;
	      }

	      // flip 60 minutes over to an hour
	      if (minutes == 60) 
	      {
	         minutes = 0;
	         hours++;
	      }

	      // ensure that values < 10 are padded with a 0
	      String hh = hours >= 10 ? String.valueOf(hours) : "0" + String.valueOf(hours);
	      String mm = minutes >= 10 ? String.valueOf(minutes) : "0" + String.valueOf(minutes);
	      String ss = seconds >= 10 ? String.valueOf(seconds) : "0" + String.valueOf(seconds);

	      //time.setText(hh + ":" + mm + ":" + ss);
	      
	      return hh + ":" + mm + ":" + ss;
	   }
	   
	   public LocalTime getStart() {
		   return startTime.withNano(0);
	   }
	   public LocalTime getStop() {
		   return stopTime.withNano(0);
	   }	
	
}