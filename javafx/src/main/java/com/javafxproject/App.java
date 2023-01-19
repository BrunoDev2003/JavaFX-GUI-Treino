package com.javafxproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application  {

    Stage window;
    static Scene scene;
    Button button;
    ComboBox<String> comboBox;
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("ChoiceBox Demo");
        button = new Button("Click me");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "Item 1",
            "Item 2",
            
        );

        comboBox.setPromptText("What is your favorite movie?");
        button.setOnAction(e -> printMovie());


        


        scene = new Scene(layout, 300, 500);
        window.setScene(scene);
        window.show();

    }

    //Print out a movie 
    private void printMovie() {
        System.out.println(comboBox.getValue());
    }

    private void getChoice(ChoiceBox<String> choiceBox) {
        String food = choiceBox.getValue();
        System.out.print(food);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    

}