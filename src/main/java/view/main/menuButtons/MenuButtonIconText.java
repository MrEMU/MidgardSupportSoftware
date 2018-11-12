package main.java.view.main.menuButtons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MenuButtonIconText extends Button{

	ImageView imgV;
	Label txt;

	public MenuButtonIconText(Image i, String text){

		imgV.setImage(i);
		txt.setText(text);
		this.getChildren().add(imgV);
		this.getChildren().add(txt);

	}

}
