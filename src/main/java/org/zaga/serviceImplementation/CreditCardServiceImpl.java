package org.zaga.serviceImplementation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.zaga.dto.CreditCardDto;
import org.zaga.entity.CreditCard;
import org.zaga.repository.CreditCardRepository;
import org.zaga.service.CreditCardService;
@ApplicationScoped
public class CreditCardServiceImpl implements CreditCardService {

    @Inject
    CreditCardRepository repo;

    @Inject
    CreditCardDto dto;

    // @Override
    // public void verifyAccountDetails(CreditCardDto dto) {
    //     CreditCard card1 = repo.getCreditCardDetails(dto);
    //     System.out.println(card1);
    // }
    
}
