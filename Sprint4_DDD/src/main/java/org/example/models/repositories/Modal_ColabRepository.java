package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Modal_Colab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Modal_ColabRepository {
    private ModalRepository modalRepository = new ModalRepository();
    private ColaboradorRepository colaboradorRepository = new ColaboradorRepository();

    public List<Modal_Colab> findAll() throws SQLException {
        List<Modal_Colab> modaisColabs = new ArrayList<Modal_Colab>();
        String query = "SELECT * FROM T_PA_MODAL_COLAB";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Modal_Colab modalColab = new Modal_Colab(
                        modalRepository.find(rs.getInt("ID_MODAL")).orElse(null),
                        colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null)
                );

                modaisColabs.add(modalColab);
            }

            return modaisColabs;
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

    public Optional<Modal_Colab> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_MODAL_COLAB WHERE ID_COLABORADOR = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Modal_Colab modalColab = new Modal_Colab(
                            modalRepository.find(rs.getInt("ID_MODAL")).orElse(null),
                            colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null)
                    );

                    return Optional.ofNullable(modalColab);
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

    public void add(Modal_Colab modalColab) throws SQLException {
        String query = "INSERT INTO T_PA_MODAL_COLAB (ID_COLABORADOR, ID_MODAL) VALUES (?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, modalColab.getColaborador().getId());
            ps.setInt(2, modalColab.getModal().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Modal_Colab modalColab) throws SQLException {
        String query = "UPDATE T_PA_MODAL_COLAB SET ID_MODAL = ? WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, modalColab.getModal().getId());
            ps.setInt(2, modalColab.getColaborador().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_MODAL_COLAB WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
