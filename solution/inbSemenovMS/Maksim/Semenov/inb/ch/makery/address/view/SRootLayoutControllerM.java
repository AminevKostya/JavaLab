﻿package Maksim.Semenov.inb.ch.makery.address.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;

import Maksim.Semenov.inb.ch.makery.address.SMainAppM;

@SuppressWarnings("deprecation")
public class SRootLayoutControllerM {

    private SMainAppM smainAppm;

    public void setMainApp(SMainAppM mainApp) {
        this.smainAppm = mainApp;
    }

    @FXML
    private void shandleNewM() {
        smainAppm.getPersonData().clear();
        smainAppm.ssetPersonFilePathM(null);
    }

    @FXML
    private void shandleOpenM() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(smainAppm.sgetPrimaryStagem());

        if (file != null) {
            smainAppm.sloadPersonDataFromFileM(file);
        }
    }

    @FXML
    private void shandleSaveM() {
        File personFile = smainAppm.sgetPersonFilePathM();
        if (personFile != null) {
            smainAppm.savePersonDataToFile(personFile);
        } else {
            shandleSaveAsM();
        }
    }

    @FXML
    private void shandleSaveAsM() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(smainAppm.sgetPrimaryStagem());

        if (file != null) {
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            smainAppm.savePersonDataToFile(file);
        }
    }

    @FXML
    private void shandleAboutM() {
        Dialogs.create()
            .title("AddressApp")
            .masthead("About")
            .message("Author: Marco Jakob\nWebsite: http://code.makery.ch")
            .showInformation();
    }

    @FXML
    private void shandleExitM() {
        System.exit(0);
    }
    @FXML
    private void shandleShowBirthdayStatisticsM() {
      smainAppm.sshowBirthdayStatisticsM();
    }
}