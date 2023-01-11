package com.javafxproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private static Scene scene;
    Stage window;
    Scene scene1, scene2;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Bruno's window");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(9);
        grid.setHgap(9);

        //Name label 
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input 
        TextField nameInput = new TextField("Bruno");
        GridPane.setConstraints(nameInput, 1,0);

        //Password label 
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        //Password input 
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> isInt(nameInput, nameInput.getText()));
        GridPane.setConstraints(loginButton,1,2);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();

    }

    private boolean isInt(TextField input, String message) {
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + "is not a number");
            return false;
        }
        
    }



    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    

}