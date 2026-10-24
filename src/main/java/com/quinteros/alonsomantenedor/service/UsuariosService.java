package com.quinteros.alonsomantenedor.service;

import com.quinteros.alonsomantenedor.dto.UsuarioDto;

import java.util.ArrayList;

public class UsuariosService implements IUsuariosService{

    private final ArrayList<UsuarioDto> usuarios;

    public ArrayList<UsuarioDto> getUsuarios() {
        return usuarios;
    }

    public UsuariosService() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void agregarUsuario(UsuarioDto usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void eliminarUsuario(UsuarioDto usuario) {
        usuarios.remove(usuario);
    }


}
