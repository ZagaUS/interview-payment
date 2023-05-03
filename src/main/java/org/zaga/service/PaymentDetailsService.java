package org.zaga.service;

import javax.enterprise.context.ApplicationScoped;

import org.zaga.entity.PaymentDetails;


public interface PaymentDetailsService {
    
    PaymentDetails createPaymentDetails(PaymentDetails paymentDetails);
}
