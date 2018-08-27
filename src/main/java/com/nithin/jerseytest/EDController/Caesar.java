package com.nithin.jerseytest.EDController;

import javax.ws.rs.*;

@Path("caesar")
public class Caesar {

    @POST
    @Path("encrypt")
    @Consumes("application/x-www-form-urlencoded")
    public String encryption(@FormParam("message") String message, @FormParam("offset") int offset){
        return com.nithin.jerseytest.EDHandler.Caesar.encrypt(message, offset);
    }

    @POST
    @Path("decrypt")
    @Consumes("application/x-www-form-urlencoded")
    public String decryption(@FormParam("message") String message, @FormParam("offset") int offset){
        return com.nithin.jerseytest.EDHandler.Caesar.decrypt(message, offset);
    }

}
