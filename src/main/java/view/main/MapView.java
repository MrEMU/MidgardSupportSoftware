package main.java.view.main;

import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MapView extends ImageView {

	LinkedList<Image> images;
	int active;

	public MapView(){
		super();

		images = new LinkedList<Image>();
	}

	public void selectNewImage(){
		Stage tmp = new Stage();
		FileChooser fC = new FileChooser();
		File f = fC.showOpenDialog(tmp);
		try {
			Image img = new Image(new FileInputStream(f));
			images.add(img);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e){
			//TODO catch security err
			e.printStackTrace();
		}
	}

	public void setNewImage(int index){
		this.setImage(images.get(index));
		active = index;
	}



}
