package emp.ap.evp.services;

import emp.ap.evp.parts.Main;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;

public class MediaBar {
    private final Slider timeSlider;
    private final Slider volumeSlider;
    private final Button PlayButton;
    private MediaPlayer video;
    private double volumeRate;

    /**
     * constructor will give some objects.
     *
     * @param main  main page.
     */
    public MediaBar(Main main) {
        this.timeSlider = main.getController().getTime();
        this.volumeSlider = main.getController().getVolume();
        this.PlayButton = main.getController().getPlayButton();
        volumeRate = 100;
        volumeSlider.setValue(volumeRate);
        updatesValues();
    }

    /**
     * this method control play/pause button, time slider, volume slider.
     */
    public void init() {
        // play or pause video
        PlayButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                MediaPlayer.Status status = video.getStatus(); // To get the status of Player
                if (status == MediaPlayer.Status.PLAYING) {
                    if (video.getCurrentTime().greaterThanOrEqualTo(video.getTotalDuration())) {
                        video.seek(video.getStartTime());
                        video.play();
                    } else {
                        video.pause();
                        PlayButton.setText(">");
                    }
                }
                if (status == MediaPlayer.Status.HALTED || status == MediaPlayer.Status.STOPPED || status == MediaPlayer.Status.PAUSED) {
                    video.play();
                    PlayButton.setText("||");
                }
            }
        });

        video.currentTimeProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                updatesValues();
            }
        });
        // changing the seek of video by pressing on time slider
        timeSlider.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (timeSlider.isPressed()) {
                    video.seek(video.getMedia().getDuration().multiply(timeSlider.getValue() / 100));
                }
            }
        });
        // changing volume by pressing slider
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (volumeSlider.isPressed()) {
                    video.setVolume(volumeSlider.getValue() / 100);
                    volumeRate = volumeSlider.getValue();
                }
            }
        });
    }

    /**
     * update the time slider value.
     */
    protected void updatesValues() {
        Platform.runLater(new Runnable() {
            public void run() {
                // Updating to the new time value
                // This will move the slider while running your video
                timeSlider.setValue(video.getCurrentTime().toMillis() /
                        video.getTotalDuration()
                                .toMillis()
                        * 100);
            }
        });
    }

    public void changeContent(MediaPlayer mediaPlayer){
        this.video = mediaPlayer;
        video.setVolume(volumeRate / 100);
        System.out.println(video.getVolume());
    }
}
