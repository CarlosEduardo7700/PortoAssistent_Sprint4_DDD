package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Medida;
import org.example.models.Tipo_Modal;
import org.example.models.repositories.MedidaRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/medida")
public class MedidaResource {
    private MedidaRepository repository = new MedidaRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medida> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medida getById(@PathParam("id") int id) throws SQLException {
        Medida medida = repository.find(id).orElse(null);
        return medida;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Medida medida) throws SQLException {
        repository.add(medida);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Medida medida) throws SQLException {
        if (repository.find(id).isPresent()) {
            medida.setIdMedida(id);
            repository.update(medida);
            Optional<Medida> medidaAtualizada = repository.find(id);
            return Response.status(Response.Status.OK).entity(medidaAtualizada).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(medida).build();
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
