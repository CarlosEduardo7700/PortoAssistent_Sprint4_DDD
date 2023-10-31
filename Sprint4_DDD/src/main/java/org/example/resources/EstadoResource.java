package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Estado;
import org.example.models.repositories.EstadoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/estado")
public class EstadoResource {
    private EstadoRepository repository = new EstadoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Estado getById(@PathParam("id") int id) throws SQLException {
        Estado estado = repository.find(id).orElse(null);
        return estado;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Estado estado) throws SQLException {
        repository.add(estado);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Estado estado) throws SQLException {
        if (repository.find(id).isPresent()) {
            estado.setId(id);
            repository.update(estado);
            Optional<Estado> estadoAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(estadoAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(estado).build();
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
