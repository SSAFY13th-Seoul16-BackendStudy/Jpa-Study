package com.japStudy.ssafyStudy.repository;


import com.japStudy.ssafyStudy.domain.item.Item;
import java.util.List;

public interface IItemRepository {
    void save(Item item);
    Item findOne(Long id);
    List<Item> findAll();
}
