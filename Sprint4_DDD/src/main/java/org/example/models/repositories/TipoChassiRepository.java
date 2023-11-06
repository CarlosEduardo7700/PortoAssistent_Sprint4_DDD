package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.TipoChassi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TipoChassiRepository {
    public List<TipoChassi> findAll() throws SQLException {
        List<TipoChassi> tipos_chassis = new ArrayList<TipoChassi>();
        String query = "SELECT * FROM T_PA_TIPO_CHASSI";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                TipoChassi tipoChassi = new TipoChassi(
                        rs.getInt("ID_TIPO_CHASSI"),
                        rs.getString("NOME_TIPO_CHASSI"),
                        rs.getString("DESC_TIPO_CHASSI")
                );

                tipos_chassis.add(tipoChassi);
            }

            return tipos_chassis;
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

    public Optional<TipoChassi> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_TIPO_CHASSI WHERE ID_TIPO_CHASSI = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    TipoChassi tipoChassi = new TipoChassi(
                            rs.getInt("ID_TIPO_CHASSI"),
                            rs.getString("NOME_TIPO_CHASSI"),
                            rs.getString("DESC_TIPO_CHASSI")
                    );

                    return Optional.ofNullable(tipoChassi);
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

    public void add(TipoChassi tipoChassi) throws SQLException {
        String query = "INSERT INTO T_PA_TIPO_CHASSI (ID_TIPO_CHASSI, NOME_TIPO_CHASSI, DESC_TIPO_CHASSI, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, tipoChassi.getId());
            ps.setString(2, tipoChassi.getNome());
            ps.setString(3, tipoChassi.getDescricao());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(TipoChassi tipoChassi) throws SQLException {
        String query = "UPDATE T_PA_TIPO_CHASSI SET NOME_TIPO_CHASSI = ?, DESC_TIPO_CHASSI = ? WHERE ID_TIPO_CHASSI = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, tipoChassi.getNome());
            ps.setString(2, tipoChassi.getDescricao());
            ps.setInt(3, tipoChassi.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_TIPO_CHASSI WHERE ID_TIPO_CHASSI = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
