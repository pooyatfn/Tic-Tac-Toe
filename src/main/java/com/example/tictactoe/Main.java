package com.example.tictactoe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 450);
        stage.setTitle("tic-tac-toe");
        stage.setScene(scene);
        Platform.runLater(() -> {
            Music music = Music.getInstance();
            music.setMediaPlayer();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}