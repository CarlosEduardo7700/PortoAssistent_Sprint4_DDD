package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepository {

    public List<Veiculo> findAll() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        String query = "SELECT * FROM T_PA_VEICULO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                veiculo.setMarca(rs.getString("nm_marca"));
                veiculo.setModelo(rs.getString("nm_modelo"));
                veiculo.setDtCadastro(rs.getTimestamp("dt_cadastro"));

                veiculos.add(veiculo);
            }

            return veiculos;
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

    public Optional<Veiculo> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_VEICULO WHERE id_veiculo = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                    veiculo.setMarca(rs.getString("nm_marca"));
                    veiculo.setModelo(rs.getString("nm_modelo"));
                    veiculo.setDtCadastro(rs.getTimestamp("dt_cadastro"));

                    return Optional.ofNullable(veiculo);
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

    public void add(Veiculo veiculo) throws SQLException {
        String query = "INSERT INTO T_PA_VEICULO (ID_VEICULO, NM_MARCA, NM_MODELO, DT_CADASTRO) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, veiculo.getIdVeiculo());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setTimestamp(4, veiculo.getDtCadastro());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Veiculo veiculo) throws SQLException {
        String query = "UPDATE T_PA_VEICULO SET NM_MARCA = ?, NM_MODELO = ?, DT_CADASTRO = ? WHERE ID_VEICULO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setTimestamp(3, veiculo.getDtCadastro());
            ps.setInt(4, veiculo.getIdVeiculo());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_VEICULO WHERE ID_VEICULO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
