package by.avp.customer_demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "customer")
public class Customer extends BaseEntity{

//    @Column(name = "first_name")
    private String firstName;

//    @Column(name = "last_name")
    private String lastName;

//    @Column(name = "address")
    private String address;

//    @Column(name = "budget")
    private BigDecimal budget;
}
