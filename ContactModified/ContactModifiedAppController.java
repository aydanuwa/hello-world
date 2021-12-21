package com.example.javafx.ContactModified;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContactModifiedAppController {

    @FXML
    private Button addButton;

    @FXML
    private ImageView contactImageView;

    @FXML
    private ListView<ContactModified> contactListView;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField firstTextField;

    @FXML
    private TextField lastTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private Button updateButton;

    private final ObservableList<ContactModified> contacts =
            FXCollections.observableArrayList();
    private ContactModified contactSelected;

    public void initialize(){
        contacts.add(new ContactModified("Aydana", "Kubatova", "aydana@gmail.com", "0707707707", "/imageContact/img_1.png"));
        contacts.add(new ContactModified("Alina", "Erkulova", "alina@gmail.com", "0700700700", "/imageContact/img_2.png"));
        contacts.add(new ContactModified("Diana", "Orozek", "diana@gmail.com", "0550550550", "/imageContact/img_3.png"));
        contacts.add(new ContactModified("Kanyshai", "Tolomusheva", "kanish@gmail.com", "0990990990", "/imageContact/img_4.png"));
        contactListView.setItems(contacts);

        contactListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<ContactModified>() {
                    @Override
                    public void changed(ObservableValue<? extends ContactModified> observable, ContactModified oldValue, ContactModified newValue) {
                        contactSelected = newValue;
                        firstTextField.setText(newValue.getFirstName());
                        lastTextField.setText(newValue.getLastName());
                        emailTextField.setText(newValue.getEmail());
                        numberTextField.setText(newValue.getPhoNumber());
                        contactImageView.setImage(new Image(newValue.getImage()));
                    }
                }
        );
    }

    public boolean validationFailed(){
        return (firstTextField.getText().trim().equals("")||
                lastTextField.getText().trim().equals("")||
                emailTextField.getText().trim().equals("")||
                numberTextField.getText().trim().equals("")
        );
    }



    @FXML
    void addButtonPressed(ActionEvent event) {
        try {
            if (validationFailed()){
                throw new NumberFormatException();
            }
            else {
                ContactModified objNew = new ContactModified();
                objNew.setImage("/imageContact/img_5.png");
                objNew.setFirstName(firstTextField.getText());
                objNew.setLastName(lastTextField.getText());
                objNew.setEmail(emailTextField.getText());
                objNew.setPhoNumber(numberTextField.getText());
                contacts.add(objNew);

            }
        }catch (Exception e){
            firstTextField.setText("");
            lastTextField.setText("");
            emailTextField.setText("");
            numberTextField.setText("");
            firstTextField.requestFocus();
        }

    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {
        try {
            contacts.remove(contactSelected);
        }catch (Exception e){
            firstTextField.setText("");
            lastTextField.setText("");
            emailTextField.setText("");
            numberTextField.setText("");
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
                ContactModified obj1 = new ContactModified();
                contactSelected.setFirstName(firstTextField.getText());
                contactSelected.setLastName(lastTextField.getText());
                contactSelected.setEmail(emailTextField.getText());
                contactSelected.setPhoNumber(numberTextField.getText());
            }
        }catch (Exception e){
            firstTextField.setText("");
            lastTextField.setText("");
            emailTextField.setText("");
            numberTextField.setText("");
            firstTextField.requestFocus();
        }

    }

}

