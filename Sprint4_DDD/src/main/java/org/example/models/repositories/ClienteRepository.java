package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {
    private GeneroRepository generoRepository = new GeneroRepository();

    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<Cliente>();
        String query = "SELECT * FROM T_PA_CLIENTE";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Cliente cliente = new Cliente(
                        rs.getInt("ID_CLIENTE"),
                        rs.getString("IMG_CLIENTE"),
                        generoRepository.find(rs.getInt("ID_GENERO")).orElse(null),
                        rs.getString("NOME_CLIENTE"),
                        rs.getString("CPF_CLIENTE"),
                        rs.getString("RG_CLIENTE"),
                        rs.getTimestamp("DT_NASCIMENTO_CLIENTE"),
                        rs.getString("CNH_CLIENTE"),
                        rs.getString("EMAIL_CLIENTE"),
                        rs.getString("SENHA_CLIENTE"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                clientes.add(cliente);
            }

            return clientes;
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

    public Optional<Cliente> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_CLIENTE WHERE ID_CLIENTE = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("ID_CLIENTE"),
                            rs.getString("IMG_CLIENTE"),
                            generoRepository.find(rs.getInt("ID_GENERO")).orElse(null),
                            rs.getString("NOME_CLIENTE"),
                            rs.getString("CPF_CLIENTE"),
                            rs.getString("RG_CLIENTE"),
                            rs.getTimestamp("DT_NASCIMENTO_CLIENTE"),
                            rs.getString("CNH_CLIENTE"),
                            rs.getString("EMAIL_CLIENTE"),
                            rs.getString("SENHA_CLIENTE"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(cliente);
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

    public void add(Cliente cliente) throws SQLException {
        String query = "INSERT INTO T_PA_CLIENTE (ID_CLIENTE, IMG_CLIENTE, ID_GENERO, NM_CLIENTE, CPF_CLIENTE, RG_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE, CNH_CLIENTE, DT_NASCIMENTO_CLIENTE, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getCaminhoImagem());
            ps.setInt(3, cliente.getGenero().getId());
            ps.setString(4, cliente.getCliente());
            ps.setString(5, cliente.getCpf());
            ps.setString(6, cliente.getRg());
            ps.setString(7, cliente.getEmail());
            ps.setString(8, cliente.getSenha());
            ps.setString(9, cliente.getCnh());
            ps.setTimestamp(10, cliente.getDataNascimento());
            ps.setTimestamp(11, cliente.getDataCadastro());
            ps.setString(12, cliente.getUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Cliente cliente) throws SQLException {
        String query = "UPDATE T_PA_CLIENTE SET IMG_CLIENTE = ?, ID_GENERO = ?, NM_CLIENTE = ?, CPF_CLIENTE = ?, RG_CLIENTE = ?, EMAIL_CLIENTE = ?, SENHA_CLIENTE = ?, CNH_CLIENTE = ?, DT_NASCIMENTO_CLIENTE = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, cliente.getCaminhoImagem());
            ps.setInt(2, cliente.getGenero().getId());
            ps.setString(3, cliente.getCliente());
            ps.setString(4, cliente.getCpf());
            ps.setString(5, cliente.getRg());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getSenha());
            ps.setString(8, cliente.getCnh());
            ps.setTimestamp(9, cliente.getDataNascimento());
            ps.setTimestamp(10, cliente.getDataCadastro());
            ps.setString(11, cliente.getUsuario());
            ps.setInt(12, cliente.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_CLIENTE WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
