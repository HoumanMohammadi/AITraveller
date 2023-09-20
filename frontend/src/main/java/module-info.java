module de.iav.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens de.iav.frontend to javafx.fxml;
    exports de.iav.frontend;
}