module com.mycompany.agenda1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;

    opens com.mycompany.agenda1 to javafx.fxml;
    exports com.mycompany.agenda1;
}
