package org.zwergon.pwalletfx;

/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lecomtje
 */
public class InfosController implements Initializable, UIController {
    
    long id = -1;
    
    @FXML
    Label keyId;

    @FXML
    TextField loginId;

    @FXML
    TextField passwdId;

    @FXML
    TextField companyId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize");
    }

    @FXML
    private void processUpdate(ActionEvent event) {
    }
    
    @FXML
    private void processBack(ActionEvent event) {
        MainApp.getInstance().displayList();
    }
    
    @FXML
    private void processLogout(ActionEvent event) {
        MainApp.getInstance().userLogout();
    }

    public void setInfos(long id) {
        System.out.println("setInfo " + id );
        this.id = id;
        updateInfos();
    }
    
    public void updateInfos() {
        RegistrationInfoDto info = InfosService.getInfo(id);

        keyId.setText( "Id: " + Long.toString(id));
        loginId.setText(info.getLogin());
        passwdId.setText(info.getPasswd());
        companyId.setText(info.getCompany());
    }

}
