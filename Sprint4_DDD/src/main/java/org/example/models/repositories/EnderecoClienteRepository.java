package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.EnderecoCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoClienteRepository {
    private ClienteRepository clienteRepository = new ClienteRepository();
    private LogradouroRepository logradouroRepository = new LogradouroRepository();

    public List<EnderecoCliente> findAll() throws SQLException {
        List<EnderecoCliente> enderecosClientes = new ArrayList<EnderecoCliente>();
        String query = "SELECT * FROM T_PA_ENDERECO_CLIENTE";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                EnderecoCliente enderecoCliente = new EnderecoCliente(
                        clienteRepository.find(rs.getInt("T_PA_CLIENTE_ID_CLIENTE")).orElse(null),
                        logradouroRepository.find(rs.getInt("ID_LOGRADOURO")).orElse(null),
                        rs.getInt("NR_LOGRADOURO"),
                        rs.getString("DS_LOGRADOURO")
                );

                enderecosClientes.add(enderecoCliente);
            }

            return enderecosClientes;
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

    public Optional<EnderecoCliente> findByCliente(int idCliente) throws SQLException {
        String query = "SELECT * FROM T_PA_ENDERECO_CLIENTE WHERE T_PA_CLIENTE_ID_CLIENTE = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, idCliente);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    EnderecoCliente enderecoCliente = new EnderecoCliente(
                            clienteRepository.find(rs.getInt("T_PA_CLIENTE_ID_CLIENTE")).orElse(null),
                            logradouroRepository.find(rs.getInt("ID_LOGRADOURO")).orElse(null),
                            rs.getInt("NR_LOGRADOURO"),
                            rs.getString("DS_LOGRADOURO")
                    );

                    return Optional.ofNullable(enderecoCliente);
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

    public void add(EnderecoCliente enderecoCliente) throws SQLException {
        String query = "INSERT INTO T_PA_ENDERECO_CLIENTE (T_PA_CLIENTE_ID_CLIENTE, ID_LOGRADOURO, NR_LOGRADOURO, DS_LOGRADOURO, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, enderecoCliente.getCliente().getId());
            ps.setInt(2, enderecoCliente.getLogradouro().getId());
            ps.setInt(3, enderecoCliente.getNumLogradouro());
            ps.setString(4, enderecoCliente.getDescLogradouro());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void updateByIdCliente(EnderecoCliente enderecoCliente) throws SQLException {
        String query = "UPDATE T_PA_ENDERECO_CLIENTE SET ID_LOGRADOURO = ?, NR_LOGRADOURO = ?, DS_LOGRADOURO = ? WHERE T_PA_CLIENTE_ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, enderecoCliente.getLogradouro().getId());
            ps.setInt(2, enderecoCliente.getNumLogradouro());
            ps.setString(3, enderecoCliente.getDescLogradouro());
            ps.setInt(4, enderecoCliente.getCliente().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void deleteByIdCliente(int idCliente) throws SQLException {
        String query = "DELETE FROM T_PA_ENDERECO_CLIENTE WHERE T_PA_CLIENTE_ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, idCliente);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
