package emp.ap.evp.parts;

import emp.ap.evp.parts.controllers.MainController;
import emp.ap.evp.services.MenubarService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Main {
    private Parent root;
    private MainController controller;


    public Main() {
        init();
    }

    public void init() {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("main.fxml"));
            root = fxml.load();
            controller = fxml.getController();
            controller.init(this);
        } catch (IOException ioe) {
            System.out.println("Error in loading fxml in main window: "+ioe.toString());
        }
    }

    public Parent getRoot() {
        return root;
    }

    public void exit() {

    }

    public void changeFile() {

    }

    public MainController getController() {
        return controller;
    }


}
