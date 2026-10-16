package com.quinteros.alonsomantenedor.model;

import com.quinteros.alonsomantenedor.dto.UsuarioDto;

import java.util.ArrayList;

public class UsuariosModel {

    private final ArrayList<UsuarioDto> usuarios = new ArrayList<>();

    public ArrayList<UsuarioDto> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(UsuarioDto usuario) {
        usuarios.add(usuario);
    }

    public void eliminarUsuario(UsuarioDto usuario) {
        usuarios.remove(usuario);
    }
}

        }
