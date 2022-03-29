package emp.ap.evp.MainSystem;

import emp.ap.evp.parts.Main;
import emp.ap.evp.services.MenubarService;
import emp.ap.evp.services.Player;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class PlayerSystem {
    private final Stage stage;
    private final Player player;

    public PlayerSystem(Main main, Stage stage) {
        this.stage = stage;
        player = new Player(main);
        MenubarService menubar = new MenubarService(main, player, stage);
        init();
    }

    public void init() {
        FileChooser fileChooser = new FileChooser();
        try {
            File file1 = fileChooser.showOpenDialog(stage);
            if (file1 == null)
                System.out.println("file is not available!!!");
            else {
                player.changeContent(file1.toURI().toURL().toExternalForm());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("address is not detected!!!");
            e.printStackTrace();
            stage.close();
            System.exit(0);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
