package org.zaga.repository;

import javax.enterprise.context.ApplicationScoped;

import org.zaga.entity.UPI;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UPIRepository implements PanacheRepository<UPI>{

    public UPI getUPIDetails(String upi_id, String name){
        System.out.println(upi_id +"    ----   " + name);
        PanacheQuery<UPI> details = UPI.find("upi_id=?1", upi_id);
        UPI upi = details.firstResult();
        System.out.println("---------------");
        System.out.println(upi);
        return upi;
        }
    
}
