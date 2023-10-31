package org.example.models;

import java.sql.Timestamp;

public class EnderecoCliente {

    // Atributos
    private Cliente cliente;
    private Logradouro logradouro;
    private int numLogradouro;
    private String descLogradouro;
    private Timestamp dataCadastro;
    private String usuario;



    // Construtor


    public EnderecoCliente(Cliente cliente, Logradouro logradouro, int numLogradouro, String descLogradouro, Timestamp dataCadastro, String usuario) {
        this.cliente = cliente;
        this.logradouro = logradouro;
        this.numLogradouro = numLogradouro;
        this.descLogradouro = descLogradouro;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
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

    public int getNumLogradouro() {
        return numLogradouro;
    }
    public void setNumLogradouro(int numLogradouro) {
        this.numLogradouro = numLogradouro;
    }

    public String getDescLogradouro() {
        return descLogradouro;
    }
    public void setDescLogradouro(String descLogradouro) {
        this.descLogradouro = descLogradouro;
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

}
