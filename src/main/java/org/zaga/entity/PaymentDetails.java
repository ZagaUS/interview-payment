package org.zaga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class PaymentDetails extends PanacheEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long customer_id;

    @Column(nullable = false)
    private String merchant_account_number;

    @Column(nullable = false)
    private String payment_type;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = true)
    private String card_number;

    @Column(nullable = true)
    private String expiry_date;

    @Column(nullable = true)
    private String cvv;

    @Column(nullable = true)
    private String upi_id;
 
}
