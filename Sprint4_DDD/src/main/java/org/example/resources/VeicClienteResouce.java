package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.VeicCliente;
import org.example.models.repositories.VeicClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/veiculo-cliente")
public class VeicClienteResouce {
    private VeicClienteRepository repository = new VeicClienteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VeicCliente> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public VeicCliente getById(@PathParam("id") int id) throws SQLException {
        VeicCliente veicCliente = repository.find(id).orElse(null);
        return veicCliente;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(VeicCliente veicCliente) throws SQLException {
        repository.add(veicCliente);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, VeicCliente veicCliente) throws SQLException {
        if (repository.find(id).isPresent()) {
            veicCliente.getCliente().setId(id);
            repository.update(veicCliente);
            Optional<VeicCliente> veicClienteAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(veicClienteAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(veicCliente).build();
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
