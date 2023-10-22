package org.example.models;

import java.util.Date;
import java.util.List;

public class Cliente {

    // Atributos
    private int idCliente;
    private String caminhoImagem;
    private Genero genero; //composição
    private EnderecoCliente enderecoCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String rgCliente;
    private Date dataNascimentoCliente;
    private Telefone telefone;
    private String cnhCliente;
    private String emailCliente;
    private String senhaCliente;
    private Date dtCadastro;
    private String nomeUsuario;




    // Construtor

    public Cliente(int idCliente, String caminhoImagem, Genero genero, EnderecoCliente enderecoCliente, String nomeCliente, String cpfCliente, String rgCliente, Date dataNascimentoCliente, Telefone telefone, String cnhCliente, String emailCliente, String senhaCliente, Date dtCadastro, String nomeUsuario) {
        this.idCliente = idCliente;
        this.caminhoImagem = caminhoImagem;
        this.genero = genero;
        this.enderecoCliente = enderecoCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.rgCliente = rgCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.telefone = telefone;
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

    public EnderecoCliente getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(EnderecoCliente enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
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

    public Date getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(Date dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
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

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
