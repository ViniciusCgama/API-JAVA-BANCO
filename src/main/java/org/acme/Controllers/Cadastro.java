package org.acme.Controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/cadastrar")
public class Cadastro {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response cadastrar(@FormParam("nome") String nome, @FormParam("cpf") String cpf) {
        if (nome == null || cpf == null || nome.isEmpty() || cpf.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Nome e CPF são obrigatórios.").build();
        }

        return Response.ok("Cadastro realizado com sucesso!").build();
    }
}
