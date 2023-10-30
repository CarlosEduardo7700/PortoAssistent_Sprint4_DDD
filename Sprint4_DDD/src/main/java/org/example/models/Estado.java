package org.example.models;

import java.sql.Timestamp;

public class Estado{

    // Atributos
    private int idEstado;
    private String sigla;
    private String nomeEstado;
    private Timestamp dtCadastro;
    private String nomeUsuario;





    // Construtor
    public Estado(int idEstado, String sigla, String nomeEstado, Timestamp dtCadastro, String nomeUsuario) {
        this.idEstado = idEstado;
        this.sigla = sigla;
        this.nomeEstado = nomeEstado;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Estado() {}






    // GetterSetter
    public int getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
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
