package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.TelefoneCliente;
import org.example.models.repositories.TelefoneClienteRepository;
import org.example.services.TelefoneClienteService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/telefone-cliente")
public class TelefoneClienteResource {
    private TelefoneClienteService service = new TelefoneClienteService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws SQLException {
        return service.getAllService();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) throws SQLException {
        return service.getByIdService(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(TelefoneCliente telefoneCliente) throws SQLException {
        return service.insertService(telefoneCliente);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, TelefoneCliente telefoneCliente) throws SQLException {
        return service.updateService(id, telefoneCliente);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) throws SQLException {
        return service.deleteService(id);
    }

}
