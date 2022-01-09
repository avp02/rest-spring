package by.avp.customer_demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "costumer")
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    private String address;
    private BigDecimal budget;
}
