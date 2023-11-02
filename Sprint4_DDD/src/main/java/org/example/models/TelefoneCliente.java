package org.example.models;

import java.sql.Timestamp;

public class TelefoneCliente {

    // Atributos
    private Cliente cliente;
    private String tipo;
    private int numero;
    private int ddd;
    private String ddi;




    // Construtor


    public TelefoneCliente(Cliente cliente, String tipo, int numero, int ddd, String ddi) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.numero = numero;
        this.ddd = ddd;
        this.ddi = ddi;
    }

    public TelefoneCliente() {}






    // GetterSetter
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

}

