package view.viewController;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainInterfaceController {

    Stage stage;

    @FXML 
    AnchorPane scenePane;

    @FXML
    private JFXButton btnBookCategory;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnManageBook;

    @FXML
    private JFXButton btnManageMember;

    @FXML
    private JFXButton btnProcess;

    @FXML
    void BookCategory(ActionEvent event)throws IOException {
        stage=(Stage)scenePane.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/BookCategoryView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("");
    }

    @FXML
    void LogOut(ActionEvent event)throws IOException {

        stage=(Stage)scenePane.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/LoginView.fxml"));
        Stage stagex = new Stage();
        stagex.setScene(new Scene(root));
        stagex.show();
        stagex.setTitle("");

    }

    @FXML
    void ManageBooks(ActionEvent event) throws IOException{

        stage=(Stage)scenePane.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/BookView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("");
    }

    @FXML
    void ManageMember(ActionEvent event)throws IOException {
        stage=(Stage)scenePane.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/MemberView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("");
    }

    @FXML
    void Process(ActionEvent event) throws IOException {
        stage=(Stage)scenePane.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/BookProcessView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("");
    }

}
