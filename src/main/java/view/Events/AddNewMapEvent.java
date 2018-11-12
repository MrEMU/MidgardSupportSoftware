package main.java.view.Events;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import main.java.view.ViewController;

public class AddNewMapEvent<T extends Event> implements EventHandler<T> {

	@Override
	public void handle(T arg0) {
		ViewController.getMapView().selectNewImage();
		ViewController.getMapView().setNewImage(0);

	}

}
