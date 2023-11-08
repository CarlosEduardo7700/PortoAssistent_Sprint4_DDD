package org.example.models.repositories;

import org.example.infrastructure.database.DataBaseFactory;
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
                        rs.getInt("NUM_TELEFONE_COLAB"),
                        rs.getInt("DDD_TELEFONE_COLAB"),
                        rs.getString("DDI_TELEFONE_COLAB")
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
                            rs.getInt("NUM_TELEFONE_COLAB"),
                            rs.getInt("DDD_TELEFONE_COLAB"),
                            rs.getString("DDI_TELEFONE_COLAB")
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
        String query = "INSERT INTO T_PA_TELEFONE_COLABORADOR (ID_COLABORADOR, TP_TELEFONE_COLAB, NUM_TELEFONE_COLAB, DDD_TELEFONE_COLAB, DDI_TELEFONE_COLAB, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, telefoneColaborador.getColaborador().getId());
            ps.setString(2, telefoneColaborador.getTipo());
            ps.setInt(3, telefoneColaborador.getNumero());
            ps.setInt(4, telefoneColaborador.getDdd());
            ps.setString(5, telefoneColaborador.getDdi());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(TelefoneColaborador telefoneColaborador) throws SQLException {
        String query = "UPDATE T_PA_TELEFONE_COLABORADOR SET TP_TELEFONE_COLAB = ?, NUM_TELEFONE_COLAB = ?, DDD_TELEFONE_COLAB = ?, DDI_TELEFONE_COLAB = ? WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, telefoneColaborador.getTipo());
            ps.setInt(2, telefoneColaborador.getNumero());
            ps.setInt(3, telefoneColaborador.getDdd());
            ps.setString(4, telefoneColaborador.getDdi());
            ps.setInt(5, telefoneColaborador.getColaborador().getId());

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
