package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.EnderecoColaborador;
import org.example.models.repositories.EnderecoColaboradorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EnderecoColaboradorService {
    private EnderecoColaboradorRepository repository = new EnderecoColaboradorRepository();

    public Response getAllService() throws SQLException {
        List<EnderecoColaborador> enderecosColaboradores = repository.findAll();

        if (enderecosColaboradores.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(enderecosColaboradores).build();
    }



    public Response getByIdService(int id) throws SQLException {
        EnderecoColaborador enderecoColaborador = repository.findByColaborador(id).orElse(null);

        if (enderecoColaborador == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(enderecoColaborador).build();
    }



    public Response insertService(EnderecoColaborador enderecoColaborador) throws SQLException {

        if (enderecoColaborador == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(enderecoColaborador);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, EnderecoColaborador enderecoColaborador) throws SQLException {
        if (repository.findByColaborador(id).isPresent()) {
            enderecoColaborador.getColaborador().setId(id);
            repository.updateByIdColaborador(enderecoColaborador);
            Optional<EnderecoColaborador> enderecoColaboradorAtualizado = repository.findByColaborador(id);
            return Response.status(Response.Status.OK).entity(enderecoColaboradorAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }



    public Response deleteService(int id) throws SQLException {
        if (repository.findByColaborador(id).isPresent()) {
            repository.deleteByIdColaborador(id);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }
}
