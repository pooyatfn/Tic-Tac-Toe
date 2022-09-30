package com.example.tictactoe;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GameSceneController implements Initializable {
    private ArrayList<Button> buttons = null;
    private int turn = 0;
    private double progress = 0;
    @FXML
    private Button sound;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label nameLabel;
    @FXML
    private Label gameLabel;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    public void buttonClick(ActionEvent event) {
        ((Button) event.getSource()).setText("X");
        ((Button) event.getSource()).setDisable(true);
        buttons.remove((Button) event.getSource());
        turn++;
        if (isFinish()) {
            return;
        }
        if (turn == 9) {
            finishGame();
            gameLabel.setText("DRAW!");
            return;
        }
        if (button1.getText().equals("") && (button2.getText().equals("O") && button3.getText().equals("O") || (button5.getText().equals("O") && button9.getText().equals("O")) || (button4.getText().equals("O") && button7.getText().equals("O")))) {
            selectButton(button1);
        } else if (button2.getText().equals("") && (button1.getText().equals("O") && button3.getText().equals("O") || (button5.getText().equals("O") && button8.getText().equals("O")))) {
            selectButton(button2);
        } else if (button3.getText().equals("") && (button1.getText().equals("O") && button2.getText().equals("O") || (button5.getText().equals("O") && button7.getText().equals("O")) || (button6.getText().equals("O") && button9.getText().equals("O")))) {
            selectButton(button3);
        } else if (button4.getText().equals("") && (button1.getText().equals("O") && button7.getText().equals("O") || (button5.getText().equals("O") && button6.getText().equals("O")))) {
            selectButton(button4);
        } else if (button5.getText().equals("") && (button4.getText().equals("O") && button6.getText().equals("O") || (button2.getText().equals("O") && button8.getText().equals("O")) || (button1.getText().equals("O") && button9.getText().equals("O")) || (button3.getText().equals("O") && button7.getText().equals("O")))) {
            selectButton(button5);
        } else if (button6.getText().equals("") && (button4.getText().equals("O") && button5.getText().equals("O") || (button3.getText().equals("O") && button9.getText().equals("O")))) {
            selectButton(button6);
        } else if (button7.getText().equals("") && (button1.getText().equals("O") && button4.getText().equals("O") || (button5.getText().equals("O") && button3.getText().equals("O")) || (button8.getText().equals("O") && button9.getText().equals("O")))) {
            selectButton(button7);
        } else if (button8.getText().equals("") && (button2.getText().equals("O") && button5.getText().equals("O") || (button7.getText().equals("O") && button9.getText().equals("O")))) {
            selectButton(button8);
        } else if (button9.getText().equals("") && (button1.getText().equals("O") && button5.getText().equals("O") || (button3.getText().equals("O") && button6.getText().equals("O")) || (button7.getText().equals("O") && button8.getText().equals("O")))) {
            selectButton(button9);
        } /* */ else if (button1.getText().equals("") && (button2.getText().equals("X") && button3.getText().equals("X") || (button5.getText().equals("X") && button9.getText().equals("X")) || (button4.getText().equals("X") && button7.getText().equals("X")))) {
            selectButton(button1);
        } else if (button2.getText().equals("") && (button1.getText().equals("X") && button3.getText().equals("X") || (button5.getText().equals("X") && button8.getText().equals("X")))) {
            selectButton(button2);
        } else if (button3.getText().equals("") && (button1.getText().equals("X") && button2.getText().equals("X") || (button5.getText().equals("X") && button7.getText().equals("X")) || (button6.getText().equals("X") && button9.getText().equals("X")))) {
            selectButton(button3);
        } else if (button4.getText().equals("") && (button1.getText().equals("X") && button7.getText().equals("X") || (button5.getText().equals("X") && button6.getText().equals("X")))) {
            selectButton(button4);
        } else if (button5.getText().equals("") && (button4.getText().equals("X") && button6.getText().equals("X") || (button2.getText().equals("X") && button8.getText().equals("X")) || (button1.getText().equals("X") && button9.getText().equals("X")) || (button3.getText().equals("X") && button7.getText().equals("X")))) {
            selectButton(button5);
        } else if (button6.getText().equals("") && (button4.getText().equals("X") && button5.getText().equals("X") || (button3.getText().equals("X") && button9.getText().equals("X")))) {
            selectButton(button6);
        } else if (button7.getText().equals("") && (button1.getText().equals("X") && button4.getText().equals("X") || (button5.getText().equals("X") && button3.getText().equals("X")) || (button8.getText().equals("X") && button9.getText().equals("X")))) {
            selectButton(button7);
        } else if (button8.getText().equals("") && (button2.getText().equals("X") && button5.getText().equals("X") || (button7.getText().equals("X") && button9.getText().equals("X")))) {
            selectButton(button8);
        } else if (button9.getText().equals("") && (button1.getText().equals("X") && button5.getText().equals("X") || (button3.getText().equals("X") && button6.getText().equals("X")) || (button7.getText().equals("X") && button8.getText().equals("X")))) {
            selectButton(button9);
        } else {
            Random random = new Random();
            Button randomButton = buttons.get(random.nextInt(buttons.size()));
            while (randomButton.getText().equals("X")) {
                randomButton = buttons.get(random.nextInt(buttons.size()));
            }
            selectButton(randomButton);
        }
        if (isFinish()) {
            return;
        }
        if (turn == 9) {
            finishGame();
            gameLabel.setText("DRAW!");
        }
    }

    private void selectButton(Button button) {
        button.setText("O");
        button.setDisable(true);
        buttons.remove(button);
        turn++;
    }

    public boolean isFinish() {
        if (!button1.getText().equals("") && ((button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())) || (button1.getText().equals(button4.getText()) && button1.getText().equals(button7.getText())) || (button1.getText().equals(button5.getText()) && button1.getText().equals(button9.getText())))) {
            finish(button1.getText());
            return true;
        } else if (!button2.getText().equals("") && ((button2.getText().equals(button5.getText()) && button2.getText().equals(button8.getText())))) {
            finish(button2.getText());
            return true;
        } else if (!button3.getText().equals("") && ((button3.getText().equals(button5.getText()) && button3.getText().equals(button7.getText())) || (button3.getText().equals(button6.getText()) && button3.getText().equals(button9.getText())))) {
            finish(button3.getText());
            return true;
        } else if (!button4.getText().equals("") && (button4.getText().equals(button5.getText()) && button4.getText().equals(button6.getText()))) {
            finish(button4.getText());
            return true;
        } else if (!button7.getText().equals("") && (button7.getText().equals(button8.getText()) && button7.getText().equals(button9.getText()))) {
            finish(button7.getText());
            return true;
        }
        return false;
    }

    public void finish(String str) {
        if (str.equals("X")) {
            gameLabel.setText("YOU WIN THE GAME!");
        } else {
            gameLabel.setText("YOU LOSE :(");
        }
        finishGame();
    }

    public void finishGame() {
        for (Button button : buttons) {
            button.setDisable(true);
        }
        progressBar = null;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Music.getInstance().getMediaPlayer().isMute()) {
            sound.setText("Sound : off");
        } else {
            sound.setText("Sound : on");
        }
        buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        nameLabel.setText(User.getInstance().getUser() + " vs COMPUTER");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> increaseProgress()));
        timeline.setCycleCount(20);
        timeline.play();
    }

    public void increaseProgress() {
        progress += 0.05;
        if (progressBar != null) {
            progressBar.setProgress(progress);
        }
        if (progress >= 0.96) {
            gameLabel.setText("TIME FINISHED!");
            finishGame();
        }
    }
}