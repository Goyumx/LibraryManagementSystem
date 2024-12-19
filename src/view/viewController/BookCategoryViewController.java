package view.viewController;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controller.BookCategoryController;
import dto.BookCategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class BookCategoryViewController {

    private BookCategoryController bookCategoryController;

    public BookCategoryViewController() throws Exception{
        bookCategoryController = new BookCategoryController();
    }

    @FXML
    private TableColumn<BookCategoryDto, String> ColDesc;

    @FXML
    private TableColumn<BookCategoryDto, String> ColID;

    @FXML
    private TableColumn<BookCategoryDto, String> ColName;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReturn;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private AnchorPane sceneNow;

    @FXML
    private TableView<BookCategoryDto> tblCategry;

    @FXML
    private TextField txtCatgryID;

    @FXML
    private TextField txtCatgryName;

    @FXML
    private TextField txtDesc;

    @FXML
    void addCategory(ActionEvent event) {

    }

    @FXML
    void deleteCategory(ActionEvent event) {

    }

    @FXML
    void returnback(ActionEvent event) {

    }

    @FXML
    void searchCategory(ActionEvent event) {

    }

    @FXML
    void tblcategory(ActionEvent event) {

    }

    @FXML
    void updateCategory(ActionEvent event) {

    }

    @FXML
    private void initialize()throws Exception {
        
        ColID.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        ColDesc.setCellValueFactory(new PropertyValueFactory<>("categoryDesc"));
        loadTable();
    }

    private void loadTable() throws Exception{
        ArrayList<BookCategoryDto> bookCategoryDtos = bookCategoryController.getAll();

        ObservableList<BookCategoryDto> tabledata = FXCollections.observableArrayList(bookCategoryDtos);
        tblCategry.setItems(tabledata);
}
}
