package com.example.curs0;

import javafx.event.ActionEvent;
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
import java.sql.Connection;
import java.util.ResourceBundle;

public class AddreadresController{
    @FXML
    private TextField addadressiz;

    @FXML
    private Button addbooks;

    @FXML
    private Button addiz;

    @FXML
    private TextField addnameiz;


    @FXML
    private TextField addphoneiz;

    @FXML
    private Button books;

    @FXML
    private Button readeriz;

    @FXML
    private Button subscriber;

    private String name;
    private String adress;
    private String phone;

    public void addbooksbt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("add-books.fxml"));
        Stage window = (Stage) addbooks.getScene().getWindow();
        window.setScene(new Scene(root, 600,400));
    }
    public void booksbt() throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("add-books.fxml"));
        Stage window = (Stage) books.getScene().getWindow();
        window.setScene(new Scene(root, 600,400));
    }
    @FXML
    void initialize() {
        addnameiz.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                name = addnameiz.getText();
            }
        });
        addadressiz.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                adress = addadressiz.getText();
            }
        });
        addphoneiz.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                phone = addphoneiz.getText();
            }
        });
            addiz.setOnAction(actionEvent -> {
                try {
                    BDconn.input_bd(name, adress, phone);
                }catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Неверно заполнены данные");
                    alert.showAndWait();
                }
            });
        }
    }
