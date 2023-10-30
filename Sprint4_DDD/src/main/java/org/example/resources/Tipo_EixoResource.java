package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Tipo_Eixo;
import org.example.models.repositories.Tipo_EixoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/tipo-eixo")
public class Tipo_EixoResource {
    private Tipo_EixoRepository repository = new Tipo_EixoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tipo_Eixo> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tipo_Eixo getById(@PathParam("id") int id) throws SQLException {
        Tipo_Eixo tipoEixo = repository.find(id).orElse(null);
        return tipoEixo;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Tipo_Eixo tipoEixo) throws SQLException {
        repository.add(tipoEixo);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Tipo_Eixo tipoEixo) throws SQLException {
        if (repository.find(id).isPresent()) {
            tipoEixo.setIdEixo(id);
            repository.update(tipoEixo);
            Optional<Tipo_Eixo> tipoEixoAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(tipoEixoAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(tipoEixo).build();
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
