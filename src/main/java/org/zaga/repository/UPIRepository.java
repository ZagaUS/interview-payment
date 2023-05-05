package org.zaga.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.naming.event.ObjectChangeListener;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.zaga.dto.EventDto;
import org.zaga.dto.UPIDto;
import org.zaga.entity.UPI;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class UPIRepository implements PanacheRepository<UPI>{

    @Inject
    UPIDto dto;

    @Inject
    UPI upi;

    @Inject
    EventDto eventDto;

    @Inject
    @Channel("upi-account-details")
    Emitter<Object> emitter;

    @Incoming("upi-payment")
    @Blocking
    @ActivateRequestContext
    public void verifyAccount(UPIDto dto){
        PanacheQuery<UPI> details = UPI.find("upi_id=?1 and name=?2", dto.getUpi_id(),dto.getName());
        UPI upidetails = details.firstResult();
        System.out.println(upidetails);
        EventDto eventDto = new EventDto();
        eventDto.setAccount_number(upidetails.getCustomer_account_number());
        eventDto.setName(upidetails.getName());
        emitter.send(eventDto);  
        }
    }
    
