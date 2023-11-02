package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
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
                        rs.getInt("NUM_TELEFONE_CLIE"),
                        rs.getInt("DDD_TELEFONE_CLIE"),
                        rs.getString("DDI_TELEFONE_CLIE")
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
                            rs.getInt("NUM_TELEFONE_CLIE"),
                            rs.getInt("DDD_TELEFONE_CLIE"),
                            rs.getString("DDI_TELEFONE_CLIE")
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
        String query = "INSERT INTO T_PA_TELEFONE_CLIENTE (ID_CLIENTE, TP_TELEFONE_CLIE, NUM_TELEFONE_CLIE, DDD_TELEFONE_CLIE, DDI_TELEFONE_CLIE, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, telefoneCliente.getCliente().getId());
            ps.setString(2, telefoneCliente.getTipo());
            ps.setInt(3, telefoneCliente.getNumero());
            ps.setInt(4, telefoneCliente.getDdd());
            ps.setString(5, telefoneCliente.getDdi());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(TelefoneCliente telefoneCliente) throws SQLException {
        String query = "UPDATE T_PA_TELEFONE_CLIENTE SET TP_TELEFONE_CLIE = ?, NUM_TELEFONE_CLIE = ?, DDD_TELEFONE_CLIE = ?, DDI_TELEFONE_CLIE = ? WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, telefoneCliente.getTipo());
            ps.setInt(2, telefoneCliente.getNumero());
            ps.setInt(3, telefoneCliente.getDdd());
            ps.setString(4, telefoneCliente.getDdi());
            ps.setInt(5, telefoneCliente.getCliente().getId());

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
