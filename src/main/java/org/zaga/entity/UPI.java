package org.zaga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UPI extends PanacheEntity {

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String customer_account_number;

    @Column(nullable = false)
    private String upi_id;    


}
