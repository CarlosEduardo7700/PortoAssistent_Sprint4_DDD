package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.TelefoneCliente;
import org.example.models.TelefoneColaborador;
import org.example.models.repositories.TelefoneClienteRepository;
import org.example.models.repositories.TelefoneColaboradorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TelefoneColaboradorService {

    private TelefoneColaboradorRepository repository = new TelefoneColaboradorRepository();

    public Response getAllService() throws SQLException {
        List<TelefoneColaborador> telefonesColaboradores = repository.findAll();

        if (telefonesColaboradores.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(telefonesColaboradores).build();
    }



    public Response getByIdService(int id) throws SQLException {
        TelefoneColaborador telefoneColaborador = repository.find(id).orElse(null);

        if (telefoneColaborador == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(telefoneColaborador).build();
    }



    public Response insertService(TelefoneColaborador telefoneColaborador) throws SQLException {

        if (telefoneColaborador == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(telefoneColaborador);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, TelefoneColaborador telefoneColaborador) throws SQLException {
        if (repository.find(id).isPresent()) {
            telefoneColaborador.getColaborador().setId(id);
            repository.update(telefoneColaborador);
            Optional<TelefoneColaborador> telefoneColaboradorAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(telefoneColaboradorAtualizado).build();
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
