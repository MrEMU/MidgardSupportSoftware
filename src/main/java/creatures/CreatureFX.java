package main.java.creatures;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.util.Callback;
import main.java.control.Settings;
import main.java.util.Creature;
import main.java.util.CreatureRessources;

import java.util.ArrayList;

//import javax.swing.*;
//import java.awt.*;

public class CreatureFX extends Application {

    private static GridPane root;
    private static Scene scene;
    private ChoiceBox choiceTRegion;
    private ChoiceBox choiceRegion;


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
        pS.setTitle("Kreaturenlexikon");
        root = new GridPane();
        root.setGridLinesVisible(true);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setHgap(5.0);
        root.setVgap(5.0);
        VBox leftpanel = new VBox();
        VBox rightpanel = new VBox();

        Label region = new Label("Wähle Region/Sonstiges:");
        region.setFont(new Font("Times New Roman", 18));
        AnchorPane label1 = new AnchorPane();
        AnchorPane.setTopAnchor(label1, 300.0);
        AnchorPane.setLeftAnchor(label1, 500.0);
        label1.getChildren().add(region);
        leftpanel.getChildren().add(label1);

        choiceRegion = new ChoiceBox(FXCollections.observableArrayList(
                "Lamaran", "Nahuatlan", "Sirao", "Vesternesse", "Inseln", "Meere", "Sonstige"));
        AnchorPane choice1 = new AnchorPane();
        AnchorPane.setTopAnchor(choice1, 300.0);
        AnchorPane.setLeftAnchor(choice1, 500.0);
        choice1.getChildren().add(choiceRegion);
        leftpanel.getChildren().add(choice1);

        Label tregion = new Label("Wähle die Teilregion/Unterkategorie:");
        tregion.setFont(new Font("Times New Roman", 18));
        AnchorPane label2 = new AnchorPane();
        AnchorPane.setTopAnchor(label2, 300.0);
        AnchorPane.setLeftAnchor(label2, 500.0);
        label2.getChildren().add(tregion);
        leftpanel.getChildren().add(label2);

        choiceTRegion = new ChoiceBox(FXCollections.observableArrayList(
                "Buluga", "Eschar (Kairawan & Elhaddar)", "Ikenga Becken", "Küstenstaaten", "Mokattam", "Urruti"));
        AnchorPane choice2 = new AnchorPane();
        AnchorPane.setTopAnchor(choice2, 300.0);
        AnchorPane.setLeftAnchor(choice2, 500.0);
        choice2.getChildren().add(choiceTRegion);
        leftpanel.getChildren().add(choice2);

        Button go = new Button("GO");
        AnchorPane button = new AnchorPane();
        AnchorPane.setTopAnchor(button, 300.0);
        AnchorPane.setLeftAnchor(button, 500.0);
        button.getChildren().add(go);
        leftpanel.getChildren().add(button);

        CreatureRessources.init();
        ObservableList<Creature> standard = FXCollections.observableArrayList(CreatureRessources.getFilteredBySubRegion(0, "Buluga"));
        System.out.println(standard);
        TableView table = new TableView(standard);
        table.setEditable(false);
        TableColumn<Creature,String> speciesCol = new TableColumn<Creature,String>("Spezies");
        speciesCol.setMinWidth(200);
        speciesCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Creature, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Creature, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSpecies());
            }
        });
        table.getColumns().add(speciesCol);
        TableColumn<Creature,String> typeCol = new TableColumn<Creature,String>("Gattung");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Creature, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Creature, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getType());
            }
        });
        table.getColumns().add(typeCol);
        TableColumn<Creature,String> habitatCol = new TableColumn<Creature,String>("Lebensraum");
        habitatCol.setMinWidth(200);
        habitatCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Creature, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Creature, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getHabitat());
            }
        });
        table.getColumns().add(habitatCol);
        TableColumn<Creature,String> alternativesCol = new TableColumn<Creature,String>("Alias");
        alternativesCol.setMinWidth(200);
        alternativesCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Creature, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Creature, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getAlternatives());
            }
        });
        table.getColumns().add(alternativesCol);
        TableColumn<Creature,String> sourceCol = new TableColumn<Creature,String>("Quelle");
        sourceCol.setMinWidth(200);
        sourceCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Creature, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Creature, String> p) {
                return new ReadOnlyObjectWrapper(p.getValue().getSource());
            }
        });
        table.getColumns().add(sourceCol);
        rightpanel.getChildren().add(table);


        choiceRegion.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    public void changed(ObservableValue ov,
                        Number value, Number new_value) {
                            setSecondChoice(new_value);
            }
        }
        );

        go.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String region = choiceRegion.getValue().toString();
                String Tregion = choiceTRegion.getValue().toString();
                ObservableList<String> choices = choiceRegion.getItems();
                int tr = -1;
                for(int i=0;i<choices.size();i++){
                    if(choices.get(i).equals(region)){
                        tr = i;
                    }
                }
                ObservableList<Creature> newItems = FXCollections.observableArrayList(CreatureRessources.getFilteredBySubRegion(tr, Tregion));
                table.setItems(newItems);
            }
        });

        root.add(leftpanel,0,0);
        root.add(rightpanel,1,0);
        scene = new Scene(root, 1500, 500);
        scene.setFill(Color.BLACK);
        pS.setScene(scene);
        pS.sizeToScene();
        pS.show();
    }

    public void setSecondChoice(Number n) {
        int temp = n.intValue();
        switch(temp) {
            case 0 :
                choiceTRegion.setItems(FXCollections.observableArrayList(
                        "Buluga", "Eschar (Kairawan & Elhaddar)", "Ikenga Becken", "Küstenstaaten", "Mokattam", "Urruti"));
                break;
            case 1 :
                choiceTRegion.setItems(FXCollections.observableArrayList(
                        "Nahuatlan"));
                break;
            case 2 :
                choiceTRegion.setItems(FXCollections.observableArrayList(
                        "Aran", "KanThaiPan", "Medjis", "Minangpahit", "Moravod", "Rawindra", "Tegarische Steppe", "Waeland"));
                break;
            case 3 :
                choiceTRegion.setItems(FXCollections.observableArrayList(
                        "Alba", "Chryseia", "Clanngadarn", "Erainn", "Fuardain", "Ywerddon"));
                break;
            case 4 :
                choiceTRegion.setItems(FXCollections.observableArrayList(
                        "Feuerinseln", "Inseln unter dem Westwind", "Pfortenarchipel", "Serendib", "Valian"));
                break;
            case 5 :
                choiceTRegion.setItems(FXCollections.observableArrayList(
                        "Drachenmeer", "Golf der blauen Wellen", "Golf von Kanpur", "Meer der fünf Winde", "Meer der roten Sonne", "Meer der Seejungfrauen", "Regenbogensee", "Sednasee", "Waelingsee", "Wyrdsee"));
                break;
            case 6 :
                choiceTRegion.setItems(FXCollections.observableArrayList(
                        "Dämonen", "Elementarwesen", "Entseelte", "Geisterwesen", "Golems/Kunstwesen", "Götterboten", "Halbmenschen", "Menschenähnliche", "Naturgeister", "Schleimmonster", "Tiermenschen", "Untote", "Vampire", "Wendehäuter", "Werwesen"));
                break;
            default :
                System.out.println("Error: Something went wrong with choicebox selection");
                System.out.println(n);
                System.out.println(temp);

        }
    }

}
