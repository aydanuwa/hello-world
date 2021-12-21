package com.example.javafx.ContactApp;

import com.example.javafx.ContactApp.Contact;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactController{

    @FXML
    private ListView<Contact> contactListView;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField firstTextField;

    @FXML
    private TextField lastTextField;

    @FXML
    private TextField phoneTextField;

    private final ObservableList<Contact> contacts =
            FXCollections.observableArrayList();
    private Contact contactSelected;

    public void initialize(){
        contacts.add(new Contact("Aydana", "Kubatova", "aydana@gmail.com", "0707707707"));
        contacts.add(new Contact("Alina", "Erkulova", "alina@gmail.com", "0700700700"));
        contacts.add(new Contact("Diana", "Orozek", "diana@gmail.com", "0550550550"));
        contacts.add(new Contact("Kanyshai", "Tolomusheva", "kanish@gmail.com", "0990990990"));
        contactListView.setItems(contacts);

        contactListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Contact>() {
                    @Override
                    public void changed(ObservableValue<? extends Contact> observable, Contact oldValue, Contact newValue) {
                        contactSelected = newValue;
                        firstTextField.setText(newValue.getFirstName());
                        lastTextField.setText(newValue.getLastName());
                        emailTextField.setText(newValue.getEmail());
                        phoneTextField.setText(newValue.getPhoneNumber());
                    }
                }
        );
    }

    public boolean validationFailed(){
        return (firstTextField.getText().trim().equals("")||
                lastTextField.getText().trim().equals("")||
                emailTextField.getText().trim().equals("")||
                phoneTextField.getText().trim().equals("")
        );
    }
    @FXML
    void addButtonPressed(ActionEvent event) {
        try {
            if(validationFailed()){
                throw new NumberFormatException();
            }
            else {
                Contact objNew = new Contact();
                objNew.setFirstName(firstTextField.getText());
                objNew.setLastName(lastTextField.getText());
                objNew.setEmail(emailTextField.getText());
                objNew.setPhoneNumber(phoneTextField.getText());
                contacts.add(objNew);
            }
        } catch (Exception e) {
            firstTextField.setText("");
            lastTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            firstTextField.requestFocus();
        }

    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {
        try {
            contacts.remove(contactSelected);
        } catch (Exception e) {
            firstTextField.setText("");
            lastTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            firstTextField.requestFocus();
        }

    }

    @FXML
    void updateButtonPressed(ActionEvent event) {
        try {
            if(validationFailed()){
                throw new NumberFormatException();
            }
            else {
                Contact objNew = new Contact();
                contactSelected.setFirstName(firstTextField.getText());
                contactSelected.setLastName(lastTextField.getText());
                contactSelected.setEmail(emailTextField.getText());
                contactSelected.setPhoneNumber(phoneTextField.getText());
                firstTextField.requestFocus();
            }
        } catch (NumberFormatException e) {
            firstTextField.setText("");
            lastTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            firstTextField.requestFocus();
        }

    }




}

