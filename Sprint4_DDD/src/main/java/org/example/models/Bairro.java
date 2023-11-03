package org.example.models;

import java.sql.Timestamp;

public class Bairro {

    // Atributos
    private int id;
    private Cidade cidade;
    private String nome;
    private String zona;




    // Construtor
    public Bairro(int id, Cidade cidade, String nome, String zona) {
        this.id = id;
        this.cidade = cidade;
        this.nome = nome;
        this.zona = zona;
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

}
