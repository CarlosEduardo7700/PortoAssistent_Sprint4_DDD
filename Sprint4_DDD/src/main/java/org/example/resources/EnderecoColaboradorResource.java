package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.EnderecoColaborador;
import org.example.models.repositories.EnderecoColaboradorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Path("/endereco-colaborador")
public class EnderecoColaboradorResource {
    private EnderecoColaboradorRepository repository = new EnderecoColaboradorRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnderecoColaborador> getAll() throws SQLException {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoColaborador getByIdColaborador(@PathParam("id") int idColaborador) throws SQLException {
        EnderecoColaborador enderecoColaborador = repository.findByColaborador(idColaborador).orElse(null);
        return enderecoColaborador;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(EnderecoColaborador enderecoColaborador) throws SQLException {
        repository.add(enderecoColaborador);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateByIdColaborador(@PathParam("id") int idColaborador, EnderecoColaborador enderecoColaborador) throws SQLException {
        if (repository.findByColaborador(idColaborador).isPresent()) {
            enderecoColaborador.getColaborador().setIdColaborador(idColaborador);
            repository.updateByIdColaborador(enderecoColaborador);
            Optional<EnderecoColaborador> enderecoColaboradorAtualizado = repository.findByColaborador(idColaborador);
            return Response.status(Response.Status.OK).entity(enderecoColaboradorAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity(enderecoColaborador).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteByIdColaborador(@PathParam("id") int idColaborador) throws SQLException {
        if (repository.findByColaborador(idColaborador).isPresent()) {
            repository.deleteByIdColaborador(idColaborador);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
