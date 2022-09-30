package com.example.tictactoe;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Music {

    private MediaPlayer mediaPlayer;
    private final static Music INSTANCE = new Music();

    public Music() {
    }

    public static Music getInstance() {
        return INSTANCE;
    }

    public void setMediaPlayer() {
        mediaPlayer = new MediaPlayer(new Media(Paths.get("Crazy-Frog.mp3").toUri().toString()));
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
    }

    public static void stop() {
        INSTANCE.mediaPlayer.pause();
    }

    public static void play() {
        INSTANCE.mediaPlayer.play();
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
