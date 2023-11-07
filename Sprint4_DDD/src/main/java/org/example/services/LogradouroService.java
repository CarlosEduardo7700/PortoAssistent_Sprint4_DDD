package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.Logradouro;
import org.example.models.repositories.LogradouroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LogradouroService {
    private LogradouroRepository repository = new LogradouroRepository();

    public Response getAllService() throws SQLException {
        List<Logradouro> logradouros = repository.findAll();

        if (logradouros.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(logradouros).build();
    }



    public Response getByIdService(int id) throws SQLException {
        Logradouro logradouro = repository.find(id).orElse(null);

        if (logradouro == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(logradouro).build();
    }



    public Response insertService(Logradouro logradouro) throws SQLException {

        if (logradouro == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(logradouro);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, Logradouro logradouro) throws SQLException {
        if (repository.find(id).isPresent()) {
            logradouro.setId(id);
            repository.update(logradouro);
            Optional<Logradouro> logradouroAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(logradouroAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }



    public Response deleteService(int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }

}
