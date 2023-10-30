package org.example.models;

import java.sql.Timestamp;

public class TelefoneColaborador {

    // Atributos
    private Colaborador colaborador; //composição
    private String tipoTelefone;
    private String numeroTelefone;
    private String dddTelefone;
    private String ddiTelefone;
    private Timestamp dtCadastro;
    private String nomeUsuario;




    // Construtor

    public TelefoneColaborador(Colaborador colaborador, String tipoTelefone, String numeroTelefone, String dddTelefone, String ddiTelefone, Timestamp dtCadastro, String nomeUsuario) {
        this.colaborador = colaborador;
        this.tipoTelefone = tipoTelefone;
        this.numeroTelefone = numeroTelefone;
        this.dddTelefone = dddTelefone;
        this.ddiTelefone = ddiTelefone;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public TelefoneColaborador() {}






    // GetterSetter

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getDdiTelefone() {
        return ddiTelefone;
    }

    public void setDdiTelefone(String ddiTelefone) {
        this.ddiTelefone = ddiTelefone;
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

