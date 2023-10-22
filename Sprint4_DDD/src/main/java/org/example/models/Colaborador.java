package org.example.models;

import java.util.Date;
import java.util.List;

public class Colaborador {

    // Atributos
    private int idColaborador;
    private String caminhoImagem;
    private Modal modal;//composição
    private Genero genero;//composição
    private EnderecoColaborador enderecoColaborador; //composição
    private Telefone telefone;//composição
    private String nomeColaborador;
    private String cpfColaborador;
    private String rgColaborador;
    private String emailColaborador;
    private String senhaColaborador;
    private String cnhColaborador;
    private Date dataNascimentoColaborador;
    private Date dtCadastro;
    private String nomeUsuario;



    // Construtor
    public Colaborador(int idColaborador, String caminhoImagem, Modal modal, Genero genero, EnderecoColaborador enderecoColaborador, Telefone telefone, String nomeColaborador, String cpfColaborador, String rgColaborador, String emailColaborador, String senhaColaborador, String cnhColaborador, Date dataNascimentoColaborador, Date dtCadastro, String nomeUsuario) {
        this.idColaborador = idColaborador;
        this.caminhoImagem = caminhoImagem;
        this.modal = modal;
        this.genero = genero;
        this.enderecoColaborador = enderecoColaborador;
        this.telefone = telefone;
        this.nomeColaborador = nomeColaborador;
        this.cpfColaborador = cpfColaborador;
        this.rgColaborador = rgColaborador;
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

    public Modal getModal() {
        return modal;
    }

    public void setModal(Modal modal) {
        this.modal = modal;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public EnderecoColaborador getEnderecoColaborador() {
        return enderecoColaborador;
    }

    public void setEnderecoColaborador(EnderecoColaborador enderecoColaborador) {
        this.enderecoColaborador = enderecoColaborador;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
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

    public Date getDataNascimentoColaborador() {
        return dataNascimentoColaborador;
    }

    public void setDataNascimentoColaborador(Date dataNascimentoColaborador) {
        this.dataNascimentoColaborador = dataNascimentoColaborador;
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
