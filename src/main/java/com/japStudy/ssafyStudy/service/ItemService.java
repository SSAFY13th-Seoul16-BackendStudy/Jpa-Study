package com.japStudy.ssafyStudy.service;

import com.japStudy.ssafyStudy.domain.item.Item;
import com.japStudy.ssafyStudy.repository.IItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {
    private final IItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> findItems() {

        return itemRepository.findAll();
    }

    @Override
    public Item findOne(Long itemId) {

        return itemRepository.findOne(itemId);
    }
}
