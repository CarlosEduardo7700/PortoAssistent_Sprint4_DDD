package org.example.models;

import java.sql.Timestamp;

public class TelefoneColaborador {

    // Atributos
    private Colaborador colaborador;
    private String tipo;
    private String numero;
    private String ddd;
    private String ddi;
    private Timestamp dataCadastro;
    private String usuario;




    // Construtor

    public TelefoneColaborador(Colaborador colaborador, String tipo, String numero, String ddd, String ddi, Timestamp dataCadastro, String nomeUsuario) {
        this.colaborador = colaborador;
        this.tipo = tipo;
        this.numero = numero;
        this.ddd = ddd;
        this.ddi = ddi;
        this.dataCadastro = dataCadastro;
        this.usuario = nomeUsuario;
    }

    public TelefoneColaborador() {}






    // GetterSetter

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}

