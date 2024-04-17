package c.finalweatherproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;


public class SecondaryController {
    @FXML
    private Button OkButton;

    @FXML
    private Button applyButton;

    @FXML
    private CheckBox celsiusCheck;

    @FXML
    private Button closeButton;

    @FXML
    private CheckBox fahrenheitCheck;
    
    @FXML
    private void applyPressed() {}
    
    @FXML
    private void OKPressed() {}
    
    @FXML
    private void closePressed() {}
    
    @FXML 
    void fahrenheitClicked() {
        if (celsiusCheck.isSelected()) {
            celsiusCheck.setSelected(false);
        }
    }
    
    @FXML 
    void celsiusClicked() {
        if (fahrenheitCheck.isSelected()) {
            fahrenheitCheck.setSelected(false);
        }
    }
}