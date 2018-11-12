package main.java.view.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import main.java.view.Events.AddNewMapEvent;
import main.java.view.main.menuButtons.MenuButtonIconText;

public class MenuBar extends HBox{

	private LinkedList<Button> thisMenuButtons;

	public MenuBar(){
		Image openMapIconImg;
		try {
			openMapIconImg = new Image(new FileInputStream("C:\\Users\\Stef\\Desktop\\upload.png"));
			String openMapIconText = "Open";
			MenuButtonIconText b = new MenuButtonIconText(openMapIconImg, openMapIconText, new AddNewMapEvent<ActionEvent>() );

			this.getChildren().add(b);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
