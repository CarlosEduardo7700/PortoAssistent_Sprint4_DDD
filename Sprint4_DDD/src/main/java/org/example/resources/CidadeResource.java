package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Cidade;
import org.example.models.repositories.CidadeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/cidade")
public class CidadeResource {
    private CidadeRepository repository = new CidadeRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade getById(@PathParam("id") int id) throws SQLException {
        Cidade cidade = repository.find(id).orElse(null);
        return cidade;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Cidade cidade) throws SQLException {
        repository.add(cidade);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Cidade cidade) throws SQLException {
        if (repository.find(id).isPresent()) {
            cidade.setIdCidade(id);
            repository.update(cidade);
            Optional<Cidade> cidadeAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(cidadeAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(cidade).build();
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
