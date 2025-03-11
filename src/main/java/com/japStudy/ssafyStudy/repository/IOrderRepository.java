package com.japStudy.ssafyStudy.repository;

import com.japStudy.ssafyStudy.domain.Order;
import java.util.List;

public interface IOrderRepository {
    void save(Order order);
    Order findOne(Long id);
    List<Order> findAllByString(OrderSearch orderSearch);
//    List<Order> findAll(OrderSearch orderSearch);
}
