package org.example.models;

import java.sql.Timestamp;

public class Tipo_Eixo {

    // Atributos
    private int idEixo;
    private String nomeTipoEixo;
    private String descTipoEixo;
    private Timestamp dtCadastro;
    private String nomeUsuario;




    // Construtor
    public Tipo_Eixo(int idEixo, String nomeTipoEixo, String descTipoEixo, Timestamp dtCadastro, String nomeUsuario) {
        this.idEixo = idEixo;
        this.nomeTipoEixo = nomeTipoEixo;
        this.descTipoEixo = descTipoEixo;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Tipo_Eixo() {}







    // GetterSetter
    public int getIdEixo() {
        return idEixo;
    }

    public void setIdEixo(int idEixo) {
        this.idEixo = idEixo;
    }

    public String getNomeTipoEixo() {
        return nomeTipoEixo;
    }

    public void setNomeTipoEixo(String nomeTipoEixo) {
        this.nomeTipoEixo = nomeTipoEixo;
    }

    public String getDescTipoEixo() {
        return descTipoEixo;
    }

    public void setDescTipoEixo(String descTipoEixo) {
        this.descTipoEixo = descTipoEixo;
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
