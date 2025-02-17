package com.japStudy.ssafyStudy.repository;

import com.japStudy.ssafyStudy.domain.item.Item;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ItemRepository implements IItemRepository {
    private final EntityManager em;
    @Override
    @Transactional(readOnly = true)
    public void save(Item item) {
        if(item.getId()==null){
            em.persist(item);
        }else{
            em.merge(item);
        }
    }

    @Override
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
