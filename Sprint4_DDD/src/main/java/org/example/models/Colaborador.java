package org.example.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Colaborador {

    // Atributos
    private int idColaborador;
    private String caminhoImagem;
    private Genero genero;//composição
    private String nomeColaborador;
    private String cpfColaborador;
    private String rgColaborador;
    private String telefoneColaborador;
    private String emailColaborador;
    private String senhaColaborador;
    private String cnhColaborador;
    private Timestamp dataNascimentoColaborador;
    private Timestamp dtCadastro;
    private String nomeUsuario;



    // Construtor


    public Colaborador(int idColaborador, String caminhoImagem, Genero genero, String nomeColaborador, String cpfColaborador, String rgColaborador, String telefoneColaborador, String emailColaborador, String senhaColaborador, String cnhColaborador, Timestamp dataNascimentoColaborador, Timestamp dtCadastro, String nomeUsuario) {
        this.idColaborador = idColaborador;
        this.caminhoImagem = caminhoImagem;
        this.genero = genero;
        this.nomeColaborador = nomeColaborador;
        this.cpfColaborador = cpfColaborador;
        this.rgColaborador = rgColaborador;
        this.telefoneColaborador = telefoneColaborador;
        this.emailColaborador = emailColaborador;
        this.senhaColaborador = senhaColaborador;
        this.cnhColaborador = cnhColaborador;
        this.dataNascimentoColaborador = dataNascimentoColaborador;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public Colaborador() {}







    // GetterSetter
    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getCpfColaborador() {
        return cpfColaborador;
    }

    public void setCpfColaborador(String cpfColaborador) {
        this.cpfColaborador = cpfColaborador;
    }

    public String getRgColaborador() {
        return rgColaborador;
    }

    public void setRgColaborador(String rgColaborador) {
        this.rgColaborador = rgColaborador;
    }

    public String getEmailColaborador() {
        return emailColaborador;
    }

    public void setEmailColaborador(String emailColaborador) {
        this.emailColaborador = emailColaborador;
    }

    public String getSenhaColaborador() {
        return senhaColaborador;
    }

    public void setSenhaColaborador(String senhaColaborador) {
        this.senhaColaborador = senhaColaborador;
    }

    public String getCnhColaborador() {
        return cnhColaborador;
    }

    public void setCnhColaborador(String cnhColaborador) {
        this.cnhColaborador = cnhColaborador;
    }

    public Timestamp getDataNascimentoColaborador() {
        return dataNascimentoColaborador;
    }

    public void setDataNascimentoColaborador(Timestamp dataNascimentoColaborador) {
        this.dataNascimentoColaborador = dataNascimentoColaborador;
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

    public String getTelefoneColaborador() {
        return telefoneColaborador;
    }

    public void setTelefoneColaborador(String telefoneColaborador) {
        this.telefoneColaborador = telefoneColaborador;
    }
}
