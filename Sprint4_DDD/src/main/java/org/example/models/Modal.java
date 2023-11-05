package org.example.models;

public class Modal {

    // Atributos
    private int id;
    private String caminhoImagem;
    private Tipo_Modal tipoModal;
    private Medida medidaModal;
    private String modelo;
    private String placa;
    private String marca;
    private int anoFabricacao;



    // Construtor


    public Modal(int id, String caminhoImagem, Tipo_Modal tipoModal, Medida medidaModal, String modelo, String placa, String marca, int anoFabricacao) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
        this.tipoModal = tipoModal;
        this.medidaModal = medidaModal;
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
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

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
