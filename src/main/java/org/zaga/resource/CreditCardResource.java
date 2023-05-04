package org.zaga.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.zaga.dto.CreditCardDto;
import org.zaga.entity.CreditCard;
import org.zaga.service.CreditCardService;


@Path("/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreditCardResource {

    @Inject
    CreditCardService service;

    @Inject
    CreditCardDto dto;

    // @GET
    // @Path("/verify")
    // public Response verifyAccount(CreditCardDto dto){
    //     CreditCard card = service.verifyAccount(dto);
    //     System.out.println("-------------------");
    //     System.out.println(card);
    //     return Response.ok(card).build();
    // }

    
}
