package org.example.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Genero {

    // Atributos
    private int idGenero;
    private String nomeGenero;
    private Timestamp dtCadastro;
    private String nomeUsuario;



    // Construtor
    public Genero(int idGenero, String nomeGenero, Timestamp dtCadastro, String nomeUsuario) {
        this.idGenero = idGenero;
        this.nomeGenero = nomeGenero;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Genero() {}






    // GetterSetter
    public int getIdGenero() {
        return idGenero;
    }
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }
    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public Timestamp getDtCadastro() {
        return dtCadastro;
    }
    public void setDtCadastro(Timestamp dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
