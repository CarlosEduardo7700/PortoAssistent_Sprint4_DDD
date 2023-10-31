package org.example.models;

import java.sql.Timestamp;

public class Genero {

    // Atributos
    private int id;
    private String nome;
    private Timestamp dataCadastro;
    private String usuario;



    // Construtor
    public Genero(int id, String nome, Timestamp dataCadastro, String usuario) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
    }
    public Genero() {}






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
