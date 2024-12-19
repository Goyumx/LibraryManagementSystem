package view.viewController;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controller.BookController;
import dto.BookDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BookViewController {

    Stage stage;
    private BookController bookController;

    public BookViewController() throws Exception{
        bookController = new BookController();
    }

    @FXML
    private TableColumn<BookDto , String> ColDesc;

    @FXML
    private TableColumn<BookDto , String> ColState;

    @FXML
    private TableColumn<BookDto , String> ColTitle;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<BookDto , String> colID;

    @FXML
    private AnchorPane sceneNow;

    @FXML
    private TableView<BookDto > tblBook;

    @FXML
    private TableColumn<BookDto , String> tbleCatgryID;

    @FXML
    private TextField txtCatgryID;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtId;

    @FXML
    private ComboBox<String> txtState;

    @FXML
    private TextField txtTitle;

    @FXML
    void AddBook(ActionEvent event) {
        saveBook();
    }

    @FXML
    void deletebook(ActionEvent event) {
        deleteBook();
    }

    @FXML
    void returnback(ActionEvent event) throws IOException{
        stage=(Stage)sceneNow.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/MainInterface.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("");
    }
    @FXML
    void searchbook(ActionEvent event) {
        searchBook();
    }

    @FXML
    void updatebook(ActionEvent event) {
        updateBook();
    }

    @FXML
    private void initialize()throws Exception {
        txtState.setItems(FXCollections.observableArrayList("Available" , "Unavailable"));
        //.getvalue
        colID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        ColTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        tbleCatgryID.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        ColState.setCellValueFactory(new PropertyValueFactory<>("states"));
        ColDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        loadTable();
    }

    private void loadTable() throws Exception{

        ArrayList<BookDto> books = bookController.getAll();
        ObservableList<BookDto> tblData = FXCollections.observableArrayList(books);
        tblBook.setItems(tblData);

    }  
    
    private void clearForm(){
        txtCatgryID.clear();
        txtDesc.clear();
        txtId.clear();
        txtTitle.clear();
        txtState.setValue(null);
    }

    private void saveBook(){

        try {

            BookDto bookDto = new BookDto(txtId.getText(), txtTitle.getText(), txtCatgryID.getText(), txtDesc.getText(), txtState.getValue());
            String resp =bookController.save(bookDto);
            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Saving").show();
        }

    }

    private void deleteBook(){

        try {

            String bookID = txtId.getText();
            String resp =bookController.delete(bookID);
            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Deleting").show();
        }

    }

    private void searchBook(){

        try {

            String bookID = txtId.getText();
            BookDto searchedBook = bookController.get(bookID);
            txtCatgryID.setText(searchedBook.getCategoryId());
            txtDesc.setText(searchedBook.getDescription());
            txtTitle.setText(searchedBook.getBookTitle());
            txtState.setValue(searchedBook.getStates());

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in searching").show();
        }

    }
    private void updateBook(){

        try {

            BookDto updatedbook = new BookDto(txtId.getText(), txtTitle.getText(), txtCatgryID.getText(),txtDesc.getText(), txtState.getValue());
            String resp = bookController.update(updatedbook);
            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in updating").show();
        }

    }

}
