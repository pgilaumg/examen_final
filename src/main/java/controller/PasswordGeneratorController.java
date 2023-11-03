package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.ResponseApi;
import service.inter.PasswordGeneratorSvcInter;

@Path("/password-generator")
public class PasswordGeneratorController {
    @Inject
    PasswordGeneratorSvcInter generator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get-new-password")
    public ResponseApi generatePassword() {
        return generator.generatePassword();
    }
}
