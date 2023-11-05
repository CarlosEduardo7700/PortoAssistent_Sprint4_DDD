package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.TelefoneColaborador;
import org.example.models.repositories.TelefoneColaboradorRepository;
import org.example.services.TelefoneColaboradorService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/telefone-colaborador")
public class TelefoneColaboradorResource {
    private TelefoneColaboradorService service = new TelefoneColaboradorService();

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
    public Response insert(TelefoneColaborador telefoneColaborador) throws SQLException {
        return service.insertService(telefoneColaborador);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, TelefoneColaborador telefoneColaborador) throws SQLException {
        return service.updateService(id, telefoneColaborador);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) throws SQLException {
        return service.deleteService(id);
    }
}
