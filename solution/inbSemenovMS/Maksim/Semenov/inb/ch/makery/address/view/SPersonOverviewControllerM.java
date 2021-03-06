﻿package Maksim.Semenov.inb.ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import org.controlsfx.dialog.Dialogs;

import Maksim.Semenov.inb.ch.makery.address.SMainAppM;
import Maksim.Semenov.inb.ch.makery.address.model.SPersonM;
import Maksim.Semenov.inb.ch.makery.address.util.SDateUtilM;

@SuppressWarnings("deprecation")
public class SPersonOverviewControllerM {
    @FXML
    private TableView<SPersonM> personTable;
    @FXML
    private TableColumn<SPersonM, String> firstNameColumn;
    @FXML
    private TableColumn<SPersonM, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    private SMainAppM smainAppm;

    public SPersonOverviewControllerM() {
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(
        		cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
        		cellData -> cellData.getValue().lastNameProperty());
        
        sshowPersonDetailsM(null);

        // Listen for selection changes and show the person details when changed.
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> sshowPersonDetailsM(newValue));
    }

    public void setMainApp(SMainAppM mainApp) {
        this.smainAppm = mainApp;

        personTable.setItems(mainApp.getPersonData());
    }
    
    private void sshowPersonDetailsM(SPersonM person) {
    	if (person != null) {
    		firstNameLabel.setText(person.getFirstName());
    		lastNameLabel.setText(person.getLastName());
    		streetLabel.setText(person.getStreet());
    		postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
    		cityLabel.setText(person.getCity());
    		birthdayLabel.setText(SDateUtilM.sformatM(person.getBirthday()));
    	} else {
    		firstNameLabel.setText("");
    		lastNameLabel.setText("");
    		streetLabel.setText("");
    		postalCodeLabel.setText("");
    		cityLabel.setText("");
    		birthdayLabel.setText("");
    	}
    }

	@FXML
	private void shandleDeletePersonM() {
		int sselectedIndexm = personTable.getSelectionModel().getSelectedIndex();
		if (sselectedIndexm >= 0) {
			personTable.getItems().remove(sselectedIndexm);
		} else {
			Dialogs.create()
		        .title("No Selection")
		        .masthead("No Person Selected")
		        .message("Please select a person in the table.")
		        .showWarning();
		}
	}
	
	@FXML
	private void shandleNewPersonM() {
		SPersonM tempPerson = new SPersonM();
		boolean okClicked = smainAppm.showPersonEditDialog(tempPerson);
		if (okClicked) {
			smainAppm.getPersonData().add(tempPerson);
		}
	}

	@FXML
	private void shandleEditPersonM() {
		SPersonM selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = smainAppm.showPersonEditDialog(selectedPerson);
			if (okClicked) {
				sshowPersonDetailsM(selectedPerson);
			}

		} else {
			// Nothing selected.
			Dialogs.create()
				.title("No Selection")
				.masthead("No Person Selected")
				.message("Please select a person in the table.")
				.showWarning();
		}
	}
}