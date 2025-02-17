package com.japStudy.ssafyStudy.repository;

import com.japStudy.ssafyStudy.domain.Order;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository implements IOrderRepository {
    private final EntityManager em;

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }
}
