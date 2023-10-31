package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModalRepository {
    private Tipo_ModalRepository tipoModalRepository = new Tipo_ModalRepository();
    private MedidaRepository medidaRepository = new MedidaRepository();

    public List<Modal> findAll() throws SQLException {
        List<Modal> modais = new ArrayList<Modal>();
        String query = "SELECT * FROM T_PA_MODAL";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Modal modal = new Modal(
                        rs.getInt("ID_MODAL"),
                        rs.getString("IMG_MODAL"),
                        tipoModalRepository.find(rs.getInt("ID_TIPO_MODAL")).orElse(null),
                        medidaRepository.find(rs.getInt("ID_MEDIDA")).orElse(null),
                        rs.getString("MODELO_MODAL"),
                        rs.getString("PLACA_MODAL"),
                        rs.getString("MARCA_MODAL"),
                        rs.getInt("ANO_MODAL"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                modais.add(modal);
            }

            return modais;
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

    public Optional<Modal> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_MODAL WHERE ID_MODAL = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Modal modal = new Modal(
                            rs.getInt("ID_MODAL"),
                            rs.getString("IMG_MODAL"),
                            tipoModalRepository.find(rs.getInt("ID_TIPO_MODAL")).orElse(null),
                            medidaRepository.find(rs.getInt("ID_MEDIDA")).orElse(null),
                            rs.getString("MODELO_MODAL"),
                            rs.getString("PLACA_MODAL"),
                            rs.getString("MARCA_MODAL"),
                            rs.getInt("ANO_MODAL"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(modal);
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

    public void add(Modal modal) throws SQLException {
        String query = "INSERT INTO T_PA_MODAL (ID_MODAL, IMG_MODAL, ID_TIPO_MODAL, ID_MEDIDA, MODELO_MODAL, PLACA_MODAL, MARCA_MODAL, ANO_MODAL, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, modal.getId());
            ps.setString(2, modal.getCaminhaImagem());
            ps.setInt(3, modal.getTipoModal().getId());
            ps.setInt(4, modal.getMedidaModal().getId());
            ps.setString(5, modal.getModelo());
            ps.setString(6, modal.getPlaca());
            ps.setString(7, modal.getMarca());
            ps.setInt(8, modal.getAnoFabricacao());
            ps.setTimestamp(9, modal.getDataCadastro());
            ps.setString(10, modal.getUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Modal modal) throws SQLException {
        String query = "UPDATE T_PA_MODAL SET IMG_MODAL = ?, ID_TIPO_MODAL = ?, ID_MEDIDA = ?, MODELO_MODAL = ?, PLACA_MODAL = ?, MARCA_MODAL = ?, ANO_MODAL = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_MODAL = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, modal.getCaminhaImagem());
            ps.setInt(2, modal.getTipoModal().getId());
            ps.setInt(3, modal.getMedidaModal().getId());
            ps.setString(4, modal.getModelo());
            ps.setString(5, modal.getPlaca());
            ps.setString(6, modal.getMarca());
            ps.setInt(7, modal.getAnoFabricacao());
            ps.setTimestamp(8, modal.getDataCadastro());
            ps.setString(9, modal.getUsuario());
            ps.setInt(10, modal.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_MODAL WHERE ID_MODAL = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
