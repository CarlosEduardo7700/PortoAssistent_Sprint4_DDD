package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Bairro;
import org.example.models.Logradouro;
import org.example.models.repositories.LogradouroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/logradouro")
public class LogradouroResource {
    private LogradouroRepository repository = new LogradouroRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logradouro> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Logradouro getById(@PathParam("id") int id) throws SQLException {
        Logradouro logradouro = repository.find(id).orElse(null);
        return logradouro;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Logradouro logradouro) throws SQLException {
        repository.add(logradouro);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Logradouro logradouro) throws SQLException {
        if (repository.find(id).isPresent()) {
            logradouro.setIdLogradouro(id);
            repository.update(logradouro);
            Optional<Logradouro> logradouroAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(logradouroAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(logradouro).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
