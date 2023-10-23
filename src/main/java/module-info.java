module com.pp1.digramsoft {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.pp1.digramsoft to javafx.fxml;
    exports com.pp1.digramsoft;
}