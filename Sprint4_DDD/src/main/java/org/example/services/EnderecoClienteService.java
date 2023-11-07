package org.example.services;

import jakarta.ws.rs.core.Response;
import org.example.models.EnderecoCliente;
import org.example.models.repositories.EnderecoClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EnderecoClienteService {
    private EnderecoClienteRepository repository = new EnderecoClienteRepository();

    public Response getAllService() throws SQLException {
        List<EnderecoCliente> enderecosClientes = repository.findAll();

        if (enderecosClientes.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Nenhuma informação encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(enderecosClientes).build();
    }



    public Response getByIdService(int id) throws SQLException {
        EnderecoCliente enderecoCliente = repository.findByCliente(id).orElse(null);

        if (enderecoCliente == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(enderecoCliente).build();
    }



    public Response insertService(EnderecoCliente enderecoCliente) throws SQLException {

        if (enderecoCliente == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Dados inválidos! Reveja os dados da sua solicitação.").build();
        } else {
            repository.add(enderecoCliente);

            return Response.status(Response.Status.CREATED).build();
        }
    }



    public Response updateService(int id, EnderecoCliente enderecoCliente) throws SQLException {
        if (repository.findByCliente(id).isPresent()) {
            enderecoCliente.getCliente().setId(id);
            repository.updateByIdCliente(enderecoCliente);
            Optional<EnderecoCliente> enderecoClienteAtualizado = repository.findByCliente(id);
            return Response.status(Response.Status.OK).entity(enderecoClienteAtualizado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }



    public Response deleteService(int id) throws SQLException {
        if (repository.findByCliente(id).isPresent()) {
            repository.deleteByIdCliente(id);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Informação não encontrada!").build();
    }
}
