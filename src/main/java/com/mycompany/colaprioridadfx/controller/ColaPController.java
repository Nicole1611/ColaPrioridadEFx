package com.mycompany.colaprioridadfx.controller;

import com.mycompany.colaprioridadfx.model.Prioridad;
import com.mycompany.colaprioridadfx.model.Registro;
import com.mycompany.colaprioridadfx.view.CanvaColaP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ColaPController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtPrioridad;
    @FXML private Button btnAgregar;
    @FXML private Button btnAtender;
    @FXML private Button btnIsEmpty;
    @FXML private Button btnMostrar;
    @FXML private Label lblEstado;
    @FXML private StackPane canvasPane;

    private Prioridad cola;
    private CanvaColaP canvas;
    private ObservableList<Registro> pacientes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cola = new Prioridad();
        canvas = new CanvaColaP();
        canvasPane.getChildren().add(canvas);
        refreshCanvas();
    }

    @FXML
    private void agregarPaciente() {
        String nombre = txtNombre.getText();
        int prioridad = 0;
        try {
            prioridad = Integer.parseInt(txtPrioridad.getText());
        } catch (NumberFormatException e) { }
        if (!nombre.isEmpty()) {
            Registro r = new Registro(nombre, prioridad);
            cola.agregarPaciente(r);
            pacientes.add(r);
            refreshCanvas();
            lblEstado.setText(cola.estaVacia() ? "Cola vacía" : "Cola con " + pacientes.size() + " pacientes");
        }
        txtNombre.clear();
        txtPrioridad.clear();
    }

    @FXML
    private void atenderPaciente() {
        if (!cola.estaVacia()) {
            cola.atenderPaciente();
            if (!pacientes.isEmpty()) pacientes.remove(0);
            refreshCanvas();
            lblEstado.setText(cola.estaVacia() ? "Cola vacía" : "Cola con " + pacientes.size() + " pacientes");
        }
    }

    @FXML
    private void mostrarIsEmpty() {
        lblEstado.setText(cola.estaVacia() ? "Cola vacía" : "Cola tiene pacientes");
    }

    @FXML
    private void mostrarPacientes() {
        if (!cola.estaVacia()) {
            Registro r = pacientes.get(0);
            lblEstado.setText("Peek: " + r.getNombre() + " (P:" + r.getPrioridad() + ")");
        }
    }

    private void refreshCanvas() {
        List<Registro> listaOrdenada = new ArrayList<>(cola.cola); // copiar la cola
        Collections.sort(listaOrdenada, Comparator.comparingInt(Registro::getPrioridad)); // menor prioridad primero    
        canvas.setValues(listaOrdenada);
        canvas.render();

    }
}
