package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GeneroRepository {
    public List<Genero> findAll() throws SQLException {
        List<Genero> generos = new ArrayList<Genero>();
        String query = "SELECT * FROM T_PA_GENERO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Genero genero = new Genero(
                        rs.getInt("ID_GENERO"),
                        rs.getString("NOME_GENERO")
                );

                generos.add(genero);
            }

            return generos;
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

    public Optional<Genero> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_GENERO WHERE ID_GENERO = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Genero genero = new Genero(
                            rs.getInt("ID_GENERO"),
                            rs.getString("NOME_GENERO")
                    );

                    return Optional.ofNullable(genero);
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

    public void add(Genero genero) throws SQLException {
        String query = "INSERT INTO T_PA_GENERO (ID_GENERO, NOME_GENERO, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, genero.getId());
            ps.setString(2, genero.getNome());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Genero genero) throws SQLException {
        String query = "UPDATE T_PA_GENERO SET NOME_GENERO = ? WHERE ID_GENERO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, genero.getNome());
            ps.setInt(2, genero.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_GENERO WHERE ID_GENERO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
