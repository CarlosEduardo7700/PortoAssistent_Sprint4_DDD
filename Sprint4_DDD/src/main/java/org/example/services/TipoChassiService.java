package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.TipoChassi;
import org.example.models.repositories.TipoChassiRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TipoChassiService {

    private TipoChassiRepository repository = new TipoChassiRepository();

    public Response getAllService() throws SQLException {
        List<TipoChassi> tiposChassis = repository.findAll();

        if (tiposChassis.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(tiposChassis).build();
    }



    public Response getByIdService(int id) throws SQLException {
        TipoChassi tipoChassi = repository.find(id).orElse(null);

        if (tipoChassi == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(tipoChassi).build();
    }



    public Response insertService(TipoChassi tipoChassi) throws SQLException {

        if (tipoChassi == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(tipoChassi);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, TipoChassi tipoChassi) throws SQLException {
        if (repository.find(id).isPresent()) {
            tipoChassi.setId(id);
            repository.update(tipoChassi);
            Optional<TipoChassi> tipoChassiAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(tipoChassiAtualizado).build();
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
