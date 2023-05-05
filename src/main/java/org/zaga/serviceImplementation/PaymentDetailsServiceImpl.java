package org.zaga.serviceImplementation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
    @Channel("creditcard-details")
    Emitter<Object> emitter;

    @Inject
    @Channel("upi-details")
    Emitter<Object> emitter1;

    @Inject
    @Channel("merchant-account-number")
    Emitter<String> emitter3;

    @Inject
    @Channel("amount-details")
    Emitter<Double> emitter4;

    @Inject
    CreditCardDto dto;

    @Inject
    UPIDto dto2;


    @Override
    @Transactional
    public PaymentDetails createPaymentDetails(PaymentDetails details) {
       

        if(details.getPayment_type().equalsIgnoreCase("CreditCardPayment")){
            System.out.println("-----------");
        System.out.println("Payment Type "+details.getPayment_type());
        CreditCardDto dto = new CreditCardDto();    
        dto.setCard_number(details.getCard_number());
        dto.setCvv(details.getCvv());
        dto.setExpiry_date(details.getExpiry_date());
        dto.setName(details.getName());
        emitter.send(dto);
        
        }

        if(details.getPayment_type().equalsIgnoreCase("UPIPayment")){
        System.out.println("-----------");
        System.out.println("Payment Type "+details.getPayment_type());
        UPIDto dto2 = new UPIDto();
        dto2.setName(details.getName());
        dto2.setUpi_id(details.getUpi_id());
        emitter1.send(dto2);
    
        }


        Double orderAmount = details.getAmount();
        emitter4.send(orderAmount);
        String merchantAccountNumber = details.getMerchant_account_number();
        emitter3.send(merchantAccountNumber);

        PaymentDetails.persist(details);      
        return details;

    }

    }

    

    

