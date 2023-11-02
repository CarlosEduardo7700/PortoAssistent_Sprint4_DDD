package org.example.models;

import java.sql.Timestamp;

public class Tipo_Eixo {

    // Atributos
    private int id;
    private String nome;
    private String descricao;




    // Construtor
    public Tipo_Eixo(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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
}
