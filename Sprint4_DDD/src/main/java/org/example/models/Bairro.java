package org.example.models;

import java.sql.Timestamp;

public class Bairro {

    // Atributos
    private int id;
    private Cidade cidade;
    private String nome;
    private String zona;
    private Timestamp dataCadastro;
    private String usuario;




    // Construtor
    public Bairro(int id, Cidade cidade, String nome, String zona, Timestamp dataCadastro, String usuario) {
        this.id = id;
        this.cidade = cidade;
        this.nome = nome;
        this.zona = zona;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
    }
    public Bairro() {}




    // GetterSetter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
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
