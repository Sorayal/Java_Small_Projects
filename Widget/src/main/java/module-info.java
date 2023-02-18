module starleague.widget {
    requires javafx.controls;
    requires javafx.fxml;


    opens starleague.widget to javafx.fxml;
    exports starleague.widget;
}