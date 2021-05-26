package com.example.pueblo;

import java.io.Serializable;

public class Titiribi implements Serializable {

    String titulo, texto;
    int foto;

    public Titiribi(String titulo, String texto, int foto) {
        this.titulo = titulo;
        this.texto = texto;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
