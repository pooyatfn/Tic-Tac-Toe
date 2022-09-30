module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;

    opens com.example.tictactoe to javafx.fxml;
    exports com.example.tictactoe;
}