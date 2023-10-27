package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Tipo_Eixo;
import org.example.models.Tipo_Modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tipo_EixoRepository {
    public List<Tipo_Eixo> findAll() throws SQLException {
        List<Tipo_Eixo> tipos_eixos = new ArrayList<Tipo_Eixo>();
        String query = "SELECT * FROM T_PA_TIPO_EIXO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Tipo_Eixo tipoEixo = new Tipo_Eixo(
                        rs.getInt("ID_TIPO_EIXO"),
                        rs.getString("NOME_TIPO_EIXO"),
                        rs.getString("DESC_TIPO_EIXO"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                tipos_eixos.add(tipoEixo);
            }

            return tipos_eixos;
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

    public Optional<Tipo_Eixo> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_TIPO_EIXO WHERE ID_TIPO_EIXO = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Tipo_Eixo tipoEixo = new Tipo_Eixo(
                            rs.getInt("ID_TIPO_EIXO"),
                            rs.getString("NOME_TIPO_EIXO"),
                            rs.getString("DESC_TIPO_EIXO"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(tipoEixo);
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

    public void add(Tipo_Eixo tipoEixo) throws SQLException {
        String query = "INSERT INTO T_PA_TIPO_EIXO (ID_TIPO_EIXO, NOME_TIPO_EIXO, DESC_TIPO_EIXO, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, tipoEixo.getIdEixo());
            ps.setString(2, tipoEixo.getNomeTipoEixo());
            ps.setString(3, tipoEixo.getDescTipoEixo());
            ps.setTimestamp(4, tipoEixo.getDtCadastro());
            ps.setString(5, tipoEixo.getNomeUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Tipo_Eixo tipoEixo) throws SQLException {
        String query = "UPDATE T_PA_TIPO_EIXO SET NOME_TIPO_EIXO = ?, DESC_TIPO_EIXO = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_TIPO_EIXO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, tipoEixo.getNomeTipoEixo());
            ps.setString(2, tipoEixo.getDescTipoEixo());
            ps.setTimestamp(3, tipoEixo.getDtCadastro());
            ps.setString(4, tipoEixo.getNomeUsuario());
            ps.setInt(5, tipoEixo.getIdEixo());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_TIPO_EIXO WHERE ID_TIPO_EIXO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
