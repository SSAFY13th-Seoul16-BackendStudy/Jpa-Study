package com.japStudy.ssafyStudy.service;

import com.japStudy.ssafyStudy.domain.Delivery;
import com.japStudy.ssafyStudy.domain.DeliveryStatus;
import com.japStudy.ssafyStudy.domain.Member;
import com.japStudy.ssafyStudy.domain.Order;
import com.japStudy.ssafyStudy.domain.OrderItem;
import com.japStudy.ssafyStudy.domain.item.Item;
import com.japStudy.ssafyStudy.repository.IItemRepository;
import com.japStudy.ssafyStudy.repository.IMemberRepository;
import com.japStudy.ssafyStudy.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {
    private final IMemberRepository memberRepository;
    private final IOrderRepository orderRepository;
    private final IItemRepository itemRepository;

    @Override
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        OrderItem orderItem = OrderItem.createOrderItem(item,item.getPrice(),count);

        Order order = Order.createOrder(member,delivery,orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancle();
    }
}
