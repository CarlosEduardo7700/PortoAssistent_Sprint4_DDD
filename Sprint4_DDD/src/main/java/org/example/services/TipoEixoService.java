package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.TipoEixo;
import org.example.models.repositories.TipoEixoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TipoEixoService {

    private TipoEixoRepository repository = new TipoEixoRepository();

    public Response getAllService() throws SQLException {
        List<TipoEixo> tiposEixos = repository.findAll();

        if (tiposEixos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(tiposEixos).build();
    }



    public Response getByIdService(int id) throws SQLException {
        TipoEixo tipoEixo = repository.find(id).orElse(null);

        if (tipoEixo == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(tipoEixo).build();
    }



    public Response insertService(TipoEixo tipoEixo) throws SQLException {

        if (tipoEixo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(tipoEixo);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, TipoEixo tipoEixo) throws SQLException {
        if (repository.find(id).isPresent()) {
            tipoEixo.setId(id);
            repository.update(tipoEixo);
            Optional<TipoEixo> tipoEixoAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(tipoEixoAtualizado).build();
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
