package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Chamada;
import org.example.models.repositories.ChamadaRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/chamada")
public class ChamadaResource {
    private ChamadaRepository repository = new ChamadaRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chamada> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chamada getById(@PathParam("id") int id) throws SQLException {
        Chamada chamada = repository.find(id).orElse(null);
        return chamada;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Chamada chamada) throws SQLException {
        repository.add(chamada);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Chamada chamada) throws SQLException {
        if (repository.find(id).isPresent()) {
            chamada.setId(id);
            repository.update(chamada);
            Optional<Chamada> chamadaAtualizada = repository.find(id);
            return Response.status(Response.Status.OK).entity(chamadaAtualizada).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(chamada).build();
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
