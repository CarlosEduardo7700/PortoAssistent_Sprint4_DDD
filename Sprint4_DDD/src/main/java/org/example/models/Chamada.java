package org.example.models;

import java.sql.Timestamp;

public class Chamada {

    // Atributos
    private int idChamada;
    private String caminhosImagens;
    private Cliente cliente;
    private Colaborador colaborador;
    private Veiculo veiculo;//composição
    private Modal modal; //composição
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private String local;
    private String destino;
    private String descLocal;
    private String descProblema;
    private Timestamp dtCadastro;
    private String nomeUsuario;





    // Construtor
    public Chamada(int idChamada, String caminhosImagens, Cliente cliente, Colaborador colaborador, Veiculo veiculo, Modal modal, Timestamp dataInicio, Timestamp dataFim, String local, String destino, String descLocal, String descProblema, Timestamp dtCadastro, String nomeUsuario) {
        this.idChamada = idChamada;
        this.caminhosImagens = caminhosImagens;
        this.cliente = cliente;
        this.colaborador = colaborador;
        this.veiculo = veiculo;
        this.modal = modal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.destino = destino;
        this.descLocal = descLocal;
        this.descProblema = descProblema;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public Chamada() {}






    // GetterSetter
    public int getIdChamada() {
        return idChamada;
    }

    public void setIdChamada(int idChamada) {
        this.idChamada = idChamada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Modal getModal() {
        return modal;
    }

    public void setModal(Modal modal) {
        this.modal = modal;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataFim() {
        return dataFim;
    }

    public void setDataFim(Timestamp dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescLocal() {
        return descLocal;
    }

    public void setDescLocal(String descLocal) {
        this.descLocal = descLocal;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
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

    public String getCaminhosImagens() {
        return caminhosImagens;
    }

    public void setCaminhosImagens(String caminhosImagens) {
        this.caminhosImagens = caminhosImagens;
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
}
