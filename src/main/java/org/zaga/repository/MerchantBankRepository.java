package org.zaga.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.zaga.dto.EventDto;
import org.zaga.entity.MerchantBankAccount;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class MerchantBankRepository implements PanacheRepository{

    @Inject
    EventDto dto;

    private Double balance;
    private Double purchaseAmount;
    private Double newBalance;
    private Double orderAmount;

    @Inject
    @Channel("merchant-balance")
    Emitter<Double> emitter;

    @Inject
    @Channel("purchase-amount")
    Emitter<Double> emitter1;

    @Incoming("merchant-account")
    @Blocking
    @ActivateRequestContext
    public void balanceFetchUsingAccountNumber(String merchantAccountNumber){
        System.out.println("----------------");
        System.out.println("Merchant Account number "+merchantAccountNumber);
        PanacheQuery<MerchantBankAccount> accountDetails = MerchantBankAccount.find("merchant_account_number=?1", merchantAccountNumber);
        MerchantBankAccount merchantAccount = accountDetails.firstResult();
        System.out.println("----------------");
        System.out.println("Merchant Account Details "+merchantAccount);
        balance = merchantAccount.getBank_balance();
        Double accountBalance = balance;
        emitter.send(accountBalance);
    }

    @Incoming("customer-order-amount")
    @Blocking
    public void orderAmount(Double customerOrderAmount){
       purchaseAmount = customerOrderAmount;      
    }
    
   
    

    @Incoming("amount-credit")
    @Blocking
    public void creditAmount(Double accountBalance){
       newBalance = accountBalance + purchaseAmount;
       MerchantBankAccount merchantAccount = new MerchantBankAccount();
       merchantAccount.setBank_balance(newBalance);
       System.out.println("Amount of" +purchaseAmount +"is credited to your account. New balance is "+newBalance);
    }

 

}
