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
public class CustomerBankAccount extends PanacheEntity{
    
    @Column(nullable = false)
    private String account_holder_name;

    @Column(nullable = false)
    private String customer_account_number;

    @Column(nullable = false)
    private String bank_name;

    @Column(nullable = false)
    private String bank_branch;

    @Column(nullable = false)
    private String ifsc_code;

    @Column(nullable = false)
    private String bank_balance;
}
