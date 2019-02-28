package main.java.title;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.control.Settings;
import main.java.creatures.*;
import main.java.expCalc.gui.CalcFrame;
import main.java.plants.PlantFrame;
import main.java.util.Creature;
import main.java.view.EditView;
import main.java.view.ViewController;

import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class TitleFX extends Application {

    private static VBox root;
    private static Scene scene;


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

        pS.setTitle("Midgard Support Software");
        root = new VBox();
        Image image = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Titel.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView title = new ImageView();
        title.setImage(image);
        title.setPreserveRatio(true);
        title.setSmooth(true);
        title.setCache(true);

        AnchorPane titlepane = new AnchorPane();
        AnchorPane.setLeftAnchor(title, 600/2-image.getWidth()/2);

        titlepane.getChildren().add(title);
        root.getChildren().add(titlepane);
        Button exp = new Button("EXP Calculator");

        exp.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new CalcFrame(); // Let the constructor do the job
                    }
                });
            }
        });
        exp.setMinWidth(200);
        exp.setMinHeight(50);

        AnchorPane buttonpane1 = new AnchorPane();
        AnchorPane.setTopAnchor(exp, 50.0);
        AnchorPane.setLeftAnchor(exp, 600/2-exp.getMinWidth()/2);
        buttonpane1.getChildren().add(exp);
        root.getChildren().add(buttonpane1);

        Button plants = new Button("Plants");

        plants.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new PlantFrame(); // Let the constructor do the job
                    }
                });
            }
        });
        plants.setMinWidth(200);
        plants.setMinHeight(50);

        AnchorPane buttonpane2 = new AnchorPane();
        AnchorPane.setTopAnchor(plants, 25.0);
        AnchorPane.setLeftAnchor(plants, 600/2-exp.getMinWidth()/2);
        buttonpane2.getChildren().add(plants);
        root.getChildren().add(buttonpane2);

        Button creatures = new Button("Creatures");

        creatures.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                try{
                    new CreatureFX().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        creatures.setMinWidth(200);
        creatures.setMinHeight(50);

        AnchorPane buttonpane3 = new AnchorPane();
        AnchorPane.setTopAnchor(creatures, 25.0);
        AnchorPane.setLeftAnchor(creatures, 600/2-exp.getMinWidth()/2);
        buttonpane3.getChildren().add(creatures);
        root.getChildren().add(buttonpane3);

        Button weather = new Button("Weather");

        weather.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    Desktop.getDesktop().open(new File("src/main/resources/Wetter.pdf"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        weather.setMinWidth(200);
        weather.setMinHeight(50);

        AnchorPane buttonpane4 = new AnchorPane();
        AnchorPane.setTopAnchor(weather, 25.0);
        AnchorPane.setLeftAnchor(weather, 600/2-exp.getMinWidth()/2);
        buttonpane4.getChildren().add(weather);
        root.getChildren().add(buttonpane4);

        Button companion = new Button("Companion");

        companion.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                try{
                    new ViewController().start(new Stage());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        companion.setMinWidth(200);
        companion.setMinHeight(50);

        AnchorPane buttonpane5 = new AnchorPane();
        AnchorPane.setTopAnchor(companion, 25.0);
        AnchorPane.setLeftAnchor(companion, 600/2-exp.getMinWidth()/2);
        buttonpane5.getChildren().add(companion);
        root.getChildren().add(buttonpane5);

        scene = new Scene(root, 600, 800);
        scene.setFill(Color.BLACK);
        pS.setScene(scene);
        pS.sizeToScene();
        pS.show();

    }

    public static void go() {
        TitleFX.launch();

    }
}
