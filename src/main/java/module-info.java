module com.example.mathgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mathgame to javafx.fxml;
    exports com.example.mathgame;
}