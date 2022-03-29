package emp.ap.evp.services;

import emp.ap.evp.parts.Main;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Player {
    private final BorderPane playArea;
    private final MediaView view;
    private MediaPlayer mediaPlayer;
    private final MediaBar bar;

    public Player(Main main) {
        playArea = main.getController().getPlayArea();
        bar = new MediaBar(main);
        view = new MediaView();
    }

    public void changeContent(String file) {
        Media media = new Media(file);
        mediaPlayer = new MediaPlayer(media);
        view.setMediaPlayer(mediaPlayer);
        Pane pane = new Pane(view);
        playArea.setCenter(pane);
        bar.changeContent(mediaPlayer);
        bar.init();
        mediaPlayer.play();
    }

    public void pause() {
        System.out.println(mediaPlayer.getTotalDuration());
        mediaPlayer.pause();
    }
}
