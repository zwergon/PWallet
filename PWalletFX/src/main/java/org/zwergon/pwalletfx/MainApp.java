package org.zwergon.pwalletfx;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private enum Window {
        LOGIN("/fxml/login.fxml"),
        LIST("/fxml/list.fxml"),
        INFOS("/fxml/infos.fxml");

        Window(String fxml) {
            this.fxml = fxml;
        }

        public String getFXML() {
            return fxml;
        }

        private String fxml;
        
        public UIController controller;
        
        public Parent page;
    }

    private static MainApp instance;

    private Stage stage;
    private User loggedUser;

    public MainApp() {
        instance = this;
    }

    public static MainApp getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            gotoWindow(Window.LOGIN);
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public boolean userLogging(String userId, String password) {
        if (Authenticator.validate(userId, password)) {
            loggedUser = User.of(userId);
            displayList();
            return true;
        } else {
            return false;
        }
    }

    public void userLogout() {
        loggedUser = null;
        gotoWindow(Window.LOGIN);
    }

    public void displayList(){
         if (loggedUser != null) {
            gotoWindow(Window.LIST);
        }
    }
    
    public void infoAdd() {
        if (loggedUser != null) {
            gotoWindow(Window.INFOS);
        }
    }

    public void infoEdit(long id) {
        if (loggedUser != null) {  
            gotoWindow(Window.INFOS);
            InfosController controller = (InfosController)Window.INFOS.controller;
            controller.setInfos(id);
        }
    }

    

    private void gotoWindow(Window window) {
        try {
            replaceSceneContent(window);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void replaceSceneContent(Window window) throws Exception {
        
        if ( window.controller == null ){
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(window.getFXML()));
            window.page = loader.load();
            window.controller = loader.getController();   
        }
        
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(window.page, 700, 550);
            //scene.getStylesheets().add(MainApp.class.getResource("demo.css").toExternalForm       
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(window.page);
        }
        stage.sizeToScene();
       
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
