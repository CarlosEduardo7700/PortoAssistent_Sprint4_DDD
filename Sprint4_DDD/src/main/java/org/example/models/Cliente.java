package org.example.models;

import java.sql.Timestamp;

public class Cliente {

    // Atributos
    private int id;
    private String caminhoImagem;
    private Genero genero;
    private String nome;
    private int cpf;
    private int rg;
    private String dataNascimento;
    private String cnh;
    private String email;
    private String senha;




    // Construtor


    public Cliente(int id, String caminhoImagem, Genero genero, String nome, int cpf, int rg, String dataNascimento, String cnh, String email, String senha) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
        this.genero = genero;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.cnh = cnh;
        this.email = email;
        this.senha = senha;
    }

    public Cliente() {}








    // GetterSetter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }
}
