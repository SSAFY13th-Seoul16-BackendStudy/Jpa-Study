package com.japStudy.ssafyStudy.service;

import static org.junit.jupiter.api.Assertions.*;

import com.japStudy.ssafyStudy.domain.Address;
import com.japStudy.ssafyStudy.domain.Member;
import com.japStudy.ssafyStudy.domain.Order;
import com.japStudy.ssafyStudy.domain.OrderStatus;
import com.japStudy.ssafyStudy.domain.item.Book;
import com.japStudy.ssafyStudy.domain.item.Item;
import com.japStudy.ssafyStudy.exception.NotEnoughStockException;
import com.japStudy.ssafyStudy.repository.IOrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    private  EntityManager em;
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private  IOrderService orderService;

    /**
     *
     * 자동 생성자 주입
     *
     * new OrderRepository(em) 처럼 객체를 직접 생성해주지 않아도 된다.
     * Spring이 관리하는 @Service, @Repository 빈을 직접 주입받을 수 있다.
     * 
     * 테스트 코드에서는 @RequiredArgsConstructor 보다는 @Autowired 를 쓰는것이 일반적
     *
     */

    @Test
    public void 상품_주문() throws Exception{
        //given
        Member member = createMember();
        Item item = createBook("JPA!",10000,10);
        int orderCount = 2;

        //when
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus());
        assertEquals(1,getOrder.getOrderItems().size());
        assertEquals(10000*2, getOrder.getTotalPrice());
        assertEquals(8, item.getStockQuantity());

    }
    @Test
    public void 상품주문_재고수량초과() throws Exception{
        //given
        Member member = createMember();
        Item item = createBook("JPA!",10000,10);

        //when
        int orderCount = 200;

        //then
        assertThrows(NotEnoughStockException.class, ()->{orderService.order(member.getId(), item.getId(), orderCount);});
    }

    @Test
    public void 주문취소() throws Exception{
        //given
        Member member = createMember();
        Item item = createBook("JPA!",10000,10);
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals(OrderStatus.CANCLE, getOrder.getStatus());
        assertEquals(10,item.getStockQuantity());
    }
    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);
        return member;
    }
    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        em.persist(book);
        return book;
    }
}