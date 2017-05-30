/*
 * Copyright (C) 2014-2017 by IFPEN
 * All rights reserved.
 * 
 * IFPEN Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */

package org.zwergon.pwalletfx;

/**
 * FXML Controller class
 *
 * @author lecomtje
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Login Controller.
 *
 * @author Tarun Tyagi
 */
public class LoginController implements Initializable, UIController {

    @FXML
    private TextField userId;
    
    @FXML
    private PasswordField password;
    @FXML
    private Label errorMessage;

    @FXML
    protected void processLogin() {
        if (!MainApp.getInstance().userLogging(userId.getText(), password.getText())) {
            errorMessage.setText("Username/password combination is invalid.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userId.setPromptText("demo");
        password.setPromptText("demo");
    }
}
