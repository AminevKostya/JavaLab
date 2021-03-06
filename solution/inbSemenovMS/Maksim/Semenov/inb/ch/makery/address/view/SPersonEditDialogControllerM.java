﻿package Maksim.Semenov.inb.ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import Maksim.Semenov.inb.ch.makery.address.model.SPersonM;
import Maksim.Semenov.inb.ch.makery.address.util.SDateUtilM;

@SuppressWarnings("deprecation")
public class SPersonEditDialogControllerM {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField birthdayField;


    private Stage sdialogStagem;
    private SPersonM spersonm;
    private boolean sokClickedm = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.sdialogStagem = dialogStage;
    }

    public void setPerson(SPersonM person) {
        this.spersonm = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        postalCodeField.setText(Integer.toString(person.getPostalCode()));
        cityField.setText(person.getCity());
        birthdayField.setText(SDateUtilM.sformatM(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }

    public boolean isOkClicked() {
        return sokClickedm;
    }

    @FXML
    private void handleOk() {
        if (sisInputValidM()) {
            spersonm.setFirstName(firstNameField.getText());
            spersonm.setLastName(lastNameField.getText());
            spersonm.setStreet(streetField.getText());
            spersonm.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            spersonm.setCity(cityField.getText());
            spersonm.setBirthday(SDateUtilM.sparseM(birthdayField.getText()));

            sokClickedm = true;
            sdialogStagem.close();
        }
    }

    @FXML
    private void handleCancel() {
        sdialogStagem.close();
    }

    private boolean sisInputValidM() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!SDateUtilM.svalidDateM(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
        	Dialogs.create()
		        .title("Invalid Fields")
		        .masthead("Please correct invalid fields")
		        .message(errorMessage)
		        .showError();
            return false;
        }
    }
}