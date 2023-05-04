package org.zaga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.zaga.dto.CreditCardDto;
import org.zaga.entity.CreditCard;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class CreditCardRepository implements PanacheRepository<CreditCard> {

    @Inject
    CreditCardDto dto;

    @Inject
    CreditCard creditCard;

    @Incoming("mail-in")
    @Blocking
    @ActivateRequestContext
    // @Transactional
    public void addCreditCard(CreditCardDto dto){
        System.out.println("----enter credit card--------");
        System.out.println(dto);
        System.out.println(dto.getClass().getName());
        PanacheQuery<CreditCard> details = CreditCard.find("card_number=?1 and cvv=?2 and expiry_date=?3 and name=?4", dto.getCard_number(), dto.getCvv(),dto.getExpiry_date(),dto.getName());
      
        System.out.println(details.firstResult());
        System.out.println("------------end add cerdit card-----------");
    }

    
}
