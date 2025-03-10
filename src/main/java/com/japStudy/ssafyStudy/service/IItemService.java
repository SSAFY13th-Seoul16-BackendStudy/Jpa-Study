package com.japStudy.ssafyStudy.service;

import com.japStudy.ssafyStudy.domain.item.Item;
import java.util.List;

public interface IItemService {
    void saveItem(Item item);
    void updateItem(Long itemId, String name, int price , int stockQuantity);
    List<Item> findItems();
    Item findOne(Long itemId);
}
