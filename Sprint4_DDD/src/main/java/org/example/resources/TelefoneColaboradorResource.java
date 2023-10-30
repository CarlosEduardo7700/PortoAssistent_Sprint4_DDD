package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.TelefoneColaborador;
import org.example.models.repositories.TelefoneColaboradorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/telefone-colaborador")
public class TelefoneColaboradorResource {
    private TelefoneColaboradorRepository repository = new TelefoneColaboradorRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TelefoneColaborador> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TelefoneColaborador getById(@PathParam("id") int id) throws SQLException {
        TelefoneColaborador telefoneColaborador = repository.find(id).orElse(null);
        return telefoneColaborador;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(TelefoneColaborador telefoneColaborador) throws SQLException {
        repository.add(telefoneColaborador);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, TelefoneColaborador telefoneColaborador) throws SQLException {
        if (repository.find(id).isPresent()) {
            telefoneColaborador.getColaborador().setIdColaborador(id);
            repository.update(telefoneColaborador);
            Optional<TelefoneColaborador> telefoneColaboradorAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(telefoneColaboradorAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(telefoneColaborador).build();
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
