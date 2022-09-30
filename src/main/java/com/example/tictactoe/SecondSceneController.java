package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SecondSceneController implements Initializable {
    @FXML
    private Button sound;
    @FXML
    private TextField userName;

    @FXML
    void firstMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    void gameScene(ActionEvent event) throws IOException {
        if (userName.getText().length() == 0) {
            return;
        }
        String user = userName.getText();
        User holder = User.getInstance();
        holder.setUser(user);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Music.getInstance().getMediaPlayer().isMute()) {
            sound.setText("Sound : off");
        } else {
            sound.setText("Sound : on");
        }
    }
}