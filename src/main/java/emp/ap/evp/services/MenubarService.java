package emp.ap.evp.services;

import emp.ap.evp.parts.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class MenubarService {
    private final MenuItem open;
    private final Player player;
    private final Stage stage;
    private final FileChooser fileChooser;
    public MenubarService(Main main, Player player, Stage stage) {
        open = main.getController().getOpen();
        this.player = player;
        this.stage = stage;
        fileChooser = new FileChooser();
        init();
    }

    public void init(){
        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // Pausing the video while switching
                player.pause();
                File file = fileChooser.showOpenDialog(stage);
                // Choosing the file to play
                if (file != null) {
                    try {
                        player.changeContent(file.toURI().toURL().toExternalForm());
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
