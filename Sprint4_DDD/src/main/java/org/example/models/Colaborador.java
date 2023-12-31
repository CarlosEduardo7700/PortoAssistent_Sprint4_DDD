package org.example.models;

import java.sql.Timestamp;

public class Colaborador {

    // Atributos
    private int id;
    private String caminhoImagem;
    private Genero genero;
    private String nome;
    private String cpf;
    private Long rg;
    private String email;
    private String senha;
    private String cnh;
    private String dataNascimento;



    // Construtor
    public Colaborador(int id, String caminhoImagem, Genero genero, String nome, String cpf, Long rg, String email, String senha, String cnh, String dataNascimento) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
        this.genero = genero;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
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

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

}
