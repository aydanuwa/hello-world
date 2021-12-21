package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BmiController {
    private double weight;
    private double height;

    @FXML
    private TextField bmiTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField infoTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    void englishButtonPressed(ActionEvent event) {
        try {
            weight = Double.parseDouble(weightTextField.getText());
            height = Double.parseDouble(heightTextField.getText());
            double engValue = (703*weight)/(height*height);

            if(engValue<18.5){
                infoTextField.setText("Underweight");
            }
            else if(engValue>=18.5 && engValue<= 24.9){
                infoTextField.setText("Normal");
            }
            else if(engValue>=25 && engValue <= 29.9){
                infoTextField.setText("Overweight");
            }
            else {
                infoTextField.setText("Obese");
            }
            bmiTextField.setText(String.valueOf(engValue));
        }catch (NumberFormatException ex) {
            weightTextField.setText("Enter weight: ");
            heightTextField.setText("Enter height: ");
            weightTextField.selectAll();
            weightTextField.requestFocus();

    }

    }

    @FXML
    void metricButtonPressed(ActionEvent event) {
        try {
            weight = Double.parseDouble(weightTextField.getText());
            height = Double.parseDouble(heightTextField.getText());

            double metricValue = (weight)/(height*height);

            if(metricValue<18.5){
                infoTextField.setText("Underweight");
            }
            else if(metricValue>=18.5 && metricValue<= 24.9){
                infoTextField.setText("Normal");
            }
            else if(metricValue>=25 && metricValue <= 29.9){
                infoTextField.setText("Overweight");
            }
            else {
                infoTextField.setText("Obese");
            }
            bmiTextField.setText(String.valueOf(metricValue));

        }
        catch (NumberFormatException ex){
            weightTextField.setText("Enter weight: ");
            heightTextField.setText("Enter height: ");
            weightTextField.selectAll();
            weightTextField.requestFocus();
        }
    }

}
