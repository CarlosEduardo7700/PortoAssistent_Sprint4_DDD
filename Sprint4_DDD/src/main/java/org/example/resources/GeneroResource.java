package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Genero;
import org.example.models.repositories.GeneroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/genero")
public class GeneroResource {
    private GeneroRepository repository = new GeneroRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Genero> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Genero getById(@PathParam("id") int id) throws SQLException {
        Genero genero = repository.find(id).orElse(null);
        return genero;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Genero genero) throws SQLException {
        repository.add(genero);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Genero genero) throws SQLException {
        if (repository.find(id).isPresent()) {
            genero.setId(id);
            repository.update(genero);
            Optional<Genero> generoAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(generoAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(genero).build();
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
