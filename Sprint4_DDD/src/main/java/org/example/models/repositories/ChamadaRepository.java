package org.example.models.repositories;

import org.example.infrascture.database.DataBaseFactory;
import org.example.models.Chamada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChamadaRepository {
    private ClienteRepository clienteRepository = new ClienteRepository();
    private ColaboradorRepository colaboradorRepository = new ColaboradorRepository();
    private VeiculoRepository veiculoRepository = new VeiculoRepository();
    private ModalRepository modalRepository = new ModalRepository();

    public List<Chamada> findAll() throws SQLException {
        List<Chamada> chamadas = new ArrayList<Chamada>();
        String query = "SELECT * FROM T_PA_CHAMADA";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Chamada chamada = new Chamada(
                        rs.getInt("ID_CHAMADA"),
                        rs.getString("IMG_CHAMADA"),
                        clienteRepository.find(rs.getInt("ID_CLIENTE")).orElse(null),
                        colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null),
                        veiculoRepository.find(rs.getInt("ID_VEICULO")).orElse(null),
                        modalRepository.find(rs.getInt("ID_MODAL")).orElse(null),
                        rs.getTimestamp("DT_INICIO_CHAMADA"),
                        rs.getTimestamp("DT_FIM_CHAMADA"),
                        rs.getString("LOCAL_CHAMADA"),
                        rs.getString("DESTINO_CHAMADA"),
                        rs.getString("DS_LOCAL_CHAMADA"),
                        rs.getString("DS_PROB_CHAMADA")
                );

                chamadas.add(chamada);
            }

            return chamadas;
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

    public Optional<Chamada> find(int id) throws SQLException {
        String query = "SELECT * FROM T_PA_CHAMADA WHERE ID_CHAMADA = ?";

        try(Connection connection = DataBaseFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    Chamada chamada = new Chamada(
                            rs.getInt("ID_CHAMADA"),
                            rs.getString("IMG_CHAMADA"),
                            clienteRepository.find(rs.getInt("ID_CLIENTE")).orElse(null),
                            colaboradorRepository.find(rs.getInt("ID_COLABORADOR")).orElse(null),
                            veiculoRepository.find(rs.getInt("ID_VEICULO")).orElse(null),
                            modalRepository.find(rs.getInt("ID_MODAL")).orElse(null),
                            rs.getTimestamp("DT_INICIO_CHAMADA"),
                            rs.getTimestamp("DT_FIM_CHAMADA"),
                            rs.getString("LOCAL_CHAMADA"),
                            rs.getString("DESTINO_CHAMADA"),
                            rs.getString("DS_LOCAL_CHAMADA"),
                            rs.getString("DS_PROB_CHAMADA")
                    );

                    return Optional.ofNullable(chamada);
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

    public void add(Chamada chamada) throws SQLException {
        String query = "INSERT INTO T_PA_CHAMADA (ID_CHAMADA, IMG_CHAMADA, ID_CLIENTE, ID_COLABORADOR, ID_VEICULO, ID_MODAL, DT_INICIO_CHAMADA, DT_FIM_CHAMADA, LOCAL_CHAMADA, DESTINO_CHAMADA, DS_LOCAL_CHAMADA, DS_PROB_CHAMADA, DT_CADASTRO, NM_USUARIO) VALUES (SQ_PA_CHAMADA.nextval(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, USER)";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, chamada.getCaminhosImagens());
            ps.setInt(2, chamada.getCliente().getId());
            ps.setInt(3, chamada.getColaborador().getId());
            ps.setInt(4, chamada.getVeiculo().getId());
            ps.setInt(5, chamada.getModal().getId());
            ps.setTimestamp(6, chamada.getDataInicio());
            ps.setTimestamp(7, chamada.getDataFim());
            ps.setString(8, chamada.getLocal());
            ps.setString(9, chamada.getDestino());
            ps.setString(10, chamada.getDescLocal());
            ps.setString(11, chamada.getDescProblema());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Chamada chamada) throws SQLException {
        String query = "UPDATE T_PA_CHAMADA SET IMG_CHAMADA = ?, ID_CLIENTE = ?, ID_COLABORADOR = ?, ID_VEICULO = ?, ID_MODAL = ?, DT_INICIO_CHAMADA = ?, DT_FIM_CHAMADA = ?, LOCAL_CHAMADA = ?, DESTINO_CHAMADA = ?, DS_LOCAL_CHAMADA = ?, DS_PROB_CHAMADA = ? WHERE ID_CHAMADA = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, chamada.getCaminhosImagens());
            ps.setInt(2, chamada.getCliente().getId());
            ps.setInt(3, chamada.getColaborador().getId());
            ps.setInt(4, chamada.getVeiculo().getId());
            ps.setInt(5, chamada.getModal().getId());
            ps.setTimestamp(6, chamada.getDataInicio());
            ps.setTimestamp(7, chamada.getDataFim());
            ps.setString(8, chamada.getLocal());
            ps.setString(9, chamada.getDestino());
            ps.setString(10, chamada.getDescLocal());
            ps.setString(11, chamada.getDescProblema());
            ps.setInt(12, chamada.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM T_PA_CHAMADA WHERE ID_CHAMADA = ?";

        try (Connection connection = DataBaseFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
