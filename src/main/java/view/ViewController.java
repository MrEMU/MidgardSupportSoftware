package main.java.view;

import 	main.java.control.Settings;
import main.java.view.editor.Toolbar;
import main.java.view.main.MapView;
import main.java.view.main.MenuBar;

import java.util.LinkedList;

import javafx.application.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Stef
 *
 */
public class ViewController extends Application {

	private static BorderPane root;
	private static Scene scene;
	private static MenuBar bar;
	private static LinkedList<Node> views;
	private static MapView mapView;

	public static enum ViewModes {

		EDITVIEW, PRESENTVIEW
	};


	/**
	 *
	 */
	@Override
	public void start(Stage pS) throws Exception {

		Settings.applySettings();
		drawApplication(pS);
	}

	/**
	 *
	 */
	private void drawApplication(Stage pS) {

		//Init. View
		EditView editView = new EditView();

		//Init. Main Items
		pS.setTitle("Midgard Companion rev 1");
		root = new BorderPane();
		bar = new MenuBar();
		mapView = new MapView();

		setView(ViewModes.EDITVIEW);
		scene = new Scene(root, 800, 800);
		pS.setScene(scene);
		pS.show();

	}

	private void setView(ViewModes view) {
		root.getChildren().clear();
		root.setTop(bar);
		switch(view){

		case EDITVIEW:
			root.setCenter(mapView);
		default:
			break;
		}

	}

	public static void go() {
		ViewController.launch();

	}

	public static MenuBar getBar() {
		return bar;
	}

	public static LinkedList<Node> getViews() {
		return views;
	}

	public static MapView getMapView() {
		return mapView;
	}

}
