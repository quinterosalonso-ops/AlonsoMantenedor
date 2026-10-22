package com.quinteros.alonsomantenedor.dao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class usuarioDao {
    public static final String NOMBRE_ARCHIVO = "usuarios.json";
    private Path ruta;

    public usuarioDao(){
        this.ruta = Path.of(System.getProperty("user.dir"), NOMBRE_ARCHIVO);
    }
    public void guardarNombre(String nombre){
        try {
            Files.writeString(this.ruta, nombre);
        } catch (IOException e) {
            System.out.println("eror, pls solcionar");
        }

    }
    public String leerNombre(){
    //try
     //   String ret = Files.readString(this.ruta);
        return "ret";
    }
}
