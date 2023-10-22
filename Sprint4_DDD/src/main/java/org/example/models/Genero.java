package org.example.models;

import java.util.Date;
import java.util.List;

public class Genero {

    // Atributos
    private int idGenero;
    private String nomeGenero;
    private Date dtCadastro;
    private String nomeUsuario;



    // Construtor
    public Genero(int idGenero, String nomeGenero, Date dtCadastro, String nomeUsuario) {
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

    public Date getDtCadastro() {
        return dtCadastro;
    }
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
