package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Modal_Colab;
import org.example.models.repositories.Modal_ColabRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/modal-colaborador")
public class Modal_ColabResource {
    private Modal_ColabRepository repository = new Modal_ColabRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modal_Colab> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Modal_Colab getById(@PathParam("id") int id) throws SQLException {
        Modal_Colab modalColab = repository.find(id).orElse(null);
        return modalColab;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Modal_Colab modalColab) throws SQLException {
        repository.add(modalColab);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Modal_Colab modalColab) throws SQLException {
        if (repository.find(id).isPresent()) {
            modalColab.getColaborador().setId(id);
            repository.update(modalColab);
            Optional<Modal_Colab> modalColabAtualizado = repository.find(id);
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
