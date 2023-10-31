package org.example.models;

import java.sql.Timestamp;

public class Tipo_Chassi {

    // Atributos
    private int id;
    private String nome;
    private String descricao;
    private Timestamp dataCadastro;
    private String usuario;




    // Construtor
    public Tipo_Chassi(int idChassi, String nomeTipoChassi, String descTipoChassi, Timestamp dtCadastro, String nomeUsuario) {
        this.id = idChassi;
        this.nome = nomeTipoChassi;
        this.descricao = descTipoChassi;
        this.dataCadastro = dtCadastro;
        this.usuario = nomeUsuario;
    }
    public Tipo_Chassi() {}






    // GetterSetter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
