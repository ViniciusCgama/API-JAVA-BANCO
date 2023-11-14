package org.acme.Controllers;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sacar")
public abstract class Sacar {



    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public abstract Response sacar(@FormParam(value = "numeroConta") String numeroConta, @FormParam("valorSaque") double valorSaque);
}
