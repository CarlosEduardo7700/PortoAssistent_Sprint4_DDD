package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Tipo_Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tipo_ModalRepository {
    public List<Tipo_Modal> findAll() throws SQLException {
        List<Tipo_Modal> tipos_modais = new ArrayList<Tipo_Modal>();
        String query = "SELECT * FROM T_PA_TIPO_MODAL";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Tipo_Modal tipoModal = new Tipo_Modal(
                        rs.getInt("ID_TIPO_MODAL"),
                        rs.getString("NM_TIPO_MODAL")
                );

                tipos_modais.add(tipoModal);
            }

            return tipos_modais;
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

    public Optional<Tipo_Modal> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_TIPO_MODAL WHERE ID_TIPO_MODAL = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Tipo_Modal tipoModal = new Tipo_Modal(
                            rs.getInt("ID_TIPO_MODAL"),
                            rs.getString("NM_TIPO_MODAL")
                    );

                    return Optional.ofNullable(tipoModal);
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

    public void add(Tipo_Modal tipoModal) throws SQLException {
        String query = "INSERT INTO T_PA_TIPO_MODAL (ID_TIPO_MODAL, NM_TIPO_MODAL, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, tipoModal.getId());
            ps.setString(2, tipoModal.getNome());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Tipo_Modal tipoModal) throws SQLException {
        String query = "UPDATE T_PA_TIPO_MODAL SET NM_TIPO_MODAL = ? WHERE ID_TIPO_MODAL = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, tipoModal.getNome());
            ps.setInt(2, tipoModal.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_TIPO_MODAL WHERE ID_TIPO_MODAL = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
