package org.example.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Cliente {

    // Atributos
    private int idCliente;
    private String caminhoImagem;
    private Genero genero; //composição
    private String nomeCliente;
    private String cpfCliente;
    private String rgCliente;
    private Timestamp dataNascimentoCliente;
    private String cnhCliente;
    private String emailCliente;
    private String senhaCliente;
    private Timestamp dtCadastro;
    private String nomeUsuario;




    // Construtor


    public Cliente(int idCliente, String caminhoImagem, Genero genero, String nomeCliente, String cpfCliente, String rgCliente, Timestamp dataNascimentoCliente, String cnhCliente, String emailCliente, String senhaCliente, Timestamp dtCadastro, String nomeUsuario) {
        this.idCliente = idCliente;
        this.caminhoImagem = caminhoImagem;
        this.genero = genero;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.rgCliente = rgCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.cnhCliente = cnhCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public Cliente() {}








    // GetterSetter
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public Timestamp getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(Timestamp dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public String getCnhCliente() {
        return cnhCliente;
    }

    public void setCnhCliente(String cnhCliente) {
        this.cnhCliente = cnhCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
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

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
