package org.acme.Controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/depositar")
public class Depositar {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response depositar(@FormParam("numeroConta") String numeroConta, @FormParam("valorDeposito") double valorDeposito) {

        return Response.ok("Depósito realizado com sucesso!").build();

    }
}