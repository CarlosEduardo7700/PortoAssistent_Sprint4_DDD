package org.example.models;

import java.sql.Timestamp;

public class Logradouro {

    // Atributos
    private int idLogradouro;
    private Bairro bairro; //composição
    private String nomeLogradouro;
    private String cep;
    private Timestamp dtCadastro;
    private String nomeUsuario;





    // Construtor
    public Logradouro(int idLogradouro, Bairro bairro, String nomeLogradouro, String cep, Timestamp dtCadastro, String nomeUsuario) {
        this.idLogradouro = idLogradouro;
        this.bairro = bairro;
        this.nomeLogradouro = nomeLogradouro;
        this.cep = cep;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Logradouro() {}







    // GetterSetter
    public int getIdLogradouro() {
        return idLogradouro;
    }
    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }
    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }
    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public Timestamp getDtCadastro() {
        return dtCadastro;
    }
    public void setDtCadastro(Timestamp dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
