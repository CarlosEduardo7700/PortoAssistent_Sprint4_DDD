package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.Bairro;
import org.example.models.Cidade;
import org.example.models.repositories.CidadeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CidadeService {
    private CidadeRepository repository = new CidadeRepository();

    public Response getAllService() throws SQLException {
        List<Cidade> cidades = repository.findAll();

        if (cidades.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(cidades).build();
    }



    public Response getByIdService(int id) throws SQLException {
        Cidade cidade = repository.find(id).orElse(null);

        if (cidade == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(cidade).build();
    }



    public Response insertService(Cidade cidade) throws SQLException {

        if (cidade == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(cidade);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, Cidade cidade) throws SQLException {
        if (repository.find(id).isPresent()) {
            cidade.setId(id);
            repository.update(cidade);
            Optional<Cidade> cidadeAtualizada = repository.find(id);
            return Response.status(Response.Status.OK).entity(cidadeAtualizada).build();
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
