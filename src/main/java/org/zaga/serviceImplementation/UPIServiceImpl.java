package org.zaga.serviceImplementation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.zaga.entity.UPI;
import org.zaga.repository.UPIRepository;
import org.zaga.service.UPIService;
@ApplicationScoped
public class UPIServiceImpl implements UPIService{

    @Inject
    UPIRepository repo;

    @Override
    public UPI verifyAccount(String upi_id,String name) {
        UPI upi = repo.getUPIDetails(upi_id, name);
        return upi;

    }
    
}
