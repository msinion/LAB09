package com.ucv.lab09.controller;

import com.ucv.lab09.model.EstudiantePostGrado;
import com.ucv.lab09.model.EstudiantePreGrado;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    // ================= PREGRADO =================

    @FXML
    private TextField txtApellidosPre;

    @FXML
    private TextField txtNombresPre;

    @FXML
    private TextField txtPromedio;

    @FXML
    private ComboBox<String> cmbSemestrePre;

    @FXML
    private ComboBox<String> cmbCategoria;

    @FXML
    private ComboBox<String> cmbColegio;

    @FXML
    private TextArea txtAreaPregrado;

    // ================= POSTGRADO =================

    @FXML
    private TextField txtApellidosPos;

    @FXML
    private TextField txtNombresPos;

    @FXML
    private ComboBox<String> cmbSemestrePos;

    @FXML
    private ComboBox<String> cmbGrado;

    @FXML
    private TextArea txtAreaPostgrado;

    // ================= INICIALIZAR =================

    @FXML
    public void initialize() {

        cmbSemestrePre.setItems(
                FXCollections.observableArrayList(
                        "2010-I",
                        "2011-II"
                ));

        cmbSemestrePos.setItems(
                FXCollections.observableArrayList(
                        "2010-I",
                        "2011-II"
                ));

        cmbCategoria.setItems(
                FXCollections.observableArrayList(
                        "A",
                        "B"
                ));

        cmbColegio.setItems(
                FXCollections.observableArrayList(
                        "Estatal",
                        "Particular"
                ));

        cmbGrado.setItems(
                FXCollections.observableArrayList(
                        "Bachiller",
                        "Titulado"
                ));
    }

    // ================= PREGRADO =================

    @FXML
    private void onCrearEstudiantePregrado() {

        try {

            double promedio =
                    Double.parseDouble(
                            txtPromedio.getText());

            EstudiantePreGrado estudiante =
                    new EstudiantePreGrado(
                            txtApellidosPre.getText(),
                            txtNombresPre.getText(),
                            cmbSemestrePre.getValue(),
                            cmbCategoria.getValue(),
                            promedio,
                            cmbColegio.getValue()
                    );

            txtAreaPregrado.setText(
                    estudiante.mostrarDatos(true));

        } catch (NumberFormatException e) {

            mostrarError(
                    "Ingrese un promedio válido.");
        }
    }

    @FXML
    private void onBorrarPregrado() {

        txtApellidosPre.clear();
        txtNombresPre.clear();
        txtPromedio.clear();

        cmbSemestrePre.setValue(null);
        cmbCategoria.setValue(null);
        cmbColegio.setValue(null);

        txtAreaPregrado.clear();
    }

    // ================= POSTGRADO =================

    @FXML
    private void onCrearEstudiantePostgrado() {

        EstudiantePostGrado estudiante =
                new EstudiantePostGrado(
                        txtApellidosPos.getText(),
                        txtNombresPos.getText(),
                        cmbSemestrePos.getValue(),
                        cmbGrado.getValue()
                );

        txtAreaPostgrado.setText(
                estudiante.mostrarDatos(true));
    }

    @FXML
    private void onBorrarPostgrado() {

        txtApellidosPos.clear();
        txtNombresPos.clear();

        cmbSemestrePos.setValue(null);
        cmbGrado.setValue(null);

        txtAreaPostgrado.clear();
    }

    // ================= SALIR =================

    @FXML
    private void onSalir() {
        Platform.exit();
    }

    // ================= ALERTA =================

    private void mostrarError(String mensaje) {

        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");

        alert.setHeaderText(null);

        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}