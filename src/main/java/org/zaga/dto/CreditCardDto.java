package org.zaga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

    private String name;
    private String card_number;
    private String expiry_date;
    private String cvv;
    private String amount;
    
}
