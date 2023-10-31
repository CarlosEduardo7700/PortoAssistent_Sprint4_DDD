package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.TelefoneCliente;
import org.example.models.repositories.TelefoneClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/telefone-cliente")
public class TelefoneClienteResource {
    private TelefoneClienteRepository repository = new TelefoneClienteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TelefoneCliente> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TelefoneCliente getById(@PathParam("id") int id) throws SQLException {
        TelefoneCliente telefoneCliente = repository.find(id).orElse(null);
        return telefoneCliente;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(TelefoneCliente telefoneCliente) throws SQLException {
        repository.add(telefoneCliente);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, TelefoneCliente telefoneCliente) throws SQLException {
        if (repository.find(id).isPresent()) {
            telefoneCliente.getCliente().setId(id);
            repository.update(telefoneCliente);
            Optional<TelefoneCliente> telefoneClienteAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(telefoneClienteAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(telefoneCliente).build();
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
