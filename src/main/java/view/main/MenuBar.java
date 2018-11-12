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
			File f = new File("src/main/icons/upload.png");
			openMapIconImg = new Image(new FileInputStream(f.getAbsolutePath()));
			String openMapIconText = "Open";
			MenuButtonIconText b = new MenuButtonIconText(openMapIconImg, openMapIconText, new AddNewMapEvent<ActionEvent>() );

			this.getChildren().add(b);

			File css = new File("src/main/styles/menu.css");
			this.getStyleClass().add("menu");
			this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
