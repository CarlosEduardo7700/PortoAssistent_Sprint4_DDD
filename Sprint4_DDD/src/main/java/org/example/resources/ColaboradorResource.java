package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Colaborador;
import org.example.models.repositories.ColaboradorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/colaborador")
public class ColaboradorResource {
    private ColaboradorRepository repository = new ColaboradorRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Colaborador getById(@PathParam("id") int id) throws SQLException {
        Colaborador colaborador = repository.find(id).orElse(null);
        return colaborador;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Colaborador colaborador) throws SQLException {
        repository.add(colaborador);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Colaborador colaborador) throws SQLException {
        if (repository.find(id).isPresent()) {
            colaborador.setIdColaborador(id);
            repository.update(colaborador);
            Optional<Colaborador> colaboradorAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(colaboradorAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(colaborador).build();
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
