package org.zwergon.pwalletfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class FXMLController implements Initializable {

    @FXML
    TableView<FXInfo> tableViewId;

    @FXML
    TableColumn<FXInfo, String> loginColumnId;

    @FXML
    TableColumn<FXInfo, String> pwColumnId;

    private final ObservableList<FXInfo> data = FXCollections.observableArrayList();

    static public class FXInfo {

        RegistrationInfoDto info;

        SimpleStringProperty company;
        SimpleStringProperty login;
        SimpleStringProperty passwd;

        public FXInfo(RegistrationInfoDto info) {
            this.info = info;

            login = new SimpleStringProperty(info.getLogin());
            passwd = new SimpleStringProperty(info.getPasswd());
        }

        public String getLogin() {
            return login.get();
        }

        public String getPasswd() {
            return passwd.get();
        }

        public RegistrationInfoDto getInfo() {
            return info;
        }

    }

    @FXML
    private void onResetPropertyAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loginColumnId.setCellValueFactory(new PropertyValueFactory("login"));
        pwColumnId.setCellValueFactory(new PropertyValueFactory("passwd"));

        String urlGetAll = "http://localhost:8080/PWallet/infos";

        HttpHeaders headers = new HttpHeaders();

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<RegistrationInfoDto[]> entities = new HttpEntity<RegistrationInfoDto[]>(headers);

        try {

            ResponseEntity<RegistrationInfoDto[]> result = restTemplate.exchange(urlGetAll, HttpMethod.GET, entities, RegistrationInfoDto[].class);

            RegistrationInfoDto[] infos = result.getBody();

            for (RegistrationInfoDto info : infos) {
                data.add(new FXInfo(info));
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        tableViewId.setItems(data);

    }
    
}
