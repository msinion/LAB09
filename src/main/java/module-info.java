module com.ucv.lab09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.ucv.lab09 to javafx.fxml;
    exports com.ucv.lab09;
}