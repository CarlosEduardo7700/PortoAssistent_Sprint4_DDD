package org.example.services;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.example.models.Bairro;
import org.example.models.repositories.BairroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BairroService {
    private BairroRepository repository = new BairroRepository();

    public Response getByIdService(int id) throws SQLException {
        Bairro bairro = repository.find(id).orElse(null);

        if (bairro == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("A informação solicitada não foi encontrada!").build();
        }

        return Response.status(Response.Status.OK).entity(bairro).build();
    }
}
