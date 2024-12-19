package view.viewController;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controller.BookController;
import controller.BookProcessController;
import dto.BookBorrowDetailDto;
import dto.BookBorrowDto;
import dto.BookDto;
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

public class BookProcessViewController {

    Stage stage;

    private BookProcessController bookProcessController;
    private BookController bookController;
    ArrayList<BookBorrowDetailDto> books;

    public BookProcessViewController(){
        bookProcessController = new BookProcessController();
        bookController = new BookController();
        books = new ArrayList<>();
    }


    @FXML
    private TableColumn<BookBorrowDetailDto, String> ColBookList;

    @FXML
    private TextField Fines;

    @FXML
    private JFXButton addBook;

    @FXML
    private TextField borrowedDate;

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private JFXButton btnReturnBook;

    @FXML
    private JFXButton btnreturn;

    @FXML
    private JFXButton checkdate;

    @FXML
    private TextField memberId;

    @FXML
    private TextField returnBorrowId;

    @FXML
    private AnchorPane sceneNow;

    @FXML
    private TableView<BookBorrowDetailDto> tblList;

    @FXML
    private TextField txtBoodID;

    @FXML
    private TextField txtBorrowId;

    @FXML
    private TextField txtDueDate;

    @FXML
    private TextField txtMemberID;

    @FXML
    void addToList(ActionEvent event) {
        addtoTableList();
    }

    @FXML
    void borrowtheBook(ActionEvent event) {
        bookBorrowed();
    }

    @FXML
    void checkborrow(ActionEvent event) {
        searchDate();
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
    void returnbook(ActionEvent event) {
        returnbookwithFines();
    }
    @FXML
    private void initialize()throws Exception {
  
        ColBookList.setCellValueFactory(new PropertyValueFactory<>("bookId"));

    }
    

    private void searchDate() {
        try {
            String boorowId= returnBorrowId.getText();
            BookBorrowDto bookBorrowDto = bookProcessController.checkDate(boorowId);
            borrowedDate.setText(bookBorrowDto.getBorrowDate());
            memberId.setText(bookBorrowDto.getMemberId());
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in searching").show();
        }
        
    }

    private void returnbookwithFines(){
        try {
            String boorowId= returnBorrowId.getText();
            String resp = bookProcessController.returnBook(boorowId, Double.parseDouble(Fines.getText()));
            new Alert(Alert.AlertType.CONFIRMATION,resp).show();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Returning").show();
        }
    }

    private void addtoTableList(){

        try {
            BookDto bookDto = bookController.get(txtBoodID.getText());

            if(bookDto!=null){
                BookBorrowDetailDto bookBorrowDetailDto = new BookBorrowDetailDto(txtBorrowId.getText(), bookDto.getBookID(), txtDueDate.getText());
                books.add(bookBorrowDetailDto);
            
            }
            
            ObservableList<BookBorrowDetailDto> tblData = FXCollections.observableArrayList(books);
            tblList.setItems(tblData);

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Adding Book").show();
        }
        
    }

    private void bookBorrowed(){

        try {
            BookBorrowDto bookBorrowDto = new BookBorrowDto(txtBorrowId.getText(), txtMemberID.getText(), null, txtDueDate.getText(), books);
            String resp =bookProcessController.borrowBook(bookBorrowDto);
            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Borrowing").show();
        }
    }
}
