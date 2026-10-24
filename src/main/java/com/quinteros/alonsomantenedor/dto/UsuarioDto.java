package com.quinteros.alonsomantenedor.dto;

public class UsuarioDto {

    private Long id;
    private String nombre = "";
    private String contrasena = "";
    private String datos = "";

    private static final String[] FRASES = {
            "M.E.R.A. te da la bienvenida",
            "Base establecida.",
            "Calentando Motores.",
            "Nave generada automaticamente con 1 aviso de suspension, primer aviso.",
            "Bloquear cuenta en 2 dias",
            "Test.",
            "No mas Tests.",
            "Quizas un par mas."
    };
    public String DatosRandom() {
        long tiempo = System.currentTimeMillis();
        int indiceAleatorio = (int) (tiempo % FRASES.length);
        return FRASES[indiceAleatorio];
    }

    public UsuarioDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return DatosRandom();
    }
}
