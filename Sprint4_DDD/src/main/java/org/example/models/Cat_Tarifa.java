package org.example.models;

import java.util.Date;
import java.util.List;

public class Cat_Tarifa {

    // Atributos
    private int idCatTarifa;
    private String nomeCategoria;
    private String descricaoCategoria;
    private double valorCategoria;
    private Date dtCadastro;
    private String nomeUsuario;





    // Construtores
    public Cat_Tarifa(int idCatTarifa, String nomeCategoria, String descricaoCategoria, double valorCategoria, Date dtCadastro, String nomeUsuario) {
        this.idCatTarifa = idCatTarifa;
        this.nomeCategoria = nomeCategoria;
        this.descricaoCategoria = descricaoCategoria;
        this.valorCategoria = valorCategoria;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Cat_Tarifa() {}








    // GetterSetter
    public int getIdCatTarifa() {
        return idCatTarifa;
    }

    public void setIdCatTarifa(int idCatTarifa) {
        this.idCatTarifa = idCatTarifa;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public double getValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(double valorCategoria) {
        this.valorCategoria = valorCategoria;
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
