package com.example.curs0;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.sql.ResultSet;

public class BookssearchController {

    @FXML
    private Button addbooks;

    @FXML
    private Button books;

    @FXML
    private Button find;

    @FXML
    private Button readeradd;

    @FXML
    private Button seasontickets;

    @FXML
    private TextField searchauthor;

    @FXML
    private TextField searchbookname;

    @FXML
    private TableView<Books> searchTable;

    @FXML
    private TableColumn<Books, String> namebookColumn;

    @FXML
    private TableColumn<Books, String> topicColumn;

    @FXML
    private TableColumn<Books, String> authorColumn;

    @FXML
    private TableColumn<Books, Integer> quantityColumn;

    ObservableList<Books> booksObservableList = FXCollections.observableArrayList();

    private String searchauthors = "";
    private String searchbooknames = "";

    public void readeraddbt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("add-readres.fxml"));
        Stage window = (Stage) readeradd.getScene().getWindow();
        window.setScene(new Scene(root, 600,400));
    }
    public void addbooksbt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("add-books.fxml"));
        Stage window = (Stage) addbooks.getScene().getWindow();
        window.setScene(new Scene(root, 600,400));
    }
    @FXML
    void initialize(){
    searchauthor.setOnKeyTyped(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            searchauthors = searchauthor.getText();
        }
    });
    searchbookname.setOnKeyTyped(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            searchbooknames = searchbookname.getText();
        }
    });
    find.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            searchTable.getItems().clear();
                if (searchbooknames.length() >= 1 && searchauthors.length() == 0) {
                    try {
                        ResultSet value = BDconn.search_namebook(searchbooknames);
                        while (value.next()) {
                            booksObservableList.add(new Books(value.getString("name_books"),
                                    value.getString("title_topics"), value.getString("author"),
                                    value.getInt("quantity_books")));
                        }
                    } catch (Exception e){
                        System.out.println("Ошибка 1");
                    }
                }
                else if(searchbooknames.length() == 0 && searchauthors.length() >= 1){
                    try {
                        ResultSet value = BDconn.search_author(searchauthors);
                        while (value.next()) {
                            booksObservableList.add(new Books(value.getString("name_books"),
                                    value.getString("title_topics"), value.getString("author"),
                                    value.getInt("quantity_books")));
                        }
                    } catch (Exception e){
                        System.out.println("Ошибка 2");
                    }
                }
                else if (searchbooknames.length() >= 1 && searchauthors.length() >= 1) {
                    try {
                        ResultSet value = BDconn.search_namebookAndAuthor(searchbooknames, searchauthors);
                        while (value.next()) {
                            booksObservableList.add(new Books(value.getString("name_books"),
                                    value.getString("title_topics"), value.getString("author"),
                                    value.getInt("quantity_books")));
                        }
                    }catch (Exception e){
                        System.out.println("Ошибка 3");
                    }
                }
                namebookColumn.setCellValueFactory(new PropertyValueFactory<>("namebook"));
                topicColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
                authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
                quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                searchTable.setItems(booksObservableList);

        }
    });
    }
    }