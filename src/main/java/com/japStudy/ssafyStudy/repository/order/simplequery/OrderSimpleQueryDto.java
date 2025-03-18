package com.japStudy.ssafyStudy.repository.order.simplequery;

import com.japStudy.ssafyStudy.domain.Address;
import com.japStudy.ssafyStudy.domain.Order;
import com.japStudy.ssafyStudy.domain.OrderStatus;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderSimpleQueryDto {
    private Long OrderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus,
                               Address address) {
        OrderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    }
}