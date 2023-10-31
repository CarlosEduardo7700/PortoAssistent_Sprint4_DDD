package org.example.models;

import java.sql.Timestamp;

public class Tipo_Eixo {

    // Atributos
    private int id;
    private String nome;
    private String descricao;
    private Timestamp dataCadastro;
    private String usuario;




    // Construtor
    public Tipo_Eixo(int idEixo, String nomeTipoEixo, String descTipoEixo, Timestamp dtCadastro, String nomeUsuario) {
        this.id = idEixo;
        this.nome = nomeTipoEixo;
        this.descricao = descTipoEixo;
        this.dataCadastro = dtCadastro;
        this.usuario = nomeUsuario;
    }
    public Tipo_Eixo() {}







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
