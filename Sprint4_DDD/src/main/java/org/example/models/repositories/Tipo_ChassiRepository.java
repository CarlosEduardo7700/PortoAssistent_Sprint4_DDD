package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Tipo_Chassi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tipo_ChassiRepository {
    public List<Tipo_Chassi> findAll() throws SQLException {
        List<Tipo_Chassi> tipos_chassis = new ArrayList<Tipo_Chassi>();
        String query = "SELECT * FROM T_PA_TIPO_CHASSI";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Tipo_Chassi tipoChassi = new Tipo_Chassi(
                        rs.getInt("ID_TIPO_CHASSI"),
                        rs.getString("NOME_TIPO_CHASSI"),
                        rs.getString("DESC_TIPO_CHASSI"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
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

    public Optional<Tipo_Chassi> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_TIPO_CHASSI WHERE ID_TIPO_CHASSI = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Tipo_Chassi tipoChassi = new Tipo_Chassi(
                            rs.getInt("ID_TIPO_CHASSI"),
                            rs.getString("NOME_TIPO_CHASSI"),
                            rs.getString("DESC_TIPO_CHASSI"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
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

    public void add(Tipo_Chassi tipoChassi) throws SQLException {
        String query = "INSERT INTO T_PA_TIPO_CHASSI (ID_TIPO_CHASSI, NOME_TIPO_CHASSI, DESC_TIPO_CHASSI, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, tipoChassi.getIdChassi());
            ps.setString(2, tipoChassi.getNomeTipoChassi());
            ps.setString(3, tipoChassi.getDescTipoChassi());
            ps.setTimestamp(4, tipoChassi.getDtCadastro());
            ps.setString(5, tipoChassi.getNomeUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Tipo_Chassi tipoChassi) throws SQLException {
        String query = "UPDATE T_PA_TIPO_CHASSI SET NOME_TIPO_CHASSI = ?, DESC_TIPO_CHASSI = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_TIPO_CHASSI = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, tipoChassi.getNomeTipoChassi());
            ps.setString(2, tipoChassi.getDescTipoChassi());
            ps.setTimestamp(3, tipoChassi.getDtCadastro());
            ps.setString(4, tipoChassi.getNomeUsuario());
            ps.setInt(5, tipoChassi.getIdChassi());

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
