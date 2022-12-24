package com.example.curs0;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class AddreadresController{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addadressiz;

    @FXML
    private Button addbooksiz;

    @FXML
    private Button addiz;

    @FXML
    private TextField addnameiz;


    @FXML
    private TextField addphoneiz;

    @FXML
    private Button booksiz;

    @FXML
    private Button readeriz;

    @FXML
    private Button subscriberiz;

    private String name;
    private String adress;
    private String phone;
    @FXML
    void initialize() {
        // добваление ижгту
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
