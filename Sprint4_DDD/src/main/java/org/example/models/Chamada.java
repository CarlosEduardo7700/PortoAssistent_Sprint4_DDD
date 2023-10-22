package org.example.models;

import java.util.Date;
import java.util.List;

public class Chamada {

    // Atributos
    private int idChamada;
    private String caminhosImagens;
    private Veiculo veiculo;//composição
    private Modal modal; //composição
    private Date dataInicio;
    private Date dataFim;
    private String local;
    private String destino;
    private String descLocal;
    private boolean cargaVeiculo;
    private String descProblema;
    private Date dtCadastro;
    private String nomeUsuario;





    // Construtor
    public Chamada(int idChamada, String caminhosImagens, Veiculo veiculo, Modal modal, Date dataInicio, Date dataFim, String local, String destino, String descLocal, boolean cargaVeiculo, String descProblema, Date dtCadastro, String nomeUsuario) {
        this.idChamada = idChamada;
        this.caminhosImagens = caminhosImagens;
        this.veiculo = veiculo;
        this.modal = modal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.destino = destino;
        this.descLocal = descLocal;
        this.cargaVeiculo = cargaVeiculo;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
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

    public boolean isCargaVeiculo() {
        return cargaVeiculo;
    }

    public void setCargaVeiculo(boolean cargaVeiculo) {
        this.cargaVeiculo = cargaVeiculo;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
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

    public String getCaminhosImagens() {
        return caminhosImagens;
    }

    public void setCaminhosImagens(String caminhosImagens) {
        this.caminhosImagens = caminhosImagens;
    }


}
