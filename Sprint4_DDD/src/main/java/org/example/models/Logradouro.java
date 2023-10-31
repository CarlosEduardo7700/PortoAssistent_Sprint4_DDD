package org.example.models;

import java.sql.Timestamp;

public class Logradouro {

    // Atributos
    private int id;
    private Bairro bairro;
    private String nome;
    private String cep;
    private Timestamp dataCadastro;
    private String usuario;





    // Construtor
    public Logradouro(int id, Bairro bairro, String nome, String cep, Timestamp dataCadastro, String usuario) {
        this.id = id;
        this.bairro = bairro;
        this.nome = nome;
        this.cep = cep;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
    }
    public Logradouro() {}







    // GetterSetter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Bairro getBairro() {
        return bairro;
    }
    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
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
