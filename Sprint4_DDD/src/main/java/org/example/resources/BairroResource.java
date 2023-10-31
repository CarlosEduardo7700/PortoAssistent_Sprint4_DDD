package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Bairro;
import org.example.models.repositories.BairroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/bairro")
public class BairroResource {
    private BairroRepository repository = new BairroRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bairro> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bairro getById(@PathParam("id") int id) throws SQLException {
        Bairro bairro = repository.find(id).orElse(null);
        return bairro;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Bairro bairro) throws SQLException {
        repository.add(bairro);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Bairro bairro) throws SQLException {
        if (repository.find(id).isPresent()) {
            bairro.setId(id);
            repository.update(bairro);
            Optional<Bairro> bairroAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(bairroAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(bairro).build();
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
