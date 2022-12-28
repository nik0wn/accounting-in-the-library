package com.example.curs0;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class SeansonticketController {
    @FXML
    private Button addbooksButton;
    @FXML
    private Button booksButton;

    @FXML
    private Button nameuserButton;
    @FXML
    private Button seasonticketsButton;

    @FXML
    private Button issueButton;

    @FXML
    private Button readeraddButton;

    @FXML
    private Button returnButton;

    @FXML
    private TableView<Reader> searchTable;

    @FXML
    private TableColumn<Reader, String> namebookColumn;

    @FXML
    private TableColumn<Reader, String> nameuserColumn;

    @FXML
    private TableColumn<Reader, String> datareturnColumn;

    @FXML
    private TableColumn<Reader, String> dateissueColumn;


    @FXML
    private TextField nameuserText;

    private String nameuser;

    public void addbooksbt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("add-books.fxml"));
        Stage window = (Stage) addbooksButton.getScene().getWindow();
        window.setScene(new Scene(root, 900,600));
    }
    public void readeraddbt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("add-readres.fxml"));
        Stage window = (Stage) readeraddButton.getScene().getWindow();
        window.setScene(new Scene(root, 900,600));
    }
    public void booksbt() throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("books-search.fxml"));
        Stage window = (Stage) booksButton.getScene().getWindow();
        window.setScene(new Scene(root, 900,600));
    }
    public void issuebt() throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("issue-season-ticket.fxml"));
        Stage window = (Stage) issueButton.getScene().getWindow();
        window.setScene(new Scene(root, 600,400));
    }
    public void returnbt() throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("return-season-ticket.fxml"));
        Stage window = (Stage) returnButton.getScene().getWindow();
        window.setScene(new Scene(root, 600,400));
    }

    ObservableList <Reader> readerObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        nameuserText.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                nameuser = nameuserText.getText();
            }
        });

        try {
            ResultSet value = BDconn.season_ticket();
            while (value.next()){
                readerObservableList.add(new Reader(value.getString("name_books"),value.getString("name_readers"),
                        value.getString("date_of_issue"),value.getString("date_return")));
            }
            namebookColumn.setCellValueFactory(new PropertyValueFactory<>("namebook"));
            nameuserColumn.setCellValueFactory(new PropertyValueFactory<>("nameuser"));
            dateissueColumn.setCellValueFactory(new PropertyValueFactory<>("dateissue"));
            datareturnColumn.setCellValueFactory(new PropertyValueFactory<>("datareturn"));
            searchTable.setItems(readerObservableList);
        } catch (Exception e) {

        }
        nameuserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                searchTable.getItems().clear();
                try {
                    ResultSet value = BDconn.search_season_ticket(nameuser);

                    while (value.next()){
                        readerObservableList.add(new Reader(value.getString("name_books"),value.getString("name_readers"),
                                value.getString("date_of_issue"),value.getString("date_return")));
                    }
                } catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Неверно заполнены данные");
                    alert.showAndWait();
                }
                namebookColumn.setCellValueFactory(new PropertyValueFactory<>("namebook"));
                nameuserColumn.setCellValueFactory(new PropertyValueFactory<>("nameuser"));
                dateissueColumn.setCellValueFactory(new PropertyValueFactory<>("dateissue"));
                datareturnColumn.setCellValueFactory(new PropertyValueFactory<>("datareturn"));
                searchTable.setItems(readerObservableList);
            }
        });
    }
    }