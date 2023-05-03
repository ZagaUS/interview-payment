package org.zaga.serviceImplementation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.zaga.entity.PaymentDetails;
import org.zaga.repository.PaymentDetailsRepository;
import org.zaga.service.PaymentDetailsService;

@ApplicationScoped
public class PaymentDetailsServiceImpl implements PaymentDetailsService{

    @Inject
    PaymentDetailsRepository repo;

    @Override
    public PaymentDetails createPaymentDetails(PaymentDetails paymentDetails) {
        PaymentDetails.persist(paymentDetails);
        return paymentDetails;
    }

    

    
}
