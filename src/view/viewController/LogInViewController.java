package view.viewController;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogInViewController {

    Stage stage;

    @FXML 
    AnchorPane LogScene;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void authUser(ActionEvent event) throws IOException{
        String RealUsername = "Librarian";
        String RealPassword ="Reading123";

        String Username = txtUsername.getText();
        String Password = txtPassword.getText();

        boolean verified = (RealUsername.equals(Username) && RealPassword.equals(Password) );

        if(verified){
            
        stage=(Stage)LogScene.getScene().getWindow();
        stage.close();
            
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/MainInterface.fxml"));
        Stage stagex = new Stage();
        stagex.setScene(new Scene(root));
        stagex.show();
        stagex.setTitle("");
        

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Worng Username or password");
            alert.show();
            txtUsername.setText("");
            txtPassword.setText("");
        }
    }

    @FXML
    void closeApp(ActionEvent event) {
        stage=(Stage)LogScene.getScene().getWindow();
        stage.close();
    }

}
