package com.example.javafx.TipCalculatorModification;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TipCalculatorModificationController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    BigDecimal amount = new BigDecimal(0);

    @FXML
    private Slider TipPercentageSlider;

    @FXML
    private Label amountLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private Label tipLabel;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private TextField tipTextField;

    @FXML
    private Label totalLabel;

    @FXML
    private TextField totalTextField;

    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);

        TipPercentageSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        tipPercentage = BigDecimal.valueOf(newValue.intValue()/100.0);
                        tipPercentageLabel.setText(percent.format(tipPercentage));
                        calculateAmount();
                    }
                }
        );

        amountTextField.textProperty().addListener((args, oldValue, newValue) ->{
            try{
                amount = new BigDecimal(newValue);
            }catch (Exception e){
                amountTextField.setText("Enter number");
            }
            calculateAmount();
        });
    }
    public void calculateAmount(){
        try {
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tip = amount.multiply((tipPercentage));
            BigDecimal total = amount.add(tip);

            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
        }catch (NumberFormatException ex){
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }
    }

}
