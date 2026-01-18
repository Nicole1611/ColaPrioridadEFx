module com.mycompany.colaprioridadfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.colaprioridadfx.controller to javafx.fxml;
    exports com.mycompany.colaprioridadfx;
    exports com.mycompany.colaprioridadfx.controller;
    exports com.mycompany.colaprioridadfx.model;
    exports com.mycompany.colaprioridadfx.view;
}
