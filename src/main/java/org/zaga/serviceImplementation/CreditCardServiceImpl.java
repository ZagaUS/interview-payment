package org.zaga.serviceImplementation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.zaga.entity.CreditCard;
import org.zaga.repository.CreditCardRepository;
import org.zaga.service.CreditCardService;
@ApplicationScoped
public class CreditCardServiceImpl implements CreditCardService {

    @Inject
    CreditCardRepository repo;

    @Override
    public CreditCard verifyAccount(String card_number, String cvv, String expiry_date, String name) {
        CreditCard card1 = repo.getCreditCardDetails(card_number, cvv, expiry_date, name);
        return card1;
        
    }
    
}
