package org.zaga.dto;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
@ApplicationScoped
public class CreditCardDto {

    private String name;
    private String card_number;
    private String expiry_date;
    private String cvv;
    private String amount;
    
}
