package org.example.models;

import java.util.Date;
import java.util.List;

public class EnderecoCliente {

    // Atributos
    private int idEnderecoCliente;
    private Cliente cliente; // composição
    private Logradouro logradouro; // composição
    private int numLogradouroCliente;
    private String descLogradouroCliente;
    private Date dtCadastro;
    private String nomeUsuario;



    // Construtor

    public EnderecoCliente(int idEnderecoCliente, Cliente cliente, Logradouro logradouro, int numLogradouroCliente, String descLogradouroCliente, Date dtCadastro, String nomeUsuario) {
        this.idEnderecoCliente = idEnderecoCliente;
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

    public int getIdEnderecoCliente() {
        return idEnderecoCliente;
    }
    public void setIdEnderecoCliente(int idEnderecoCliente) {
        this.idEnderecoCliente = idEnderecoCliente;
    }
}
