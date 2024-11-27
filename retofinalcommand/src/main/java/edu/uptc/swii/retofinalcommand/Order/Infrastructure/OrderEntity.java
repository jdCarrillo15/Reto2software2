package edu.uptc.swii.retofinalcommand.Order.Infrastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "`order`")
public class OrderEntity {
    @Id
    @Column(name = "orderid")
    private String orderid;
    @Column(name = "customerid")
    private String customerid;
    @Column(name = "status")
    private String status;
}
