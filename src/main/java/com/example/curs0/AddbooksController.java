package com.example.curs0;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddbooksController {
    @FXML
    private Button add;

    @FXML
    private TextField authorbook;

    @FXML
    private Button books;

    @FXML
    private TextField namebook;

    @FXML
    private TextField publisher;

    @FXML
    private TextField quantity;

    @FXML
    private Button readeradd;

    @FXML
    private Button seasontickets;

    @FXML
    private TextField topics;

    @FXML
    private TextField yearofpublishing;

   private String topic;
   private String author;
   private String name_books;
   private String publishers;
   private int year_book;
   private int quantity_book;

   public void booksbt() throws  Exception{
       Parent root = FXMLLoader.load(getClass().getResource("books-search.fxml"));
       Stage window = (Stage) books.getScene().getWindow();
       window.setScene(new Scene(root, 900,600));
   }
   public void readeraddbt() throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("add-readres.fxml"));
       Stage window = (Stage) readeradd.getScene().getWindow();
       window.setScene(new Scene(root, 900,600));
   }
    public void seasonticketsbt() throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("season-ticket.fxml"));
        Stage window = (Stage) seasontickets.getScene().getWindow();
        window.setScene(new Scene(root, 900,600));
    }
    @FXML
    void initialize() {

        namebook.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                name_books = namebook.getText();
            }
        });
        authorbook.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                author = authorbook.getText();
            }
        });
        topics.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                topic = topics.getText();
            }
        });
        publisher.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                publishers = publisher.getText();
            }
        });
        yearofpublishing.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                year_book =Integer.parseInt(yearofpublishing.getText());
            }
        });
        quantity.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                quantity_book = Integer.parseInt(quantity.getText());
            }
        });

        add.setOnAction(actionEvent -> {
            try {
                BDconn.input_books(topic,author,name_books,publishers,year_book,quantity_book);
            } catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Неверно заполнены данные");
                alert.showAndWait();
            }
        });
    }

    }
