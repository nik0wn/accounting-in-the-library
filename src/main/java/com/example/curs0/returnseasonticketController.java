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

public class returnseasonticketController {

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField namebookText;

    @FXML
    private TextField nameuserText;

    private String namebook;
    private String nameuser;

    public void backbt() throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("season-ticket.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 900,600));
    }

    @FXML
    void initialize() {
        nameuserText.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                nameuser = nameuserText.getText();
            }
        });
        namebookText.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                namebook = namebookText.getText();
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    BDconn.insert_season_ticket(namebook,nameuser);
                } catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Неверно заполнены данные");
                    alert.showAndWait();
                }
            }
        });
    }
    }




