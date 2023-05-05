package org.zaga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.zaga.dto.CreditCardDto;
import org.zaga.dto.EventDto;
import org.zaga.entity.CreditCard;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;
// import io.smallrye.reactive.messaging.annotations.KafkaListener;

@ApplicationScoped
public class CreditCardRepository implements PanacheRepository<CreditCard> {

    @Inject
    CreditCardDto dto;

    @Inject
    EventDto eventDto;

    @Inject
    CreditCard creditCard;

    @Inject
    @Channel("card-account-details")
    Emitter<Object> emitter;



    @Incoming("creditcard-payment")
    @Blocking
    @ActivateRequestContext
    // @Transactional
    public void verifyAccount(CreditCardDto dto){
        PanacheQuery<CreditCard> details = CreditCard.find("card_number=?1 and cvv=?2 and expiry_date=?3 and name=?4", dto.getCard_number(), dto.getCvv(),dto.getExpiry_date(),dto.getName());
        CreditCard carddetails = details.firstResult();
        EventDto eventDto = new EventDto();
        eventDto.setAccount_number(carddetails.getCustomer_account_number());
        eventDto.setName(carddetails.getName());
        emitter.send(eventDto);  
      
    }

    
}
