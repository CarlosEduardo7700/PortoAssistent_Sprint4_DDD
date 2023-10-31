package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstadoRepository {
    public List<Estado> findAll() throws SQLException {
        List<Estado> estados = new ArrayList<Estado>();
        String query = "SELECT * FROM T_PA_ESTADO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Estado estado = new Estado(
                        rs.getInt("ID_ESTADO"),
                        rs.getString("SG_ESTADO"),
                        rs.getString("NM_ESTADO"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                estados.add(estado);
            }

            return estados;
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

    public Optional<Estado> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_ESTADO WHERE ID_ESTADO = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Estado estado = new Estado(
                            rs.getInt("ID_ESTADO"),
                            rs.getString("SG_ESTADO"),
                            rs.getString("NM_ESTADO"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(estado);
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

    public void add(Estado estado) throws SQLException {
        String query = "INSERT INTO T_PA_ESTADO (ID_ESTADO, SG_ESTADO, NM_ESTADO, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, estado.getId());
            ps.setString(2, estado.getSigla());
            ps.setString(3, estado.getNome());
            ps.setTimestamp(4, estado.getDataCadastro());
            ps.setString(5, estado.getUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Estado estado) throws SQLException {
        String query = "UPDATE T_PA_ESTADO SET SG_ESTADO = ?, NM_ESTADO = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_ESTADO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, estado.getSigla());
            ps.setString(2, estado.getNome());
            ps.setTimestamp(3, estado.getDataCadastro());
            ps.setString(4, estado.getUsuario());
            ps.setInt(5, estado.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_ESTADO WHERE ID_ESTADO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
