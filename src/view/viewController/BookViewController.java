package view.viewController;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controller.BookController;
import dto.BookDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class BookViewController {

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

    }

    @FXML
    void deletebook(ActionEvent event) {

    }

    @FXML
    void returnback(ActionEvent event) {

    }

    @FXML
    void searchbook(ActionEvent event) {

    }

    @FXML
    void updatebook(ActionEvent event) {

    }

    @FXML
    private void initialize()throws Exception {
        
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

}
