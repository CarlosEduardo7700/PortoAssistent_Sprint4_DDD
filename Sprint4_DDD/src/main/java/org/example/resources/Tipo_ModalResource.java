package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Tipo_Modal;
import org.example.models.repositories.Tipo_ModalRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/tipo-modal")
public class Tipo_ModalResource {
    private Tipo_ModalRepository repository = new Tipo_ModalRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tipo_Modal> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tipo_Modal getById(@PathParam("id") int id) throws SQLException {
        Tipo_Modal tipoModal = repository.find(id).orElse(null);
        return tipoModal;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Tipo_Modal tipoModal) throws SQLException {
        repository.add(tipoModal);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Tipo_Modal tipoModal) throws SQLException {
        if (repository.find(id).isPresent()) {
            tipoModal.setId(id);
            repository.update(tipoModal);
            Optional<Tipo_Modal> tipoModalAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(tipoModalAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(tipoModal).build();
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
