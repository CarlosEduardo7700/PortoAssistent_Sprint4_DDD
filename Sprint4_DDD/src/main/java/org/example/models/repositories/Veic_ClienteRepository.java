package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Veic_Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Veic_ClienteRepository {
    private VeiculoRepository veiculoRepository = new VeiculoRepository();
    private ClienteRepository clienteRepository = new ClienteRepository();

    public List<Veic_Cliente> findAll() throws SQLException {
        List<Veic_Cliente> veicClientes = new ArrayList<Veic_Cliente>();
        String query = "SELECT * FROM T_PA_VEIC_CLIENT";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Veic_Cliente veicCliente = new Veic_Cliente(
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

    public Optional<Veic_Cliente> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_VEIC_CLIENT WHERE ID_CLIENTE = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Veic_Cliente veicCliente = new Veic_Cliente(
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

    public void add(Veic_Cliente veicCliente) throws SQLException {
        String query = "INSERT INTO T_PA_VEIC_CLIENT (ID_CLIENTE, ID_VEICULO) VALUES (?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, veicCliente.getIdCliente().getIdCliente());
            ps.setInt(2, veicCliente.getIdVeiculo().getIdVeiculo());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Veic_Cliente veicCliente) throws SQLException {
        String query = "UPDATE T_PA_VEIC_CLIENT SET ID_VEICULO = ? WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, veicCliente.getIdVeiculo().getIdVeiculo());
            ps.setInt(2, veicCliente.getIdCliente().getIdCliente());

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
