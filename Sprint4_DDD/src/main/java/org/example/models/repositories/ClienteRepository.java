package org.example.models.repositories;

import org.example.infrastructure.database.DataBaseFactory;
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
                        rs.getLong("CPF_CLIENTE"),
                        rs.getLong("RG_CLIENTE"),
                        rs.getString("DT_NASCIMENTO_CLIENTE"),
                        rs.getString("CNH_CLIENTE"),
                        rs.getString("EMAIL_CLIENTE"),
                        rs.getString("SENHA_CLIENTE")
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
                            rs.getLong("CPF_CLIENTE"),
                            rs.getLong("RG_CLIENTE"),
                            rs.getString("DT_NASCIMENTO_CLIENTE"),
                            rs.getString("CNH_CLIENTE"),
                            rs.getString("EMAIL_CLIENTE"),
                            rs.getString("SENHA_CLIENTE")
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

    public Optional<Cliente> findByEmail(String email) throws SQLException {
        String query = "SELECT * FROM T_PA_CLIENTE WHERE EMAIL_CLIENTE = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setString(1, email);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("ID_CLIENTE"),
                            rs.getString("IMG_CLIENTE"),
                            generoRepository.find(rs.getInt("ID_GENERO")).orElse(null),
                            rs.getString("NOME_CLIENTE"),
                            rs.getLong("CPF_CLIENTE"),
                            rs.getLong("RG_CLIENTE"),
                            rs.getString("DT_NASCIMENTO_CLIENTE"),
                            rs.getString("CNH_CLIENTE"),
                            rs.getString("EMAIL_CLIENTE"),
                            rs.getString("SENHA_CLIENTE")
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
        String query = "INSERT INTO T_PA_CLIENTE (ID_CLIENTE, IMG_CLIENTE, ID_GENERO, NOME_CLIENTE, CPF_CLIENTE, RG_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE, CNH_CLIENTE, DT_NASCIMENTO_CLIENTE, DT_CADASTRO, NM_USUARIO) VALUES (SQ_PA_CLIENTE.nextval, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, cliente.getCaminhoImagem());
            ps.setInt(2, cliente.getGenero().getId());
            ps.setString(3, cliente.getNome());
            ps.setLong(4, cliente.getCpf());
            ps.setLong(5, cliente.getRg());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getSenha());
            ps.setString(8, cliente.getCnh());
            ps.setString(9, cliente.getDataNascimento());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Cliente cliente) throws SQLException {
        String query = "UPDATE T_PA_CLIENTE SET IMG_CLIENTE = ?, ID_GENERO = ?, NOME_CLIENTE = ?, CPF_CLIENTE = ?, RG_CLIENTE = ?, EMAIL_CLIENTE = ?, SENHA_CLIENTE = ?, CNH_CLIENTE = ?, DT_NASCIMENTO_CLIENTE = TO_DATE(?, 'DD/MM/YYYY') WHERE ID_CLIENTE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, cliente.getCaminhoImagem());
            ps.setInt(2, cliente.getGenero().getId());
            ps.setString(3, cliente.getNome());
            ps.setLong(4, cliente.getCpf());
            ps.setLong(5, cliente.getRg());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getSenha());
            ps.setString(8, cliente.getCnh());
            ps.setString(9, cliente.getDataNascimento());
            ps.setInt(10, cliente.getId());

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
