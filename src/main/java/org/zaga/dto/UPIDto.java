package org.zaga.dto;

import javax.enterprise.context.ApplicationScoped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApplicationScoped
public class UPIDto {

    private String name;
    private String upi_id;
    // private String amount;
    
}
