package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Bairro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BairroRepository {
    private CidadeRepository cidadeRepository = new CidadeRepository();

    public List<Bairro> findAll() throws SQLException {
        List<Bairro> bairros = new ArrayList<Bairro>();
        String query = "SELECT * FROM T_PA_BAIRRO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Bairro bairro = new Bairro(
                        rs.getInt("ID_BAIRRO"),
                        cidadeRepository.find(rs.getInt("ID_CIDADE")).orElse(null),
                        rs.getString("NM_BAIRRO"),
                        rs.getString("NM_ZONA_BAIRRO")
                );

                bairros.add(bairro);
            }

            return bairros;
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

    public Optional<Bairro> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_BAIRRO WHERE ID_BAIRRO = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Bairro bairro = new Bairro(
                            rs.getInt("ID_BAIRRO"),
                            cidadeRepository.find(rs.getInt("ID_CIDADE")).orElse(null),
                            rs.getString("NM_BAIRRO"),
                            rs.getString("NM_ZONA_BAIRRO")
                    );

                    return Optional.ofNullable(bairro);
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

    public void add(Bairro bairro) throws SQLException {
        String query = "INSERT INTO T_PA_BAIRRO (ID_BAIRRO, ID_CIDADE, NM_BAIRRO, NM_ZONA_BAIRRO, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, bairro.getId());
            ps.setInt(2, bairro.getCidade().getId());
            ps.setString(3, bairro.getNome());
            ps.setString(4, bairro.getZona());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Bairro bairro) throws SQLException {
        String query = "UPDATE T_PA_BAIRRO SET ID_CIDADE = ?, NM_BAIRRO = ?, NM_ZONA_BAIRRO = ? WHERE ID_BAIRRO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, bairro.getCidade().getId());
            ps.setString(2, bairro.getNome());
            ps.setString(3, bairro.getZona());
            ps.setInt(4, bairro.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }


    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_BAIRRO WHERE ID_BAIRRO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
