package org.example.models;

import java.sql.Timestamp;

public class Tipo_Modal {

    // Atributos
    private int id;
    private String nome;




    // Construtor

    public Tipo_Modal(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Tipo_Modal() {}





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
