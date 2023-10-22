package org.example.models;

import java.util.Date;
import java.util.List;

public class Tipo_Modal {

    // Atributos
    private int idTipoModal;
    private String nomeTipoModal;
    private Date dtCadastro;
    private String nomeUsuario;




    // Construtor
    public Tipo_Modal(int idTipoModal, String nomeTipoModal, Date dtCadastro, String nomeUsuario) {
        this.idTipoModal = idTipoModal;
        this.nomeTipoModal = nomeTipoModal;
        this.dtCadastro = dtCadastro;
        this.nomeUsuario = nomeUsuario;
    }
    public Tipo_Modal() {}









    // GetterSetter
    public int getIdTipoModal() {
        return idTipoModal;
    }
    public void setIdTipoModal(int idTipoModal) {
        this.idTipoModal = idTipoModal;
    }

    public String getNomeTipoModal() {
        return nomeTipoModal;
    }
    public void setNomeTipoModal(String nomeTipoModal) {
        this.nomeTipoModal = nomeTipoModal;
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
