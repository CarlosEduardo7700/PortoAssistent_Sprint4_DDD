package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.Genero;
import org.example.models.repositories.GeneroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GeneroService {
    private GeneroRepository repository = new GeneroRepository();

    public Response getAllService() throws SQLException {
        List<Genero> generos = repository.findAll();

        if (generos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(generos).build();
    }



    public Response getByIdService(int id) throws SQLException {
        Genero genero = repository.find(id).orElse(null);

        if (genero == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(genero).build();
    }



    public Response insertService(Genero genero) throws SQLException {

        if (genero == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(genero);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, Genero genero) throws SQLException {
        if (repository.find(id).isPresent()) {
            genero.setId(id);
            repository.update(genero);
            Optional<Genero> generoAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(generoAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }



    public Response deleteService(int id) throws SQLException {
        if (repository.find(id).isPresent()) {
            repository.delete(id);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }

}
