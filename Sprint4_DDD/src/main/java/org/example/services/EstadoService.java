package org.example.services;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.example.models.Bairro;
import org.example.models.Estado;
import org.example.models.repositories.EstadoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EstadoService {
    private EstadoRepository repository = new EstadoRepository();

    public Response getAllService() throws SQLException {
        List<Estado> estados = repository.findAll();

        if (estados.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(estados).build();
    }

    public Response getByIdService(int id) throws SQLException {
        Estado estado = repository.find(id).orElse(null);

        if (estado == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(estado).build();
    }

    public Response insertService(Estado estado) throws SQLException {

        if (estado == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(estado);

            return Response.status(Response.Status.CREATED).build();
        }
    }

    public Response updateService(int id, Estado estado) throws SQLException {
        if (repository.find(id).isPresent()) {
            estado.setId(id);
            repository.update(estado);
            Optional<Estado> estadoAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(estadoAtualizado).build();
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
