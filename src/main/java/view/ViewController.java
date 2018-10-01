package main.java.view;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewController extends Application {
	
	private static BorderPane root;
	private static Scene scene;
	
	@Override
	public void start(Stage pS) throws Exception {
		root = new BorderPane();
		pS.setTitle("Midgard Companion rev 0");
		scene = new Scene(root, 500, 500);
		pS.setScene(scene);
		pS.show();
		
		
	}

	public static void go() {
		ViewController.launch();
		
	}

}
