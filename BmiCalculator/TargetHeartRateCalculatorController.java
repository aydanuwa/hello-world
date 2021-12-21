package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TargetHeartRateCalculatorController {

    private int age;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField maxTextField;

    @FXML
    private TextField rangeTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {

        try {
            double age = Double.parseDouble(ageTextField.getText());
            double maxHeartRate = (220 - age);
            double range1 = 0.5 * maxHeartRate;
            double range2 = 0.85 * maxHeartRate;

            maxTextField.setText(String.valueOf(maxHeartRate));
            rangeTextField.setText(String.valueOf(range1)+"-"+String.valueOf(range2));
        }
        catch (NumberFormatException e){
            ageTextField.setText("Enter your age:");
            ageTextField.selectAll();
            ageTextField.requestFocus();
        }

    }

}

