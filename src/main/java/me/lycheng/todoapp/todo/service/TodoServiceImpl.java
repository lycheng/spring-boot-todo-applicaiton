package me.lycheng.todoapp.todo.service;

import me.lycheng.todoapp.todo.entity.Item;
import me.lycheng.todoapp.todo.mapper.ItemMapper;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import me.lycheng.todoapp.todo.rest.NewItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    ItemMapper mapper;

    @Override
    public List<Item> allItems() {
        return mapper.selectList(null);
    }

    @Override
    public ItemResponse newItem(NewItemRequest request) {
        Item item = new Item();
        item.setContent(request.getContent());
        item.setFinished(request.getFinished());
        assert mapper.insert(item) == 1;

        var resp = new ItemResponse();
        resp.setId(item.getId());
        resp.setContent(item.getContent());
        resp.setFinished(item.getFinished());
        resp.setUpdated(item.getUpdated());
        resp.setCreated(item.getCreated());
        return resp;
    }
}
