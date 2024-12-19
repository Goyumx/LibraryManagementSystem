package view.viewController;

import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controller.MemberController;
import dto.MemberDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;


public class MemberViewController {

    Stage stage;
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
        saveMember();
    }

    @FXML
    void DeleteMember(ActionEvent event) {
        delete();
    }

    @FXML
    void SearchMember(ActionEvent event) {
        SearchMember();
    }

    @FXML
    void UpdateMember(ActionEvent event) {
        updateMember();
    }

    @FXML
    void ReturnBack(ActionEvent event) throws IOException{
        stage=(Stage)sceneNow.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/MainInterface.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("");
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

    private void clearForm(){
        txtMemberID.clear();
        txtName.clear();
        txtPhoneNo.clear();
        txtDob.clear();
        txtAddress.clear();
    }

    private void saveMember(){

        try {
            MemberDto memberDto = new MemberDto(txtMemberID.getText(),txtName.getText(), txtPhoneNo.getText(), txtDob.getText(), txtAddress.getText());
            String resp = memberController.save(memberDto);
            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Saving").show();
        }
    }

    public void delete(){

     try {
        String MemberID = txtMemberID.getText();
        String resp = memberController.delete(MemberID);
        new Alert(Alert.AlertType.CONFIRMATION,resp).show();
        clearForm();
        loadTable();

    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "Error Occured in Deleting").show();
     }   
    }

    private void SearchMember(){
        try {
            String MemberID = txtMemberID.getText();
            
            MemberDto searchedMember =memberController.get(MemberID);
            txtName.setText(searchedMember.getMemberName());
            txtAddress.setText(searchedMember.getMemberAddress());
            txtDob.setText(searchedMember.getMemberDob());
            txtPhoneNo.setText(searchedMember.getMemberPhoneNo());
    
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in Searching").show();
         }   
    }

    private void updateMember(){
        try {
            
            MemberDto updatedMember =new MemberDto(txtMemberID.getText(), txtName.getText(), txtPhoneNo.getText(), txtDob.getText(), txtAddress.getText());
            String resp = memberController.update(updatedMember);
            new Alert(Alert.AlertType.CONFIRMATION,resp).show();
            clearForm();
            loadTable();
    
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error Occured in updating").show();
         }   
    }
}

