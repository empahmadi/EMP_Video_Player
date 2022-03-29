package emp.ap.evp;

import emp.ap.evp.MainSystem.PlayerSystem;
import emp.ap.evp.parts.Main;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EMPVideoPlayer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Main main = new Main();
        Parent root = main.getRoot();
        if (root == null) {
            System.out.println("root is null");
            System.exit(10);
        } else {
            Scene scene = new Scene(main.getRoot());
            stage.setScene(scene);
            stage.show();
            PlayerSystem player = new PlayerSystem(main, stage);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
