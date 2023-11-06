package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.VeicCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeicClienteRepository {
    private VeiculoRepository veiculoRepository = new VeiculoRepository();
    private ClienteRepository clienteRepository = new ClienteRepository();

    public List<VeicCliente> findAll() throws SQLException {
        List<VeicCliente> veicClientes = new ArrayList<VeicCliente>();
        String query = "SELECT * FROM T_PA_VEIC_CLIENT";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                VeicCliente veicCliente = new VeicCliente(
                        clienteRepository.find(rs.getInt("ID_CLIENTE")).orElse(null),
                        veiculoRepository.find(rs.getInt("ID_VEICULO")).orElse(null)
                );

                veicClientes.add(veicCliente);
            }

            return veicClientes;
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

    public Optional<VeicCliente> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_VEIC_CLIENT WHERE ID_CLIENTE = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    VeicCliente veicCliente = new VeicCliente(
                            clienteRepository.find(rs.getInt("ID_CLIENTE")).orElse(null),
                            veiculoRepository.find(rs.getInt("ID_VEICULO")).orElse(null)
                    );

                    return Optional.ofNullable(veicCliente);
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

    public void add(VeicCliente veicCliente) throws SQLException {
        String query = "INSERT INTO T_PA_VEIC_CLIENT (ID_CLIENTE, ID_VEICULO) VALUES (?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, veicCliente.getCliente().getId());
            ps.setInt(2, veicCliente.getVeiculo().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(VeicCliente veicCliente) throws SQLException {
        String query = "UPDATE T_PA_VEIC_CLIENT SET ID_VEICULO = ? WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, veicCliente.getVeiculo().getId());
            ps.setInt(2, veicCliente.getCliente().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_VEIC_CLIENT WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
