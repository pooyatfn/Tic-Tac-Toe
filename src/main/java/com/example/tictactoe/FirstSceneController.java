package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FirstSceneController {
    @FXML
    private Button sound;
    @FXML
    private AnchorPane scenePane;

    @FXML
    void exit() {
        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    public void music() {
        if (sound.getText().equals("Sound : off")) {
            Music.play();
            sound.setText("Sound : on");
        } else {
            Music.stop();
            sound.setText("Sound : off");
        }
    }

    @FXML
    void secondMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("second-menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}