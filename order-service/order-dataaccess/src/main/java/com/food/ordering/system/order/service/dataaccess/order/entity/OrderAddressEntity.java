package com.food.ordering.system.order.service.dataaccess.order.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_address")
@Entity
public class OrderAddressEntity {
    @Id // Marks this field as the primary key
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL) // Each address is linked to one order (and cascade changes)
    @JoinColumn(name = "ORDER_ID") // Foreign key column in the address table pointing to order ID
    private OrderEntity order;

    private String street;
    private String postalCode;
    private String city;

    // equals() and hashCode() overridden for entity identity comparison based on UUID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderAddressEntity that = (OrderAddressEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
