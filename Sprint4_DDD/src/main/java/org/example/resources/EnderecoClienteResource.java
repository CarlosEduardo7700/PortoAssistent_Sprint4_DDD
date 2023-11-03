package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.EnderecoCliente;
import org.example.models.repositories.EnderecoClienteRepository;
import org.example.services.EnderecoClienteService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/endereco-cliente")
public class EnderecoClienteResource {
    private EnderecoClienteService service = new EnderecoClienteService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws SQLException {
        return service.getAllService();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdCliente(@PathParam("id") int idCliente) throws SQLException {
        return service.getByIdService(idCliente);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(EnderecoCliente enderecoCliente) throws SQLException {
        return service.insertService(enderecoCliente);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateByIdCliente(@PathParam("id") int idCliente, EnderecoCliente enderecoCliente) throws SQLException {
        return service.updateService(idCliente, enderecoCliente);
    }

    @DELETE
    @Path("{id}")
    public Response deleteByIdCliente(@PathParam("id") int idCliente) throws SQLException {
        return service.deleteService(idCliente);
    }
}
