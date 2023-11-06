package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.ModalColab;
import org.example.models.repositories.ModalColabRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/modal-colaborador")
public class ModalColabResource {
    private ModalColabRepository repository = new ModalColabRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModalColab> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ModalColab getById(@PathParam("id") int id) throws SQLException {
        ModalColab modalColab = repository.find(id).orElse(null);
        return modalColab;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(ModalColab modalColab) throws SQLException {
        repository.add(modalColab);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, ModalColab modalColab) throws SQLException {
        if (repository.find(id).isPresent()) {
            modalColab.getColaborador().setId(id);
            repository.update(modalColab);
            Optional<ModalColab> modalColabAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(modalColabAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(modalColab).build();
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
