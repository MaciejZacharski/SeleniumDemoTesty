module org.example.seleniumdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.seleniumdemo to javafx.fxml;
    exports org.example.seleniumdemo;
}