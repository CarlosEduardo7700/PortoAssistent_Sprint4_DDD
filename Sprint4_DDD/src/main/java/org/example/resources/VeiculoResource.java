package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Veiculo;
import org.example.models.repositories.VeiculoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/veiculo")
public class VeiculoResource {
    private VeiculoRepository repository = new VeiculoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo getById(@PathParam("id") int id) throws SQLException {
        Veiculo veiculo = repository.find(id).orElse(null);
        return veiculo;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Veiculo veiculo) throws SQLException {
        repository.add(veiculo);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Veiculo veiculo) throws SQLException {
        if (repository.find(id).isPresent()) {
            veiculo.setId(id);
            repository.update(veiculo);
            Optional<Veiculo> veiculoAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(veiculoAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(veiculo).build();
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
