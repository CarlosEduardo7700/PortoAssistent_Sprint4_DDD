package org.example.models;

import java.sql.Timestamp;

public class Genero {

    // Atributos
    private int id;
    private String nome;



    // Construtor
    public Genero(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

}
