package org.example.models;

import java.util.Date;
import java.util.List;

public class EnderecoColaborador {

    //Atributos
    private int id;
    private Colaborador colaborador; //composição
    private Logradouro logradouro; //composição
    private int numLogradouroColaborador;
    private String descLogradouroColaborador;
    private Date dtCadastro;
    private String nomeUsuario;




    //Construtor
    public EnderecoColaborador(int id, Colaborador colaborador, Logradouro logradouro, int numLogradouroColaborador, String descLogradouroColaborador, Date dtCadastro, String nomeUsuario) {
        this.id = id;
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

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


