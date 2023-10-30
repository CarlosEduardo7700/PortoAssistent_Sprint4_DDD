package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.TelefoneColaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TelefoneColaboradorRepository {
    private ColaboradorRepository colaboradorRepository = new ColaboradorRepository();

    public List<TelefoneColaborador> findAll() throws SQLException {
        List<TelefoneColaborador> telefonesColaboradores = new ArrayList<TelefoneColaborador>();
        String query = "SELECT * FROM T_PA_TELEFONE_COLABORADOR";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                TelefoneColaborador telefoneColaborador = new TelefoneColaborador(
                        colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null),
                        rs.getString("TP_TELEFONE_COLAB"),
                        rs.getString("NUM_TELEFONE_COLAB"),
                        rs.getString("DDD_TELEFONE_COLAB"),
                        rs.getString("DDI_TELEFONE_COLAB"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                telefonesColaboradores.add(telefoneColaborador);
            }

            return telefonesColaboradores;
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

    public Optional<TelefoneColaborador> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_TELEFONE_COLABORADOR WHERE ID_COLABORADOR = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    TelefoneColaborador telefoneColaborador = new TelefoneColaborador(
                            colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null),
                            rs.getString("TP_TELEFONE_COLAB"),
                            rs.getString("NUM_TELEFONE_COLAB"),
                            rs.getString("DDD_TELEFONE_COLAB"),
                            rs.getString("DDI_TELEFONE_COLAB"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(telefoneColaborador);
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

    public void add(TelefoneColaborador telefoneColaborador) throws SQLException {
        String query = "INSERT INTO T_PA_TELEFONE_COLABORADOR (ID_COLABORADOR, TP_TELEFONE_COLAB, NUM_TELEFONE_COLAB, DDD_TELEFONE_COLAB, DDI_TELEFONE_COLAB, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, telefoneColaborador.getColaborador().getIdColaborador());
            ps.setString(2, telefoneColaborador.getTipoTelefone());
            ps.setString(3, telefoneColaborador.getNumeroTelefone());
            ps.setString(4, telefoneColaborador.getDddTelefone());
            ps.setString(5, telefoneColaborador.getDdiTelefone());
            ps.setTimestamp(6, telefoneColaborador.getDtCadastro());
            ps.setString(7, telefoneColaborador.getNomeUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(TelefoneColaborador telefoneColaborador) throws SQLException {
        String query = "UPDATE T_PA_TELEFONE_COLABORADOR SET TP_TELEFONE_COLAB = ?, NUM_TELEFONE_COLAB = ?, DDD_TELEFONE_COLAB = ?, DDI_TELEFONE_COLAB = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, telefoneColaborador.getTipoTelefone());
            ps.setString(2, telefoneColaborador.getNumeroTelefone());
            ps.setString(3, telefoneColaborador.getDddTelefone());
            ps.setString(4, telefoneColaborador.getDdiTelefone());
            ps.setTimestamp(5, telefoneColaborador.getDtCadastro());
            ps.setString(6, telefoneColaborador.getNomeUsuario());
            ps.setInt(7, telefoneColaborador.getColaborador().getIdColaborador());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_TELEFONE_COLABORADOR WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
