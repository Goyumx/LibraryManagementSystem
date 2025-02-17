import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("./view/LoginView.fxml");// fxml file resource
        Parent root = FXMLLoader.load(resource);// load the resource
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setTitle("");
    }

}
    
