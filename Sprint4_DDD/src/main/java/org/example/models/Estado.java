package org.example.models;

import java.sql.Timestamp;

public class Estado{

    // Atributos
    private int id;
    private String sigla;
    private String nome;
    private Timestamp dataCadastro;
    private String usuario;





    // Construtor
    public Estado(int id, String sigla, String nome, Timestamp dataCadastro, String usuario) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
    }
    public Estado() {}






    // GetterSetter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
