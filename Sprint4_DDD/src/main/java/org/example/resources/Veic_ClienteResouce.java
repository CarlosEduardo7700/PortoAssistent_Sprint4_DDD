package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Veic_Cliente;
import org.example.models.repositories.Veic_ClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/veiculo-cliente")
public class Veic_ClienteResouce {
    private Veic_ClienteRepository repository = new Veic_ClienteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veic_Cliente> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veic_Cliente getById(@PathParam("id") int id) throws SQLException {
        Veic_Cliente veicCliente = repository.find(id).orElse(null);
        return veicCliente;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Veic_Cliente veicCliente) throws SQLException {
        repository.add(veicCliente);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Veic_Cliente veicCliente) throws SQLException {
        if (repository.find(id).isPresent()) {
            veicCliente.getIdCliente().setId(id);
            repository.update(veicCliente);
            Optional<Veic_Cliente> veicClienteAtualizado = repository.find(id);
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
