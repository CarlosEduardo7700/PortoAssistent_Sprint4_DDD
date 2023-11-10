package org.example.models;

public class Veiculo {

    // Atributos
    private int id;
    private String caminhoImagem;
    private TipoEixo tipoEixo;
    private TipoChassi tipoChassi;
    private Medida medidaVeiculo;
    private Long apolice;
    private String modelo;
    private String cor;
    private String marca;
    private String placa;
    private int anoFabricacao;
    private int quantidadeEixos;
    private String renavan;
    private Long numChassi;




    // Construtor


    public Veiculo(int id, String caminhoImagem, TipoEixo tipoEixo, TipoChassi tipoChassi, Medida medidaVeiculo, Long apolice, String modelo, String cor, String marca, String placa, int anoFabricacao, int quantidadeEixos, String renavan, Long numChassi) {
        this.id = id;
        this.caminhoImagem = caminhoImagem;
        this.tipoEixo = tipoEixo;
        this.tipoChassi = tipoChassi;
        this.medidaVeiculo = medidaVeiculo;
        this.apolice = apolice;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.quantidadeEixos = quantidadeEixos;
        this.renavan = renavan;
        this.numChassi = numChassi;
    }

    public Veiculo() {}










    // GetterSetter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public TipoEixo getTipoEixo() {
        return tipoEixo;
    }
    public void setTipoEixo(TipoEixo tipoEixo) {
        this.tipoEixo = tipoEixo;
    }

    public TipoChassi getTipoChassi() {
        return tipoChassi;
    }
    public void setTipoChassi(TipoChassi tipoChassi) {
        this.tipoChassi = tipoChassi;
    }

    public Medida getMedidaVeiculo() {
        return medidaVeiculo;
    }
    public void setMedidaVeiculo(Medida medidaVeiculo) {
        this.medidaVeiculo = medidaVeiculo;
    }

    public Long getApolice() {
        return apolice;
    }
    public void setApolice(Long apolice) {
        this.apolice = apolice;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getQuantidadeEixos() {
        return quantidadeEixos;
    }
    public void setQuantidadeEixos(int quantidadeEixos) {
        this.quantidadeEixos = quantidadeEixos;
    }

    public String getRenavan() {
        return renavan;
    }
    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Long getNumChassi() {
        return numChassi;
    }
    public void setNumChassi(Long numChassi) {
        this.numChassi = numChassi;
    }
}
