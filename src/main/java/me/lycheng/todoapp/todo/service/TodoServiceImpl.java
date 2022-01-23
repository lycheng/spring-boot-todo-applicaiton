package me.lycheng.todoapp.todo.service;

import me.lycheng.todoapp.todo.model.Item;
import me.lycheng.todoapp.todo.model.ItemMapper;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import me.lycheng.todoapp.todo.rest.NewItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    ItemMapper mapper;

    @Autowired
    StructMapper structMapper;

    @Override
    public List<Item> allItems() {
        return mapper.selectList(null);
    }

    @Override
    public ItemResponse newItem(NewItemRequest request) {
        Item item = new Item();
        var now = new Date();
        item.setContent(request.getContent());
        item.setFinished(request.getFinished());
        item.setCreated(now);
        item.setUpdated(now);
        mapper.insert(item);

        return structMapper.itemToResponse(item);
    }
}
