package org.zaga.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.zaga.entity.CreditCard;
import org.zaga.service.CreditCardService;


@Path("/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreditCardResource {

    @Inject
    CreditCardService service;

    @GET
    @Path("/verify")
    public Response verifyAccount(@QueryParam("card_number") String card_number, @QueryParam("cvv") String cvv, @QueryParam("expiry_date")String expiry_date,@QueryParam("name") String name ){
        CreditCard card = service.verifyAccount(card_number, cvv, expiry_date, name);
        System.out.println("-------------------");
        System.out.println(card);
        return Response.ok(card).build();
    }

    
}
