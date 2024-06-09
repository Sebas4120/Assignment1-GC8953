module ca.georgiancollege.assignment1gc8953 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ca.georgiancollege.assignment1gc8953 to javafx.fxml;
    exports ca.georgiancollege.assignment1gc8953;
}