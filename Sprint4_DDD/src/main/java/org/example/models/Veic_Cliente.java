package org.example.models;

public class Veic_Cliente {
    private Cliente idCliente;
    private Veiculo idVeiculo;

    public Veic_Cliente(Cliente idCliente, Veiculo idVeiculo) {
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Veiculo getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Veiculo idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}
