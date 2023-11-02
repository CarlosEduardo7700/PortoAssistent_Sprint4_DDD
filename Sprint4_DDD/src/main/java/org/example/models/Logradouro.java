package org.example.models;

import java.sql.Timestamp;

public class Logradouro {

    // Atributos
    private int id;
    private Bairro bairro;
    private String nome;
    private int cep;





    // Construtor

    public Logradouro(int id, Bairro bairro, String nome, int cep) {
        this.id = id;
        this.bairro = bairro;
        this.nome = nome;
        this.cep = cep;
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

    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
}
