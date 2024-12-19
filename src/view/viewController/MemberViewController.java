package view.viewController;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controller.MemberController;
import dto.MemberDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;


public class MemberViewController {


    private MemberController memberController;

    public MemberViewController() throws Exception{
        memberController = new MemberController();
        
    }

    @FXML
    private TableColumn<MemberDto, String> ColAddress;

    @FXML
    private TableColumn<MemberDto, String> ColDob;

    @FXML
    private TableColumn<MemberDto, String> ColID;

    @FXML
    private TableColumn<MemberDto, String> ColName;

    @FXML
    private TableColumn<MemberDto, String> ColPhone;

    @FXML
    private JFXButton btnAddMember;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnReturn;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<MemberDto> memberTable;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    void AddMember(ActionEvent event) {

    }

    @FXML
    void DeleteMember(ActionEvent event) {

    }

    @FXML
    void SearchMember(ActionEvent event) {

    }

    @FXML
    void UpdateMember(ActionEvent event) {

    }

    @FXML
    void ReturnBack(ActionEvent event) {

    }

    @FXML
    private AnchorPane sceneNow;
    
    @FXML
    private void initialize()throws Exception {
        
        ColID.setCellValueFactory(new PropertyValueFactory<>("MemberId"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("MemberName"));
        ColPhone.setCellValueFactory(new PropertyValueFactory<>("MemberPhoneNo"));
        ColDob.setCellValueFactory(new PropertyValueFactory<>("MemberDob"));
        ColAddress.setCellValueFactory(new PropertyValueFactory<>("MemberAddress"));
        loadTable();
    }

    private void loadTable() throws Exception{

        ArrayList<MemberDto> members= memberController.getAll();    
        ObservableList<MemberDto> tableData =  FXCollections.observableArrayList(members);
        memberTable.setItems(tableData);
    }
}
