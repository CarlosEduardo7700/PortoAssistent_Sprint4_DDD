package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.Colaborador;
import org.example.models.TelefoneCliente;
import org.example.models.repositories.ColaboradorRepository;
import org.example.models.repositories.TelefoneClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TelefoneClienteService {

    private TelefoneClienteRepository repository = new TelefoneClienteRepository();

    public Response getAllService() throws SQLException {
        List<TelefoneCliente> telefonesClientes = repository.findAll();

        if (telefonesClientes.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(telefonesClientes).build();
    }



    public Response getByIdService(int id) throws SQLException {
        TelefoneCliente telefoneCliente = repository.find(id).orElse(null);

        if (telefoneCliente == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(telefoneCliente).build();
    }



    public Response insertService(TelefoneCliente telefoneCliente) throws SQLException {

        if (telefoneCliente == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(telefoneCliente);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, TelefoneCliente telefoneCliente) throws SQLException {
        if (repository.find(id).isPresent()) {
            telefoneCliente.getCliente().setId(id);
            repository.update(telefoneCliente);
            Optional<TelefoneCliente> telefoneClienteAtualizado = repository.find(id);
            return Response.status(Response.Status.OK).entity(telefoneClienteAtualizado).build();
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
