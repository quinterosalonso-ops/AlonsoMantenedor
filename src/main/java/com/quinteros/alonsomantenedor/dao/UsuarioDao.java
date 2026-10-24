package com.quinteros.alonsomantenedor.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.quinteros.alonsomantenedor.dto.UsuarioDto;


public class UsuarioDao {
    public static final String NOMBRE_ARCHIVO = "usuarios.json";
    private Path ruta;
    private Gson gson;

    public UsuarioDao() {
        this.ruta = Path.of(System.getProperty("user.dir"), NOMBRE_ARCHIVO);
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(ruta);
    }

    public void guardarUsuarios(ArrayList<UsuarioDto> usuarios) {
        try {
            String datos = this.gson.toJson(usuarios);
            Files.writeString(this.ruta, datos);
        } catch (IOException e) {
            System.out.println("usuarioDao error: " + e.getMessage());
        }

    }

    public ArrayList<UsuarioDto> ObtenerUsuarios() {
       try {
           String datos = Files.readString(this.ruta);
           Type tipodato = new TypeToken<ArrayList<UsuarioDto>>(){}.getType();
           ArrayList<UsuarioDto> Usuarios = this.gson.fromJson(datos,tipodato);
           if (Usuarios == null){
               return new ArrayList<>();
           }
           return  Usuarios;
       } catch (IOException e) {
           return new ArrayList<>();
       }
    }
}
