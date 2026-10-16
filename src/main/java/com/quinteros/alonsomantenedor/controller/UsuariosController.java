package com.quinteros.alonsomantenedor.controller;

import com.quinteros.alonsomantenedor.dto.UsuarioDto;
import com.quinteros.alonsomantenedor.model.UsuariosModel;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

;


public class UsuariosController {

    UsuarioDto usuarioDtoEliminar;

    private UsuariosModel usuariosModel;
    private ObservableList<UsuarioDto> usuarios;

    public UsuariosController(){
        this.usuariosModel = new UsuariosModel();
    }

    private Integer idUsusario = 0;
    private Integer getidUsuario(){
        this.idUsusario = this.idUsusario + 1;
        return idUsusario;
    }

    @FXML
    public TextField txtUsuario;
    @FXML
    public PasswordField txtContrasena;
    @FXML
    public Button btnRegistrar;
    @FXML
    public Button btnActualizar;
    @FXML
    public TextField txtId;
    @FXML
    public Button btnEliminar;
    @FXML
    public TableView tableUsuarios;
    @FXML
    public TableColumn colId;
    @FXML
    public TableColumn colUsuario;
    @FXML
    public TableColumn colDatos;

    public void initialize(){
        this.colId.setCellFactory(new PropertyValueFactory<>("id"));
        this.colUsuario.setCellFactory(new PropertyValueFactory<>("usuario"));
        this.colDatos.setCellFactory(new PropertyValueFactory<>("contrasena"));

        this.usuarios = FXCollections.observableArrayList();
        this.tableUsuarios.setItems(this.usuarios);
    }


    @FXML
    public void handleAgregarUsuario(ActionEvent actionEvent) {
        try {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setNombre(txtUsuario.getText());
            usuarioDto.setContrasena(txtContrasena.getText());

            if (txtUsuario.getText().trim().isEmpty() || txtContrasena.getText().trim().isEmpty()) {
                throw new Exception("Datos no deben estar vacio");
            }
            usuarioDto.setId(this.getidUsuario());

            this.txtUsuario.setText("");
            this.txtContrasena.setText("");

            this.txtUsuario.requestFocus();

            System.out.println("Registrando usuario");

            System.out.println(usuarioDto);
            this.usuariosModel.agregarUsuario(usuarioDto);
            System.out.println(this.usuariosModel.getUsuarios().size());

            this.usuarios.setAll(this.usuariosModel.getUsuarios());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void handleSeleccionar(MouseEvent mouseEvent) {
        UsuarioDto usuarioDto = (UsuarioDto) this.tableUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioDto != null) {
            this.txtId.setText(usuarioDto.getId().toString());
            this.btnEliminar.setDisable(false);
            this.usuarioDtoEliminar = usuarioDto;

        }
    }

    @FXML
    public void handleEliminarUsuario(ActionEvent actionEvent) {
        this.usuariosModel.eliminarUsuario(this.usuarioDtoEliminar);
        this.usuarios.setAll(this.usuariosModel.getUsuarios());
        this.usuarioDtoEliminar = null;
    }



}
