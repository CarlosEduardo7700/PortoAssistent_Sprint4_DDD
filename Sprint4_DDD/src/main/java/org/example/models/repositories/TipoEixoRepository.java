package org.example.models.repositories;

import org.example.infrastructure.database.DataBaseFactory;
import org.example.models.TipoEixo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TipoEixoRepository {
    public List<TipoEixo> findAll() throws SQLException {
        List<TipoEixo> tipos_eixos = new ArrayList<TipoEixo>();
        String query = "SELECT * FROM T_PA_TIPO_EIXO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                TipoEixo tipoEixo = new TipoEixo(
                        rs.getInt("ID_TIPO_EIXO"),
                        rs.getString("NOME_TIPO_EIXO"),
                        rs.getString("DESC_TIPO_EIXO")
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

    public Optional<TipoEixo> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_TIPO_EIXO WHERE ID_TIPO_EIXO = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    TipoEixo tipoEixo = new TipoEixo(
                            rs.getInt("ID_TIPO_EIXO"),
                            rs.getString("NOME_TIPO_EIXO"),
                            rs.getString("DESC_TIPO_EIXO")
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

    public void add(TipoEixo tipoEixo) throws SQLException {
        String query = "INSERT INTO T_PA_TIPO_EIXO (ID_TIPO_EIXO, NOME_TIPO_EIXO, DESC_TIPO_EIXO, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, tipoEixo.getId());
            ps.setString(2, tipoEixo.getNome());
            ps.setString(3, tipoEixo.getDescricao());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(TipoEixo tipoEixo) throws SQLException {
        String query = "UPDATE T_PA_TIPO_EIXO SET NOME_TIPO_EIXO = ?, DESC_TIPO_EIXO = ? WHERE ID_TIPO_EIXO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, tipoEixo.getNome());
            ps.setString(2, tipoEixo.getDescricao());
            ps.setInt(3, tipoEixo.getId());

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
