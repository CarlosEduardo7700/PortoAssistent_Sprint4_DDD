package org.example.models;

import java.sql.Timestamp;

public class EnderecoColaborador {

    //Atributos
    private Colaborador colaborador; //composição
    private Logradouro logradouro; //composição
    private int numLogradouroColaborador;
    private String descLogradouroColaborador;
    private Timestamp dtCadastro;
    private String nomeUsuario;




    //Construtor
    public EnderecoColaborador(Colaborador colaborador, Logradouro logradouro, int numLogradouroColaborador, String descLogradouroColaborador, Timestamp dtCadastro, String nomeUsuario) {
        this.colaborador = colaborador;
        this.logradouro = logradouro;
        this.numLogradouroColaborador = numLogradouroColaborador;
        this.descLogradouroColaborador = descLogradouroColaborador;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public EnderecoColaborador(){}







    //Getter e Setter
    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumLogradouroColaborador() {
        return numLogradouroColaborador;
    }

    public void setNumLogradouroColaborador(int numLogradouroColaborador) {
        this.numLogradouroColaborador = numLogradouroColaborador;
    }

    public String getDescLogradouroColaborador() {
        return descLogradouroColaborador;
    }

    public void setDescLogradouroColaborador(String descLogradouroColaborador) {
        this.descLogradouroColaborador = descLogradouroColaborador;
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


