package com.quinteros.alonsomantenedor.service;
import com.quinteros.alonsomantenedor.dto.UsuarioDto;

import java.util.ArrayList;

public interface IUsuariosService {

    ArrayList<UsuarioDto> getUsuarios();

    void agregarUsuario(UsuarioDto usuario);
    void eliminarUsuario(UsuarioDto usuario);

}
