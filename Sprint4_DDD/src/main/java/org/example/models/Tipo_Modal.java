package org.example.models;

import java.sql.Timestamp;

public class Tipo_Modal {

    // Atributos
    private int id;
    private String nome;
    private Timestamp dataCadastro;
    private String usuario;




    // Construtor
    public Tipo_Modal(int idTipoModal, String nomeTipoModal, Timestamp dtCadastro, String nomeUsuario) {
        this.id = idTipoModal;
        this.nome = nomeTipoModal;
        this.dataCadastro = dtCadastro;
        this.usuario = nomeUsuario;
    }
    public Tipo_Modal() {}









    // GetterSetter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
}
