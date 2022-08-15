package com.example.mathgame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MathGame extends Application {
    static Stage window;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MathGame.class.getResource("mathgame-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        window.setTitle("Math Game");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}