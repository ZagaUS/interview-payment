package org.zaga.repository;

import javax.enterprise.context.ApplicationScoped;

import org.zaga.entity.PaymentDetails;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
// import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;


@ApplicationScoped
public class PaymentDetailsRepository implements PanacheRepository<PaymentDetails> {
    
}
