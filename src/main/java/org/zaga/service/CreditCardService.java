package org.zaga.service;

import org.zaga.entity.CreditCard;

public interface CreditCardService {
    
    CreditCard verifyAccount(String card_number, String cvv, String expiry_date, String name);
}
