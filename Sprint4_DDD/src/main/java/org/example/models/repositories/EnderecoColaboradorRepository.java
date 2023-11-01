package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.EnderecoColaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoColaboradorRepository {
    private ColaboradorRepository colaboradorRepository = new ColaboradorRepository();
    private LogradouroRepository logradouroRepository = new LogradouroRepository();

    public List<EnderecoColaborador> findAll() throws SQLException {
        List<EnderecoColaborador> enderecosColaboradores = new ArrayList<EnderecoColaborador>();
        String query = "SELECT * FROM T_PA_ENDERECO_COLABORADOR";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                EnderecoColaborador enderecoColaborador = new EnderecoColaborador(
                        colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null),
                        logradouroRepository.find(rs.getInt("ID_LOGRADOURO")).orElse(null),
                        rs.getInt("NR_LOGRADOURO"),
                        rs.getString("DS_LOGRADOURO")
                );

                enderecosColaboradores.add(enderecoColaborador);
            }

            return enderecosColaboradores;
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

    public Optional<EnderecoColaborador> findByColaborador(int idColaborador) throws SQLException {
        String query = "SELECT * FROM T_PA_ENDERECO_COLABORADOR WHERE ID_COLABORADOR = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, idColaborador);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    EnderecoColaborador enderecoColaborador = new EnderecoColaborador(
                            colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null),
                            logradouroRepository.find(rs.getInt("ID_LOGRADOURO")).orElse(null),
                            rs.getInt("NR_LOGRADOURO"),
                            rs.getString("DS_LOGRADOURO")
                    );

                    return Optional.ofNullable(enderecoColaborador);
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


    public void add(EnderecoColaborador enderecoColaborador) throws SQLException {
        String query = "INSERT INTO T_PA_ENDERECO_COLABORADOR (ID_COLABORADOR, ID_LOGRADOURO, NR_LOGRADOURO, DS_LOGRADOURO, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, enderecoColaborador.getColaborador().getId());
            ps.setInt(2, enderecoColaborador.getLogradouro().getId());
            ps.setInt(3, enderecoColaborador.getNumLogradouro());
            ps.setString(4, enderecoColaborador.getDescLogradouro());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void updateByIdColaborador(EnderecoColaborador enderecoColaborador) throws SQLException {
        String query = "UPDATE T_PA_ENDERECO_COLABORADOR SET ID_LOGRADOURO = ?, NR_LOGRADOURO = ?, DS_LOGRADOURO = ? WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, enderecoColaborador.getLogradouro().getId());
            ps.setInt(2, enderecoColaborador.getNumLogradouro());
            ps.setString(3, enderecoColaborador.getDescLogradouro());
            ps.setInt(4, enderecoColaborador.getColaborador().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void deleteByIdColaborador(int idColaborador) throws SQLException {
        String query = "DELETE FROM T_PA_ENDERECO_COLABORADOR WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, idColaborador);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
