module ca.georgiancollege.assignment1gc8953 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ca.georgiancollege.assignment1gc8953 to javafx.fxml;
    exports ca.georgiancollege.assignment1gc8953;
    exports ca.georgiancollege.assignment1gc8953.Runners;
    opens ca.georgiancollege.assignment1gc8953.Runners to javafx.fxml;
    exports ca.georgiancollege.assignment1gc8953.Models;
    opens ca.georgiancollege.assignment1gc8953.Models to javafx.fxml;
    exports ca.georgiancollege.assignment1gc8953.Controllers;
    opens ca.georgiancollege.assignment1gc8953.Controllers to javafx.fxml;
}