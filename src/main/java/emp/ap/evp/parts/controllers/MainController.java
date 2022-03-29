package emp.ap.evp.parts.controllers;

import emp.ap.evp.parts.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController {
    @FXML
    private Button playButton;
    @FXML
    private MenuItem open;
    @FXML
    private BorderPane playArea;
    @FXML
    private Slider time;
    @FXML
    private Slider volume;

    private Main main;

    public void init(Main main) {
        this.main = main;
    }

    public void exit() {
        main.exit();
    }

    public BorderPane getPlayArea() {
        return playArea;
    }

    public Slider getTime() {
        return time;
    }

    public Slider getVolume() {
        return volume;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public MenuItem getOpen() {
        return open;
    }
}
