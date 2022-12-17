module com.example.curs0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.curs0 to javafx.fxml;
    exports com.example.curs0;
}