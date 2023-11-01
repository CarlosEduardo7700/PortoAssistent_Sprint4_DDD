package org.example.models;

import java.sql.Timestamp;

public class Cidade{

    // Atributos
    private int id;
    private Estado estado;
    private String nome;
    private int ibgeCodigo;
    private int ddd;




    // Construtor

    public Cidade(int id, Estado estado, String nome, int ibgeCodigo, int ddd) {
        this.id = id;
        this.estado = estado;
        this.nome = nome;
        this.ibgeCodigo = ibgeCodigo;
        this.ddd = ddd;
    }

    public Cidade() {}







    // GetterSetter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIbgeCodigo() {
        return ibgeCodigo;
    }
    public void setIbgeCodigo(int ibgeCodigo) {
        this.ibgeCodigo = ibgeCodigo;
    }

    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

}
