package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Cliente;
import org.example.models.Colaborador;
import org.example.models.repositories.ClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/cliente")
public class ClienteResource {
    private ClienteRepository repository = new ClienteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getById(@PathParam("id") int id) throws SQLException {
        Cliente cliente = repository.find(id).orElse(null);
        return cliente;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Cliente cliente) throws SQLException {
        repository.add(cliente);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Cliente cliente) throws SQLException {
        if (repository.find(id).isPresent()) {
            cliente.setIdCliente(id);
            repository.update(cliente);
            Optional<Cliente> clienteAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(clienteAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(cliente).build();
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
