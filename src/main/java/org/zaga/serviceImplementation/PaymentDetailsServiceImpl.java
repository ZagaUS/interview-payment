package org.zaga.serviceImplementation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.zaga.dto.CreditCardDto;
import org.zaga.dto.UPIDto;
import org.zaga.entity.CreditCard;
import org.zaga.entity.PaymentDetails;
import org.zaga.repository.PaymentDetailsRepository;
import org.zaga.service.PaymentDetailsService;
import org.eclipse.microprofile.reactive.messaging.Emitter;

// import io.smallrye.reactive.messaging.annotations.Channel;

@ApplicationScoped
public class PaymentDetailsServiceImpl implements PaymentDetailsService{

    @Inject
    PaymentDetailsRepository repo;

    @Inject
    @Channel("mail-out")
    Emitter<Object> emitter;

    @Inject
    CreditCardDto dto;

    @Inject
    UPIDto dto2;


    @Override
    public PaymentDetails createPaymentDetails(PaymentDetails details) {
        System.out.println("----------------" +details.getPayment_type());
        // try{

        if(details.getPayment_type().equalsIgnoreCase("CreditCardPayment")){
            System.out.println("-------------");
        CreditCardDto dto = new CreditCardDto();    
        dto.setAmount(details.getAmount());
        dto.setCard_number(details.getCard_number());
        dto.setCvv(details.getCvv());
        dto.setExpiry_date(details.getExpiry_date());
        dto.setName(details.getName());
        System.out.println("-----------------------------");
        System.out.println(dto);
        // emitter.send(dto);
        emitter.send(dto);
        
    }

    else if(details.getPayment_type().equalsIgnoreCase("UPIPayment")){
        System.out.println("-----------");
        UPIDto dto2 = new UPIDto();
        dto2.setAmount(details.getAmount());
        dto2.setName(details.getName());
        dto2.setUpi_id(details.getUpi_id());
        // emitter.send("hai from dto2");
        emitter.send(dto2);
    
    }

        PaymentDetails.persist(details);      
        return details;

        }
        // catch(Exception e){
        //     return WebApplicationException
            
        // }

    }

    

    

