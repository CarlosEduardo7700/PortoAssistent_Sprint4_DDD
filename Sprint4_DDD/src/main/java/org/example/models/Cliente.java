package org.example.models;

import java.sql.Timestamp;

public class Cliente {

    // Atributos
    private int id;
    private String caminhoImagem;
    private Genero genero;
    private String cliente;
    private String cpf;
    private String rg;
    private Timestamp dataNascimento;
    private String cnh;
    private String email;
    private String senha;
    private Timestamp dataCadastro;
    private String usuario;




    // Construtor


    public Cliente(int id, String caminhoImagem, Genero genero, String cliente, String cpf, String rg, Timestamp dataNascimento, String cnh, String email, String senha, Timestamp dataCadastro, String usuario) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
        this.genero = genero;
        this.cliente = cliente;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.cnh = cnh;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
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

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
