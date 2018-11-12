package main.java.view.main.menuButtons;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.java.view.Events.AddNewMapEvent;

public class MenuButtonIconText extends Button{

	ImageView imgV;
	Label txt;

	public MenuButtonIconText(Image i, String text, EventHandler<ActionEvent> e){
		imgV = new ImageView();
		txt = new Label();
		imgV.setImage(i);
		txt.setText(text);
		//this.getChildren().add(imgV);
		this.getChildren().add(txt);
		this.setOnAction(e);
		this.setText("Maps");
		this.setGraphic(imgV);
		File css = new File("src/main/styles/menu.css");
		this.getStyleClass().add("menu");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));


	}

}
