package net.api.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_record")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    private String status;
    private String customer;
    private String product;
    private double revenue;  
    
}
