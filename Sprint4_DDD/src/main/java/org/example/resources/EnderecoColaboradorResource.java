package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.EnderecoColaborador;
import org.example.models.repositories.EnderecoColaboradorRepository;
import org.example.services.EnderecoColaboradorService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/endereco-colaborador")
public class EnderecoColaboradorResource {
    private EnderecoColaboradorService service = new EnderecoColaboradorService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws SQLException {
        return service.getAllService();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdColaborador(@PathParam("id") int idColaborador) throws SQLException {
        return service.getByIdService(idColaborador);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(EnderecoColaborador enderecoColaborador) throws SQLException {
        return service.insertService(enderecoColaborador);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateByIdColaborador(@PathParam("id") int idColaborador, EnderecoColaborador enderecoColaborador) throws SQLException {
        return service.updateService(idColaborador, enderecoColaborador);
    }

    @DELETE
    @Path("{id}")
    public Response deleteByIdColaborador(@PathParam("id") int idColaborador) throws SQLException {
        return service.deleteService(idColaborador);
    }
}
