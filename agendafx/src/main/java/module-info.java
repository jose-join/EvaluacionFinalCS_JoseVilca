module com.mycompany.agendafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.persistence;

    opens com.mycompany.agendafx to javafx.fxml;
    exports com.mycompany.agendafx;
}
