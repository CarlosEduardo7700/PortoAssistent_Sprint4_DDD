package org.example.models;

import java.sql.Timestamp;

public class EnderecoCliente {

    // Atributos
    private Cliente cliente; // composição
    private Logradouro logradouro; // composição
    private int numLogradouroCliente;
    private String descLogradouroCliente;
    private Timestamp dtCadastro;
    private String nomeUsuario;



    // Construtor


    public EnderecoCliente(Cliente cliente, Logradouro logradouro, int numLogradouroCliente, String descLogradouroCliente, Timestamp dtCadastro, String nomeUsuario) {
        this.cliente = cliente;
        this.logradouro = logradouro;
        this.numLogradouroCliente = numLogradouroCliente;
        this.descLogradouroCliente = descLogradouroCliente;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public EnderecoCliente() {}




    // GetterSetter
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumLogradouroCliente() {
        return numLogradouroCliente;
    }
    public void setNumLogradouroCliente(int numLogradouroCliente) {
        this.numLogradouroCliente = numLogradouroCliente;
    }

    public String getDescLogradouroCliente() {
        return descLogradouroCliente;
    }
    public void setDescLogradouroCliente(String descLogradouroCliente) {
        this.descLogradouroCliente = descLogradouroCliente;
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
