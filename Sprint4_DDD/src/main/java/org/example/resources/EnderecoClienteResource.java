package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.EnderecoCliente;
import org.example.models.EnderecoColaborador;
import org.example.models.repositories.EnderecoClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/endereco-cliente")
public class EnderecoClienteResource {
    private EnderecoClienteRepository repository = new EnderecoClienteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnderecoCliente> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoCliente getByIdCliente(@PathParam("id") int idCliente) throws SQLException {
        EnderecoCliente enderecoCliente = repository.findByCliente(idCliente).orElse(null);
        return enderecoCliente;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(EnderecoCliente enderecoCliente) throws SQLException {
        repository.add(enderecoCliente);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateByIdCliente(@PathParam("id") int idCliente, EnderecoCliente enderecoCliente) throws SQLException {
        if (repository.findByCliente(idCliente).isPresent()) {
            enderecoCliente.getCliente().setIdCliente(idCliente);
            repository.updateByIdCliente(enderecoCliente);
            Optional<EnderecoCliente> enderecoClienteAtualizado = repository.findByCliente(idCliente);
            return Response.status(Response.Status.OK).entity(enderecoClienteAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(enderecoCliente).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteByIdCliente(@PathParam("id") int idCliente) throws SQLException {
        if (repository.findByCliente(idCliente).isPresent()) {
            repository.deleteByIdCliente(idCliente);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
