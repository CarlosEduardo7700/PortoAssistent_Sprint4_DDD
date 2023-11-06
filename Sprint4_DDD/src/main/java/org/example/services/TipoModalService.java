package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.TipoModal;
import org.example.models.repositories.TipoModalRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TipoModalService {

    private TipoModalRepository repository = new TipoModalRepository();

    public Response getAllService() throws SQLException {
        List<TipoModal> tiposModais = repository.findAll();

        if (tiposModais.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(tiposModais).build();
    }



    public Response getByIdService(int id) throws SQLException {
        TipoModal tipoModal = repository.find(id).orElse(null);

        if (tipoModal == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(tipoModal).build();
    }



    public Response insertService(TipoModal tipoModal) throws SQLException {

        if (tipoModal == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(tipoModal);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, TipoModal tipoModal) throws SQLException {
        if (repository.find(id).isPresent()) {
            tipoModal.setId(id);
            repository.update(tipoModal);
            Optional<TipoModal> tipoModalAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(tipoModalAtualizado).build();
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
