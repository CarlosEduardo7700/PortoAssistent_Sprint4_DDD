package org.example.models;

import java.util.Date;
import java.util.List;

public class Medida {

    //Atributos
    private int idMedida;
    private double altura;
    private double largura;
    private double comprimento;
    private double pesoVeiculo;
    private double pesoSuportadoModal;
    private Date dtCadastro;
    private String nomeUsuario;




    //Construtor
    public Medida(int idMedida, double altura, double largura, double comprimento, double pesoVeiculo, double pesoSuportadoModal, Date dtCadastro, String nomeUsuario) {
        this.idMedida = idMedida;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.pesoVeiculo = pesoVeiculo;
        this.pesoSuportadoModal = pesoSuportadoModal;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Medida() {}









    // GetterSetter
    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getPesoVeiculo() {
        return pesoVeiculo;
    }

    public void setPesoVeiculo(double pesoVeiculo) {
        this.pesoVeiculo = pesoVeiculo;
    }

    public double getPesoSuportadoModal() {
        return pesoSuportadoModal;
    }

    public void setPesoSuportadoModal(double pesoSuportadoModal) {
        this.pesoSuportadoModal = pesoSuportadoModal;
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
