package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.Bairro;
import org.example.models.repositories.BairroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BairroService {
    private BairroRepository repository = new BairroRepository();

    public Response getAllService() throws SQLException {
        List<Bairro> bairros = repository.findAll();

        if (bairros.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(bairros).build();
    }



    public Response getByIdService(int id) throws SQLException {
        Bairro bairro = repository.find(id).orElse(null);

        if (bairro == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(bairro).build();
    }



    public Response insertService(Bairro bairro) throws SQLException {

        if (bairro == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(bairro);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, Bairro bairro) throws SQLException {
        if (repository.find(id).isPresent()) {
            bairro.setId(id);
            repository.update(bairro);
            Optional<Bairro> bairroAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(bairroAtualizado).build();
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
