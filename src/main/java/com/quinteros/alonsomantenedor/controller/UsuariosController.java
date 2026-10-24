package com.quinteros.alonsomantenedor.controller;

import com.quinteros.alonsomantenedor.dao.UsuarioDao;
import com.quinteros.alonsomantenedor.dto.UsuarioDto;
import com.quinteros.alonsomantenedor.service.IUsuariosService;
import com.quinteros.alonsomantenedor.service.UsuariosService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.security.Timestamp;
import java.util.ArrayList;


public class UsuariosController {

    UsuarioDto usuarioDtoEliminar;
    UsuarioDao usuarioDao;

    private IUsuariosService usuariosService;
    private ObservableList<UsuarioDto> usuarios;

    public UsuariosController() {
        this.usuariosService = new UsuariosService();
    }

    private long getidUsuario() {
        return System.currentTimeMillis();

    }

    @FXML
    public TextField txtUsuario;
    @FXML
    public PasswordField txtContrasena;
    @FXML
    public Button btnRegistrar;
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

    public void initialize() {
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colDatos.setCellValueFactory(new PropertyValueFactory<>("datos"));
        this.usuarios = FXCollections.observableArrayList();


        this.usuarioDao = new UsuarioDao();
        ArrayList<UsuarioDto> usuarioDtosGuardados = this.usuarioDao.ObtenerUsuarios();
        for (UsuarioDto usuario : usuarioDtosGuardados) {
            usuariosService.agregarUsuario(usuario);
        }

        this.usuarios.setAll(this.usuariosService.getUsuarios());
        this.tableUsuarios.setItems(this.usuarios);


    }


    @FXML
    public void handleAgregarUsuario(ActionEvent actionEvent) {
        try {
            if (txtUsuario.getText().trim().isEmpty() || txtContrasena.getText().trim().isEmpty()) {
                throw new Exception("Datos no deben estar vacio");
            }
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setId(getidUsuario());
            usuarioDto.setNombre(txtUsuario.getText());
            usuarioDto.setContrasena(txtContrasena.getText());
            usuarioDto.setDatos(usuarioDto.toString());


            this.txtUsuario.setText("");
            this.txtContrasena.setText("");
            this.txtUsuario.requestFocus();


            System.out.println("Registrando usuario");
            System.out.println(usuarioDto);
            System.out.println(this.usuariosService.getUsuarios().size());

            this.usuariosService.agregarUsuario(usuarioDto);
            this.usuarioDao.guardarUsuarios(usuariosService.getUsuarios());
            this.usuarios.setAll(this.usuariosService.getUsuarios());


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
        this.usuariosService.eliminarUsuario(this.usuarioDtoEliminar);
        this.usuarioDao.guardarUsuarios(usuariosService.getUsuarios());

        this.usuarios.setAll(this.usuariosService.getUsuarios());

        this.usuarioDtoEliminar = null;
        this.txtId.setText("");
        this.btnEliminar.setDisable(true);
    }
}
