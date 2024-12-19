package view.viewController;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controller.BookCategoryController;
import dto.BookCategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BookCategoryViewController {
    Stage stage;

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
        saveCategory();
    }

    @FXML
    void deleteCategory(ActionEvent event) {
        deleteCategory();
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
    void searchCategory(ActionEvent event) {
        searchCategory();
    }

    @FXML
    void tblcategory(ActionEvent event) {

    }

    @FXML
    void updateCategory(ActionEvent event) {
        updateCategory();
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
    
    private void clearForm(){
        txtCatgryID.clear();
        txtDesc.clear();
        txtCatgryName.clear();
    }
    
    private void saveCategory(){

        try {
            BookCategoryDto bookCategoryDto = new BookCategoryDto(txtCatgryName.getText(), txtCatgryID.getText(), txtDesc.getText());
            String resp =bookCategoryController.save(bookCategoryDto);

            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();
            
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Saving").show();           
        }
    }

    private void deleteCategory(){

        try {
            String categoryID = txtCatgryID.getText();
            String resp =bookCategoryController.delete(categoryID);

            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();
            
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in deleting").show();
        }
    }

    private void searchCategory(){

        try {
            String categoryID = txtCatgryID.getText();
            BookCategoryDto searchedCategoryDto =bookCategoryController.get(categoryID);
            txtCatgryName.setText(searchedCategoryDto.getCategoryName());
            txtDesc.setText(searchedCategoryDto.getCategoryDesc());
                       
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in searching").show();
        }
    }
    private void updateCategory(){

        try {
            BookCategoryDto updatedcCategoryDto = new BookCategoryDto(txtCatgryName.getText(),txtCatgryID.getText(), txtDesc.getText());
            String resp =bookCategoryController.update(updatedcCategoryDto);

            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();
            
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in deleting").show();
        }
    }
}
