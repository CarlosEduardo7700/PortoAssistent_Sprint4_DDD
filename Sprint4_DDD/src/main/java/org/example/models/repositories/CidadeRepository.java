package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CidadeRepository {
    private EstadoRepository estadoRepository = new EstadoRepository();

    public List<Cidade> findAll() throws SQLException {
        List<Cidade> cidades = new ArrayList<Cidade>();
        String query = "SELECT * FROM T_PA_CIDADE";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Cidade cidade = new Cidade(
                        rs.getInt("ID_CIDADE"),
                        estadoRepository.find(rs.getInt("ID_ESTADO")).orElse(null),
                        rs.getString("NM_CIDADE"),
                        rs.getInt("CD_IBGE"),
                        rs.getInt("NR_DDD"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                cidades.add(cidade);
            }

            return cidades;
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

    public Optional<Cidade> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_CIDADE WHERE ID_CIDADE = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Cidade cidade = new Cidade(
                            rs.getInt("ID_CIDADE"),
                            estadoRepository.find(rs.getInt("ID_ESTADO")).orElse(null),
                            rs.getString("NM_CIDADE"),
                            rs.getInt("CD_IBGE"),
                            rs.getInt("NR_DDD"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(cidade);
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

    public void add(Cidade cidade) throws SQLException {
        String query = "INSERT INTO T_PA_CIDADE (ID_CIDADE, ID_ESTADO, NM_CIDADE, CD_IBGE, NR_DDD, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, cidade.getId());
            ps.setInt(2, cidade.getEstado().getId());
            ps.setString(3, cidade.getNome());
            ps.setInt(4, cidade.getIbgeCodigo());
            ps.setInt(5, cidade.getDdd());
            ps.setTimestamp(6, cidade.getDataCadastro());
            ps.setString(7, cidade.getUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Cidade cidade) throws SQLException {
        String query = "UPDATE T_PA_CIDADE SET ID_ESTADO = ?, NM_CIDADE = ?, CD_IBGE = ?, NR_DDD = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_CIDADE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, cidade.getEstado().getId());
            ps.setString(2, cidade.getNome());
            ps.setInt(3, cidade.getIbgeCodigo());
            ps.setInt(4, cidade.getDdd());
            ps.setTimestamp(5, cidade.getDataCadastro());
            ps.setString(6, cidade.getUsuario());
            ps.setInt(7, cidade.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_CIDADE WHERE ID_CIDADE = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
