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
import javafx.scene.input.MouseEvent;

public class ListController implements Initializable, UIController {
    

    @FXML
    TableView<FXInfo> tableViewId;

    @FXML
    TableColumn<FXInfo, String> loginColumnId;

    @FXML
    TableColumn<FXInfo, String> pwColumnId;
    
     @FXML
    TableColumn<FXInfo, String> companyColumnId;


    private ObservableList<FXInfo> data;

    static public class FXInfo {

        RegistrationInfoDto info;

        SimpleStringProperty company;
        SimpleStringProperty login;
        SimpleStringProperty passwd;

        public FXInfo(RegistrationInfoDto info) {
            this.info = info;

            login = new SimpleStringProperty(info.getLogin());
            passwd = new SimpleStringProperty(info.getPasswd());
            company = new SimpleStringProperty(info.getCompany());
        }
        
        public Long getId(){
            return info.getId();
        }

        public String getLogin() {
            return login.get();
        }

        public String getPasswd() {
            return passwd.get();
        }
        
        public String getCompany(){
            return company.get();
        }

        public RegistrationInfoDto getInfo() {
            return info;
        }

    }
    
    @FXML
    private void processAdd(ActionEvent event) {
        MainApp.getInstance().infoAdd();
    }
    
    @FXML
    private void processLogout(ActionEvent event) {
        MainApp.getInstance().userLogout();
    }
    
    @FXML
    private void onMouseClickedAction( MouseEvent event ){
         if (event.getClickCount() > 1) {
            FXInfo info = tableViewId.getSelectionModel().getSelectedItem();
           
             MainApp.getInstance().infoEdit( info.getId() );
        }
    }

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loginColumnId.setCellValueFactory(new PropertyValueFactory("login"));
        pwColumnId.setCellValueFactory(new PropertyValueFactory("passwd"));
        companyColumnId.setCellValueFactory(new PropertyValueFactory("company"));
        
    }
    
    
    public void update(){
        
        data = FXCollections.observableArrayList();
        
         try {

            for (RegistrationInfoDto info : InfosService.getInfos() ) {
                data.add(new FXInfo(info));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        tableViewId.setItems(data);
        
    }
    
}
