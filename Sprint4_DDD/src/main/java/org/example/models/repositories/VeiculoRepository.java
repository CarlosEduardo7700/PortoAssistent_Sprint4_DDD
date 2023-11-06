package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepository {
    private TipoEixoRepository tipoEixoRepository = new TipoEixoRepository();
    private TipoChassiRepository tipoChassiRepository = new TipoChassiRepository();
    private MedidaRepository medidaRepository = new MedidaRepository();

    public List<Veiculo> findAll() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        String query = "SELECT * FROM T_PA_VEICULO";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Veiculo veiculo = new Veiculo(
                        rs.getInt("ID_VEICULO"),
                        rs.getString("IMG_VEICULO"),
                        tipoEixoRepository.find(rs.getInt("ID_TIPO_EIXO")).orElse(null),
                        tipoChassiRepository.find(rs.getInt("ID_TIPO_CHASSI")).orElse(null),
                        medidaRepository.find(rs.getInt("T_PA_MEDIDA_ID_MEDIDA")).orElse(null),
                        rs.getInt("APOLICE_VEICULO"),
                        rs.getString("MODELO_VEICULO"),
                        rs.getString("COR_VEICULO"),
                        rs.getString("MARCA_VEICULO"),
                        rs.getString("PLACA_VEICULO"),
                        rs.getInt("ANO_VEICULO"),
                        rs.getInt("QUANTIDADE_EIXOS_VEICULO"),
                        rs.getString("RENAVAN_VEICULO"),
                        rs.getInt("NR_CHASSI")
                );

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
                    Veiculo veiculo = new Veiculo(
                            rs.getInt("ID_VEICULO"),
                            rs.getString("IMG_VEICULO"),
                            tipoEixoRepository.find(rs.getInt("ID_TIPO_EIXO")).orElse(null),
                            tipoChassiRepository.find(rs.getInt("ID_TIPO_CHASSI")).orElse(null),
                            medidaRepository.find(rs.getInt("T_PA_MEDIDA_ID_MEDIDA")).orElse(null),
                            rs.getInt("APOLICE_VEICULO"),
                            rs.getString("MODELO_VEICULO"),
                            rs.getString("COR_VEICULO"),
                            rs.getString("MARCA_VEICULO"),
                            rs.getString("PLACA_VEICULO"),
                            rs.getInt("ANO_VEICULO"),
                            rs.getInt("QUANTIDADE_EIXOS_VEICULO"),
                            rs.getString("RENAVAN_VEICULO"),
                            rs.getInt("NR_CHASSI")
                    );

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
        String query = "INSERT INTO T_PA_VEICULO (ID_VEICULO, IMG_VEICULO, ID_TIPO_EIXO, ID_TIPO_CHASSI, T_PA_MEDIDA_ID_MEDIDA, APOLICE_VEICULO, MODELO_VEICULO, COR_VEICULO, MARCA_VEICULO, PLACA_VEICULO, ANO_VEICULO, QUANTIDADE_EIXOS_VEICULO, RENAVAN_VEICULO, NR_CHASSI, DT_CADASTRO, NM_USUARIO) VALUES (SQ_PA_VEICULO.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, veiculo.getCaminhoImagem());
            ps.setInt(2, veiculo.getTipoEixo().getId());
            ps.setInt(3, veiculo.getTipoChassi().getId());
            ps.setInt(4, veiculo.getMedidaVeiculo().getId());
            ps.setInt(5, veiculo.getApolice());
            ps.setString(6, veiculo.getModelo());
            ps.setString(7, veiculo.getCor());
            ps.setString(8, veiculo.getMarca());
            ps.setString(9, veiculo.getPlaca());
            ps.setInt(10, veiculo.getAnoFabricacao());
            ps.setInt(11, veiculo.getQuantidadeEixos());
            ps.setString(12, veiculo.getRenavan());
            ps.setInt(13, veiculo.getNumChassi());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Veiculo veiculo) throws SQLException {
        String query = "UPDATE T_PA_VEICULO SET IMG_VEICULO = ?, ID_TIPO_EIXO = ?, ID_TIPO_CHASSI = ?, T_PA_MEDIDA_ID_MEDIDA = ?, APOLICE_VEICULO = ?, MODELO_VEICULO = ?, COR_VEICULO = ?, MARCA_VEICULO = ?, PLACA_VEICULO = ?, ANO_VEICULO = ?, QUANTIDADE_EIXOS_VEICULO = ?, RENAVAN_VEICULO = ?, NR_CHASSI = ? WHERE ID_VEICULO = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, veiculo.getCaminhoImagem());
            ps.setInt(2, veiculo.getTipoEixo().getId());
            ps.setInt(3, veiculo.getTipoChassi().getId());
            ps.setInt(4, veiculo.getMedidaVeiculo().getId());
            ps.setInt(5, veiculo.getApolice());
            ps.setString(6, veiculo.getModelo());
            ps.setString(7, veiculo.getCor());
            ps.setString(8, veiculo.getMarca());
            ps.setString(9, veiculo.getPlaca());
            ps.setInt(10, veiculo.getAnoFabricacao());
            ps.setInt(11, veiculo.getQuantidadeEixos());
            ps.setString(12, veiculo.getRenavan());
            ps.setInt(13, veiculo.getNumChassi());
            ps.setInt(14, veiculo.getId());

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
