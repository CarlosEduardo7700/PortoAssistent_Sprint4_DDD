package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Logradouro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogradouroRepository {
    private BairroRepository bairroRepository = new BairroRepository();

    public List<Logradouro> findAll() throws SQLException {
        List<Logradouro> logradouros = new ArrayList<Logradouro>();
        String query = "SELECT * FROM T_PA_LOGRADOURO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Logradouro logradouro = new Logradouro(
                        rs.getInt("ID_LOGRADOURO"),
                        bairroRepository.find(rs.getInt("ID_BAIRRO")).orElse(null),
                        rs.getString("NM_LOGRADOURO"),
                        rs.getString("NR_CEP"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                logradouros.add(logradouro);
            }

            return logradouros;
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

    public Optional<Logradouro> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_LOGRADOURO WHERE ID_LOGRADOURO = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Logradouro logradouro = new Logradouro(
                            rs.getInt("ID_LOGRADOURO"),
                            bairroRepository.find(rs.getInt("ID_BAIRRO")).orElse(null),
                            rs.getString("NM_LOGRADOURO"),
                            rs.getString("NR_CEP"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(logradouro);
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

    public void add(Logradouro logradouro) throws SQLException {
        String query = "INSERT INTO T_PA_LOGRADOURO (ID_LOGRADOURO, ID_BAIRRO, NM_LOGRADOURO, NR_CEP, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, logradouro.getId());
            ps.setInt(2, logradouro.getBairro().getId());
            ps.setString(3, logradouro.getNome());
            ps.setString(4, logradouro.getCep());
            ps.setTimestamp(5, logradouro.getDataCadastro());
            ps.setString(6, logradouro.getUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Logradouro logradouro) throws SQLException {
        String query = "UPDATE T_PA_LOGRADOURO SET ID_BAIRRO = ?, NM_LOGRADOURO = ?, NR_CEP = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_LOGRADOURO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, logradouro.getBairro().getId());
            ps.setString(2, logradouro.getNome());
            ps.setString(3, logradouro.getCep());
            ps.setTimestamp(4, logradouro.getDataCadastro());
            ps.setString(5, logradouro.getUsuario());
            ps.setInt(6, logradouro.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_LOGRADOURO WHERE ID_LOGRADOURO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
