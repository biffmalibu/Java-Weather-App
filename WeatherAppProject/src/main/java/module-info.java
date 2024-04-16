module c.finalweatherproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires javafx.base;
    requires javafx.graphics;

    opens c.finalweatherproject to javafx.fxml;
    exports c.finalweatherproject;
}
