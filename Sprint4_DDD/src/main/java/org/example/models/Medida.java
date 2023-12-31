package org.example.models;

import java.sql.Timestamp;

public class Medida {

    //Atributos
    private int id;
    private double altura;
    private double largura;
    private double comprimento;
    private double pesoVeiculo;
    private double pesoSuportadoModal;




    //Construtor

    public Medida(int id, double altura, double largura, double comprimento, double pesoVeiculo, double pesoSuportadoModal) {
        this.id = id;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.pesoVeiculo = pesoVeiculo;
        this.pesoSuportadoModal = pesoSuportadoModal;
    }

    public Medida() {}









    // GetterSetter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
