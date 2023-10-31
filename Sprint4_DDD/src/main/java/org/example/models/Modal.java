package org.example.models;

import java.sql.Timestamp;

public class Modal {

    // Atributos
    private int id;
    private String caminhaImagem;
    private Tipo_Modal tipoModal;
    private Medida medidaModal;
    private String modelo;
    private String placa;
    private String marca;
    private int anoFabricacao;
    private Timestamp dataCadastro;
    private String usuario;



    // Construtor

    public Modal(int id, String caminhaImagem, Tipo_Modal tipoModal, Medida medidaModal, String modelo, String placa, String marca, int anoFabricacao, Timestamp dataCadastro, String usuario) {
        this.id = id;
        this.caminhaImagem = caminhaImagem;
        this.tipoModal = tipoModal;
        this.medidaModal = medidaModal;
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
    }

    public Modal() {}






    // GetterSetter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
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

    public String getCaminhaImagem() {
        return caminhaImagem;
    }

    public void setCaminhaImagem(String caminhaImagem) {
        this.caminhaImagem = caminhaImagem;
    }
}
