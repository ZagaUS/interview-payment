package org.zaga.service;

import org.zaga.entity.UPI;

public interface UPIService {
    
    UPI verifyAccount(String upi_id, String name);
}
