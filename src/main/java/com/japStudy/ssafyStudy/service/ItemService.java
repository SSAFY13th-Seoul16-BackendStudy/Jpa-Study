package com.japStudy.ssafyStudy.service;

import com.japStudy.ssafyStudy.domain.item.Item;
import com.japStudy.ssafyStudy.repository.IItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService implements IItemService {
    private final IItemRepository itemRepository;

    @Override
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    @Override
    @Transactional
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
