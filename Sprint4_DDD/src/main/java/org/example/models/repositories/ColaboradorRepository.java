package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ColaboradorRepository {
    private GeneroRepository generoRepository = new GeneroRepository();

    public List<Colaborador> findAll() throws SQLException {
        List<Colaborador> colaboradores = new ArrayList<Colaborador>();
        String query = "SELECT * FROM T_PA_COLABORADOR";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Colaborador colaborador = new Colaborador(
                        rs.getInt("ID_COLABORADOR"),
                        rs.getString("IMG_COLABORADOR"),
                        generoRepository.find(rs.getInt("ID_GENERO")).orElse(null),
                        rs.getString("NM_COLABORADOR"),
                        rs.getString("CPF_COLABORADOR"),
                        rs.getString("RG_COLABORADOR"),
                        rs.getString("TEL_COLABORADOR"),
                        rs.getString("EMAIL_COLABORADOR"),
                        rs.getString("SENHA_COLABORADOR"),
                        rs.getString("CNH_COLABORADOR"),
                        rs.getTimestamp("DT_NASCIMENTO_COLABORADOR"),
                        rs.getTimestamp("DT_CADASTRO"),
                        rs.getString("NM_USUARIO")
                );

                colaboradores.add(colaborador);
            }

            return colaboradores;
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

    public Optional<Colaborador> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_COLABORADOR WHERE ID_COLABORADOR = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Colaborador colaborador = new Colaborador(
                            rs.getInt("ID_COLABORADOR"),
                            rs.getString("IMG_COLABORADOR"),
                            generoRepository.find(rs.getInt("ID_GENERO")).orElse(null),
                            rs.getString("NM_COLABORADOR"),
                            rs.getString("CPF_COLABORADOR"),
                            rs.getString("RG_COLABORADOR"),
                            rs.getString("TEL_COLABORADOR"),
                            rs.getString("EMAIL_COLABORADOR"),
                            rs.getString("SENHA_COLABORADOR"),
                            rs.getString("CNH_COLABORADOR"),
                            rs.getTimestamp("DT_NASCIMENTO_COLABORADOR"),
                            rs.getTimestamp("DT_CADASTRO"),
                            rs.getString("NM_USUARIO")
                    );

                    return Optional.ofNullable(colaborador);
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

    public void add(Colaborador colaborador) throws SQLException {
        String query = "INSERT INTO T_PA_COLABORADOR (ID_COLABORADOR, IMG_COLABORADOR, ID_GENERO, NM_COLABORADOR, CPF_COLABORADOR, RG_COLABORADOR, TEL_COLABORADOR, EMAIL_COLABORADOR, SENHA_COLABORADOR, CNH_COLABORADOR, DT_NASCIMENTO_COLABORADOR, DT_CADASTRO, NM_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, colaborador.getIdColaborador());
            ps.setString(2, colaborador.getCaminhoImagem());
            ps.setInt(3, colaborador.getGenero().getIdGenero());
            ps.setString(4, colaborador.getNomeColaborador());
            ps.setString(5, colaborador.getCpfColaborador());
            ps.setString(6, colaborador.getRgColaborador());
            ps.setString(7, colaborador.getTelefoneColaborador());
            ps.setString(8, colaborador.getEmailColaborador());
            ps.setString(9, colaborador.getSenhaColaborador());
            ps.setString(10, colaborador.getCnhColaborador());
            ps.setTimestamp(11, colaborador.getDataNascimentoColaborador());
            ps.setTimestamp(12, colaborador.getDtCadastro());
            ps.setString(13, colaborador.getNomeUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Colaborador colaborador) throws SQLException {
        String query = "UPDATE T_PA_COLABORADOR SET IMG_COLABORADOR = ?, ID_GENERO = ?, NM_COLABORADOR = ?, CPF_COLABORADOR = ?, RG_COLABORADOR = ?, TEL_COLABORADOR = ?, EMAIL_COLABORADOR = ?, SENHA_COLABORADOR = ?, CNH_COLABORADOR = ?, DT_NASCIMENTO_COLABORADOR = ?, DT_CADASTRO = ?, NM_USUARIO = ? WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, colaborador.getCaminhoImagem());
            ps.setInt(2, colaborador.getGenero().getIdGenero());
            ps.setString(3, colaborador.getNomeColaborador());
            ps.setString(4, colaborador.getCpfColaborador());
            ps.setString(5, colaborador.getRgColaborador());
            ps.setString(6, colaborador.getTelefoneColaborador());
            ps.setString(7, colaborador.getEmailColaborador());
            ps.setString(8, colaborador.getSenhaColaborador());
            ps.setString(9, colaborador.getCnhColaborador());
            ps.setTimestamp(10, colaborador.getDataNascimentoColaborador());
            ps.setTimestamp(11, colaborador.getDtCadastro());
            ps.setString(12, colaborador.getNomeUsuario());
            ps.setInt(13, colaborador.getIdColaborador());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_COLABORADOR WHERE ID_COLABORADOR = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
