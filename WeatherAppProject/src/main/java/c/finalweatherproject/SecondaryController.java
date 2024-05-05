package c.finalweatherproject;

import static c.finalweatherproject.MainWinController.save;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;


public class SecondaryController {
    @FXML
    private Button OkButton;

    @FXML
    private Button applyButton;

    @FXML
    private CheckBox cCheck;

    @FXML
    private Button cancelButton;

    @FXML
    private CheckBox fCheck;

    @FXML
    private CheckBox kmCheck;

    @FXML
    private CheckBox miCheck;

    @FXML
    void initialize() {
        if (save.getDegreeUnits().equals("F")) {
            fCheck.setSelected(true);
        } else {
            cCheck.setSelected(true);
        }

        if (save.getDistance().equals("MI")) {
            miCheck.setSelected(true);
        } else {
            kmCheck.setSelected(true);
        }
    }

    @FXML
    void fClicked(ActionEvent event) {
        if (cCheck.isSelected()) {
            cCheck.setSelected(false);
        }
        save.setDegreeUnits("F");
        SaveState.updateFile();
    }

    @FXML
    void cClicked() {
        if (fCheck.isSelected()) {
            fCheck.setSelected(false);
        }
    }
}
