package org.zaga.repository;

import javax.enterprise.context.ApplicationScoped;

import org.zaga.entity.CreditCard;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CreditCardRepository implements PanacheRepository<CreditCard> {

    public CreditCard getCreditCardDetails(String card_number, String cvv, String expiry_date, String name){
    PanacheQuery<CreditCard> details = CreditCard.find("card_number=?1 and cvv=?2 and expiry_date=?3 and name=?4", card_number, cvv, expiry_date, name);
    CreditCard cd = details.firstResult();
    return cd;
    }



    
}
