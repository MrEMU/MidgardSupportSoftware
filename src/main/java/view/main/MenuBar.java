package main.java.view.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import main.java.view.main.menuButtons.MenuButtonIconText;

public class MenuBar extends HBox{

	private LinkedList<Button> thisMenuButtons;

	public MenuBar(){
		Image openMapIconImg = new Image(new FileInputStream("C:\\Users\\Stef\\Desktop\\upload.png"));
		String openMapIconText = "Open";
		
		MenuButtonIconText b = new MenuButtonIconText(openMapIconImg, openMapIconText);
		

		this.getChildren().add(b);

	}


}
