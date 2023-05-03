package org.zaga.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.zaga.entity.UPI;
import org.zaga.service.UPIService;

@Path("/upi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UPIResource {
    
    @Inject
    UPIService service;

    @GET
    @Path("/verify")
    public Response verifyAccount(@QueryParam("name") String name, @QueryParam("upi_id") String upi_id){
        UPI upi = service.verifyAccount(upi_id, name);
        System.out.println("-------------------");
        System.out.println(upi);
        return Response.ok(upi).build();

    }

}
