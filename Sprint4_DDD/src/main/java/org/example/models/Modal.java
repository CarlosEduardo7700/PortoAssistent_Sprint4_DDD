package org.example.models;

import java.sql.Timestamp;

public class Modal {

    // Atributos
    private int idModal;
    private String caminhaImagem;
    private Tipo_Modal tipoModal; //composição
    private Medida medidaModal; //composição
    private String modeloModal;
    private String placaModal;
    private String marcaModal;
    private int anoModal;
    private Timestamp dtCadastro;
    private String nomeUsuario;



    // Construtor

    public Modal(int idModal, String caminhaImagem, Tipo_Modal tipoModal, Medida medidaModal, String modeloModal, String placaModal, String marcaModal, int anoModal, Timestamp dtCadastro, String nomeUsuario) {
        this.idModal = idModal;
        this.caminhaImagem = caminhaImagem;
        this.tipoModal = tipoModal;
        this.medidaModal = medidaModal;
        this.modeloModal = modeloModal;
        this.placaModal = placaModal;
        this.marcaModal = marcaModal;
        this.anoModal = anoModal;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }

    public Modal() {}






    // GetterSetter
    public int getIdModal() {
        return idModal;
    }

    public void setIdModal(int idModal) {
        this.idModal = idModal;
    }

    public Tipo_Modal getTipoModal() {
        return tipoModal;
    }

    public void setTipoModal(Tipo_Modal tipoModal) {
        this.tipoModal = tipoModal;
    }

    public Medida getMedidaModal() {
        return medidaModal;
    }

    public void setMedidaModal(Medida medidaModal) {
        this.medidaModal = medidaModal;
    }

    public String getModeloModal() {
        return modeloModal;
    }

    public void setModeloModal(String modeloModal) {
        this.modeloModal = modeloModal;
    }

    public String getPlacaModal() {
        return placaModal;
    }

    public void setPlacaModal(String placaModal) {
        this.placaModal = placaModal;
    }

    public String getMarcaModal() {
        return marcaModal;
    }

    public void setMarcaModal(String marcaModal) {
        this.marcaModal = marcaModal;
    }

    public int getAnoModal() {
        return anoModal;
    }

    public void setAnoModal(int anoModal) {
        this.anoModal = anoModal;
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

    public String getCaminhaImagem() {
        return caminhaImagem;
    }

    public void setCaminhaImagem(String caminhaImagem) {
        this.caminhaImagem = caminhaImagem;
    }
}
