package org.example.models;

import java.sql.Timestamp;

public class Colaborador {

    // Atributos
    private int id;
    private String caminhoImagem;
    private Genero genero;
    private String nome;
    private String cpf;
    private int rg;
    private String telefone;
    private String email;
    private String senha;
    private String cnh;
    private Timestamp dataNascimento;



    // Construtor


    public Colaborador(int id, String caminhoImagem, Genero genero, String nome, String cpf, int rg, String telefone, String email, String senha, String cnh, Timestamp dataNascimento) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
        this.genero = genero;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.cnh = cnh;
        this.dataNascimento = dataNascimento;
    }

    public Colaborador() {}







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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
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

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
