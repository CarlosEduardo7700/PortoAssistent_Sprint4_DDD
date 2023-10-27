package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Tipo_Chassi;
import org.example.models.Tipo_Eixo;
import org.example.models.repositories.Tipo_ChassiRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("tipo-chassi")
public class Tipo_ChassiResource {
    private Tipo_ChassiRepository repository = new Tipo_ChassiRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tipo_Chassi> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tipo_Chassi getById(@PathParam("id") int id) throws SQLException {
        Tipo_Chassi tipoChassi = repository.find(id).orElse(null);
        return tipoChassi;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Tipo_Chassi tipoChassi) throws SQLException {
        repository.add(tipoChassi);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Tipo_Chassi tipoChassi) throws SQLException {
        if (repository.find(id).isPresent()) {
            tipoChassi.setIdChassi(id);
            repository.update(tipoChassi);
            Optional<Tipo_Chassi> tipoChassiAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(tipoChassiAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(tipoChassi).build();
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
