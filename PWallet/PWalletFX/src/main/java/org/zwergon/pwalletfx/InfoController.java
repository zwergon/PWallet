package org.zwergon.pwalletfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lecomtje
 */
public class InfoController implements Initializable, UIController {

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
    }

    @FXML
    private void processUpdate(ActionEvent event) {

        RegistrationInfoDto info = new RegistrationInfoDto();
        if (id != -1) {
            info.setId(id);
        }
        info.setCompany(companyId.getText());
        info.setLogin(loginId.getText());
        info.setPasswd(AESencrp.encrypt(passwdId.getText()));
        InfoService.update(info);

        MainApp.getInstance().displayList();

    }

    @FXML
    private void processBack(ActionEvent event) {
        MainApp.getInstance().displayList();
    }

    @FXML
    private void processLogout(ActionEvent event) {
        MainApp.getInstance().userLogout();
    }

    @FXML
    private void processDelete(ActionEvent event) {

        if (id == -1) {
            return;
        }

        Alert alert = new Alert(AlertType.CONFIRMATION, "Delete ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            InfoService.delete(id);
            MainApp.getInstance().displayList();
        }

    }

    public void setInfos(long id) {
        this.id = id;
        updateInfos();
    }

    public void updateInfos() {

        if (id == -1) {
            keyId.setText("Id:");
            loginId.setText("");
            passwdId.setText("");
            companyId.setText("");
        } else {
            RegistrationInfoDto info = InfoService.getInfo(id);

            keyId.setText("Id: " + Long.toString(id));
            loginId.setText(info.getLogin());
            passwdId.setText(AESencrp.decrypt(info.getPasswd()));
            companyId.setText(info.getCompany());
        }
    }

}
