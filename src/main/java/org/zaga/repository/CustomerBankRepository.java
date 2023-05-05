package org.zaga.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.zaga.dto.EventDto;
import org.zaga.entity.CustomerBankAccount;
import org.zaga.entity.PaymentDetails;

import antlr.debug.Event;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;


@ApplicationScoped
public class CustomerBankRepository implements PanacheRepository{

    @Inject
    EventDto dto;

    private Double balance;
    private Double customerOrderAmount;
    private Double newBalance;
    private String merchant_account_number;

    @Inject
    @Channel("balance-fetching")
    Emitter<Double> emitter;

    @Inject
    @Channel("account-sending")
    Emitter<String> emitter1;

    @Inject
    @Channel("amount-sending")
    Emitter<Double> emitter2;

    @Incoming("customer-card-account-number")
    @Blocking
    @ActivateRequestContext
    public void balanceFetchUsingCard(EventDto dto){
        System.out.println("----------------");
        PanacheQuery<CustomerBankAccount> accountDetails = CustomerBankAccount.find("customer_account_number=?1 and account_holder_name=?2", dto.getAccount_number(), dto.getName());
        CustomerBankAccount customerAccount = accountDetails.firstResult();
        System.out.println("Customer Account Details "+customerAccount);
        balance = customerAccount.getBank_balance();
        Double accountBalance = balance;
        emitter.send(accountBalance);
    }
    
    @Incoming("customer-upi-account-number")
    @Blocking
    @ActivateRequestContext
    public void balanceFetchUsingUPI(EventDto dto){
        System.out.println("----------------");
        PanacheQuery<CustomerBankAccount> accountDetails = CustomerBankAccount.find("customer_account_number=?1 and account_holder_name=?2", dto.getAccount_number(), dto.getName());
        CustomerBankAccount customerAccount = accountDetails.firstResult();
        System.out.println("Customer Account Details "+customerAccount);
        balance = customerAccount.getBank_balance();
        Double accountBalance = balance;
        emitter.send(accountBalance);
    }

     @Incoming("order-amount")
     @Blocking
     public void orderAmount(Double orderAmount){
        customerOrderAmount = orderAmount;      
     }

  

     @Incoming("sending-merchant-account")
     @Blocking
     public void sendMerchantAccountNumber(String merchantAccountNumber){
        merchant_account_number = merchantAccountNumber;
     }

     @Incoming("amount-deduction")
     @Blocking
     public void deductAmount(Double accountBalance){
        newBalance = accountBalance - customerOrderAmount;
        CustomerBankAccount customerAccount = new CustomerBankAccount();
        customerAccount.setBank_balance(newBalance);
        System.out.println("Amount of "+customerOrderAmount+" is debited from your account. New balance is " + newBalance);        
        emitter1.send(merchant_account_number);
        emitter2.send(customerOrderAmount);
     }
    
}
