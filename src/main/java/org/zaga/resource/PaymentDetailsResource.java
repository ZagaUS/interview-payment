package org.zaga.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.zaga.dto.CreditCardDto;
import org.zaga.dto.UPIDto;
import org.zaga.entity.PaymentDetails;
import org.zaga.service.PaymentDetailsService;

@Path("/paymentDetails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentDetailsResource {

    @Inject
    PaymentDetailsService service;

    @POST
    @Path("/createPaymentDetails")
    @Transactional
    public Response createPaymentDetails(PaymentDetails paymentDetails){
    PaymentDetails details = service.createPaymentDetails(paymentDetails);    
    return Response.ok(details).build();    
    }
}
