package com.javafxproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Button button = new Button("click me");
        button.setOnAction(e -> {
            boolean result = confirmBox.display("Title of window", "are you sure you want to send naked pics to your ex GF??");
            System.out.println(result);
        });

        Button button2 = new Button("Close program");
        button2.setOnAction(e -> closeProgram());
        
        
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.getChildren().add(button2);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = confirmBox.display("title", "Sure you want to quit?");
        if(answer) {
            window.close();
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