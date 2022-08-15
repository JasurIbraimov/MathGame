package com.example.mathgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.Objects;

public class MathGameController {

    @FXML
    private Button addBtn;

    @FXML
    private Button divBtn;

    @FXML
    private Button multBtn;

    @FXML
    private Button subBtn;


    @FXML
    void initialize() {
        addBtn.setOnAction(event -> {
            openQuizScene(event, '+');
        });
        divBtn.setOnAction(event -> {
            openQuizScene(event, ':');
        });
        multBtn.setOnAction(event -> {
            openQuizScene(event, '*');
        });
        subBtn.setOnAction(event -> {
            openQuizScene(event, '-');
        });

    }
    void openQuizScene(ActionEvent event, char sign) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        //stage.close();
        try {
            FXMLLoader fxmlLoader =  new FXMLLoader(Objects.requireNonNull(getClass().getResource("quiz-view.fxml")));
            QuizController quizController = new QuizController();
            quizController.setSign(sign);
            fxmlLoader.setController(quizController);
            Parent root = fxmlLoader.load();
            Scene scene2 = new Scene(root, 600, 500);
            scene2.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    quizController.checkUserAnswer();
                    keyEvent.consume();
                }
            });
            stage.setScene(scene2);
            //stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}