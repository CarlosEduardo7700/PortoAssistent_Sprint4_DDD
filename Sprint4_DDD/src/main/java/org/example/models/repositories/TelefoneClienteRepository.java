package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Bairro;
import org.example.models.Cliente;
import org.example.models.TelefoneCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TelefoneClienteRepository {
    private ClienteRepository clienteRepository = new ClienteRepository();

    public List<TelefoneCliente> findAll() throws SQLException {
        List<TelefoneCliente> telefonesClientes = new ArrayList<TelefoneCliente>();
        String query = "SELECT * FROM T_PA_TELEFONE_CLIENTE";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                TelefoneCliente telefoneCliente = new TelefoneCliente(
                        clienteRepository.find(rs.getInt("ID_CLIENTE")).orElse(null),
                        rs.getString("TP_TELEFONE_CLIE"),
                        rs.getString("NUM_TELEFONE_CLIE"),
                        rs.getString("DDD_TELEFONE_CLIE"),
                        rs.getString("DDI_TELEFONE_CLIE"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                telefonesClientes.add(telefoneCliente);
            }

            return telefonesClientes;
        }
        catch (SQLException e) {
            if(e.getErrorCode() == 1017) {
                throw new SQLException("Falha de autenticação ao conectar ao banco de dados.", e);
            } else if(e.getErrorCode() == 904) {
                throw new SQLException("A query contém uma coluna inválida.", e);
            } else {
                throw new SQLException("Erro ao executar a query.", e);
            }
        }
    }

    public Optional<TelefoneCliente> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_TELEFONE_CLIENTE WHERE ID_CLIENTE = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    TelefoneCliente telefoneCliente = new TelefoneCliente(
                            clienteRepository.find(rs.getInt("ID_CLIENTE")).orElse(null),
                            rs.getString("TP_TELEFONE_CLIE"),
                            rs.getString("NUM_TELEFONE_CLIE"),
                            rs.getString("DDD_TELEFONE_CLIE"),
                            rs.getString("DDI_TELEFONE_CLIE"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(telefoneCliente);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        catch (SQLException e) {
            if(e.getErrorCode() == 1017) { // Erro de login/senha inválido
                throw new SQLException("Falha de autenticação ao conectar ao banco de dados.", e);
            } else if(e.getErrorCode() == 904) { // Erro de coluna inválida
                throw new SQLException("A query contém uma coluna inválida.", e);
            } else {
                throw new SQLException("Erro ao executar a query.", e);
            }
        }
        return Optional.empty();
    }

    public void add(TelefoneCliente telefoneCliente) throws SQLException {
        String query = "INSERT INTO T_PA_TELEFONE_CLIENTE (ID_CLIENTE, TP_TELEFONE_CLIE, NUM_TELEFONE_CLIE, DDD_TELEFONE_CLIE, DDI_TELEFONE_CLIE, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, telefoneCliente.getCliente().getIdCliente());
            ps.setString(2, telefoneCliente.getTipoTelefone());
            ps.setString(3, telefoneCliente.getNumeroTelefone());
            ps.setString(4, telefoneCliente.getDddTelefone());
            ps.setString(5, telefoneCliente.getDdiTelefone());
            ps.setTimestamp(6, telefoneCliente.getDtCadastro());
            ps.setString(7, telefoneCliente.getNomeUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(TelefoneCliente telefoneCliente) throws SQLException {
        String query = "UPDATE T_PA_TELEFONE_CLIENTE SET TP_TELEFONE_CLIE = ?, NUM_TELEFONE_CLIE = ?, DDD_TELEFONE_CLIE = ?, DDI_TELEFONE_CLIE = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, telefoneCliente.getTipoTelefone());
            ps.setString(2, telefoneCliente.getNumeroTelefone());
            ps.setString(3, telefoneCliente.getDddTelefone());
            ps.setString(4, telefoneCliente.getDdiTelefone());
            ps.setTimestamp(5, telefoneCliente.getDtCadastro());
            ps.setString(6, telefoneCliente.getNomeUsuario());
            ps.setInt(7, telefoneCliente.getCliente().getIdCliente());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_TELEFONE_CLIENTE WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
