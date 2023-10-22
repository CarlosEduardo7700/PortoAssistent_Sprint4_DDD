package org.example.models;

import java.util.Date;
import java.util.List;

public class Telefone {

    // Atributos
    private int idTelefone;
    private Cliente cliente;//composição
    private Colaborador colaborador; //composição
    private String tipoTelefone;
    private String numeroTelefone;
    private String dddTelefone;
    private String ddiTelefone;
    private Date dtCadastro;
    private String nomeUsuario;




    // Construtor
    public Telefone(int idTelefone, Cliente cliente, Colaborador colaborador, String tipoTelefone, String numeroTelefone, String dddTelefone, String ddiTelefone, Date dtCadastro, String nomeUsuario) {
        this.idTelefone = idTelefone;
        this.cliente = cliente;
        this.colaborador = colaborador;
        this.tipoTelefone = tipoTelefone;
        this.numeroTelefone = numeroTelefone;
        this.dddTelefone = dddTelefone;
        this.ddiTelefone = ddiTelefone;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Telefone() {}






    // GetterSetter
    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getDdiTelefone() {
        return ddiTelefone;
    }

    public void setDdiTelefone(String ddiTelefone) {
        this.ddiTelefone = ddiTelefone;
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
}

