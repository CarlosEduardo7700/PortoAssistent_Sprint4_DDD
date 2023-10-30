package org.example.models;

import java.sql.Timestamp;

public class Tipo_Chassi {

    // Atributos
    private int idChassi;
    private String nomeTipoChassi;
    private String descTipoChassi;
    private Timestamp dtCadastro;
    private String nomeUsuario;




    // Construtor
    public Tipo_Chassi(int idChassi, String nomeTipoChassi, String descTipoChassi, Timestamp dtCadastro, String nomeUsuario) {
        this.idChassi = idChassi;
        this.nomeTipoChassi = nomeTipoChassi;
        this.descTipoChassi = descTipoChassi;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Tipo_Chassi() {}






    // GetterSetter
    public int getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(int idChassi) {
        this.idChassi = idChassi;
    }

    public String getNomeTipoChassi() {
        return nomeTipoChassi;
    }

    public void setNomeTipoChassi(String nomeTipoChassi) {
        this.nomeTipoChassi = nomeTipoChassi;
    }

    public String getDescTipoChassi() {
        return descTipoChassi;
    }

    public void setDescTipoChassi(String descTipoChassi) {
        this.descTipoChassi = descTipoChassi;
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
