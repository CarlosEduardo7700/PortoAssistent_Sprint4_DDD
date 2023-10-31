package org.example.models;

import java.sql.Timestamp;

public class Veiculo {

    // Atributos
    private int id;
    private String caminhoImagem;
    private Tipo_Eixo tipoEixo;
    private Tipo_Chassi tipoChassi;
    private Medida medidaVeiculo;
    private int apolice;
    private String modelo;
    private String cor;
    private String marca;
    private String placa;
    private int anoFabricacao;
    private int quantidadeEixos;
    private String renavan;
    private int numChassi;
    private Timestamp dataCadastro;
    private String usuario;




    // Construtor


    public Veiculo(int idVeiculo, String caminhoImagem, Tipo_Eixo tipoEixo, Tipo_Chassi tipoChassi, Medida medidaVeiculo, int apolice, String modelo, String cor, String marca, String placa, int anoFabricacao, int quantidadeEixos, String renavan, int numChassi, Timestamp dtCadastro, String nomeUsuario) {
        this.id = idVeiculo;
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
        this.dataCadastro = dtCadastro;
        this.usuario = nomeUsuario;
    }

    public Veiculo() {}










    // GetterSetter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Tipo_Eixo getTipoEixo() {
        return tipoEixo;
    }
    public void setTipoEixo(Tipo_Eixo tipoEixo) {
        this.tipoEixo = tipoEixo;
    }

    public Tipo_Chassi getTipoChassi() {
        return tipoChassi;
    }
    public void setTipoChassi(Tipo_Chassi tipoChassi) {
        this.tipoChassi = tipoChassi;
    }

    public Medida getMedidaVeiculo() {
        return medidaVeiculo;
    }
    public void setMedidaVeiculo(Medida medidaVeiculo) {
        this.medidaVeiculo = medidaVeiculo;
    }

    public int getApolice() {
        return apolice;
    }
    public void setApolice(int apolice) {
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

    public String getCaminhoImagem() {
        return caminhoImagem;
    }
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public int getNumChassi() {
        return numChassi;
    }
    public void setNumChassi(int numChassi) {
        this.numChassi = numChassi;
    }
}
