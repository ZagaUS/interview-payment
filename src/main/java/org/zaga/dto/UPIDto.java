package org.zaga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UPIDto {

    private String name;
    private String upi_id;
    private String amount;
    
}
