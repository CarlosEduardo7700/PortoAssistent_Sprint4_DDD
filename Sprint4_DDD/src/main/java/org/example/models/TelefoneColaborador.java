package org.example.models;

import java.sql.Timestamp;

public class TelefoneColaborador {

    // Atributos
    private Colaborador colaborador;
    private String tipo;
    private String numero;
    private String ddd;
    private String ddi;




    // Construtor
    public TelefoneColaborador(Colaborador colaborador, String tipo, String numero, String ddd, String ddi) {
        this.colaborador = colaborador;
        this.tipo = tipo;
        this.numero = numero;
        this.ddd = ddd;
        this.ddi = ddi;
    }

    public TelefoneColaborador() {}






    // GetterSetter

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }
}

