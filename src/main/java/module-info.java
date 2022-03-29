module emp.ap.videoplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens emp.ap.evp to javafx.fxml;
    exports emp.ap.evp;
    opens emp.ap.evp.parts to javafx.fxml;
    exports emp.ap.evp.parts;
    opens emp.ap.evp.parts.controllers to javafx.fxml;
    exports emp.ap.evp.parts.controllers;
}