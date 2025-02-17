package com.japStudy.ssafyStudy.service;

import com.japStudy.ssafyStudy.domain.Order;
import java.util.List;

public interface IOrderService {
    Long order(Long memberId, Long itemId, int count);
    void cancelOrder(Long orderId);
//    List<Order> findOrders(OrderSearch orderSearch)

}
