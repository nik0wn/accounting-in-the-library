module com.example.curs0 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens com.example.curs0 to javafx.fxml;
    exports com.example.curs0;
}