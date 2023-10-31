package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Modal;
import org.example.models.repositories.ModalRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/modal")
public class ModalResource {
    private ModalRepository repository = new ModalRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modal> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Modal getById(@PathParam("id") int id) throws SQLException {
        Modal modal = repository.find(id).orElse(null);
        return modal;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Modal modal) throws SQLException {
        repository.add(modal);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Modal modal) throws SQLException {
        if (repository.find(id).isPresent()) {
            modal.setId(id);
            repository.update(modal);
            Optional<Modal> modalAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(modalAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(modal).build();
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
