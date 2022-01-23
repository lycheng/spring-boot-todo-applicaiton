package me.lycheng.todoapp.todo.service;

import me.lycheng.todoapp.todo.model.Item;
import me.lycheng.todoapp.todo.model.ItemMapper;
import me.lycheng.todoapp.todo.rest.DelItemResponse;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import me.lycheng.todoapp.todo.rest.ItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    ItemMapper mapper;

    @Autowired
    StructMapper structMapper;

    @Override
    public List<ItemResponse> allItems() {
        return mapper.selectList(null).stream().
                map(structMapper::itemToResponse).
                collect(Collectors.toList());
    }

    @Override
    public ItemResponse newItem(ItemRequest request) {
        var item = new Item();
        var now = new Date();
        item.setContent(request.getContent());
        item.setFinished(request.getFinished());
        item.setCreated(now);
        item.setUpdated(now);
        // TODO: check insert error
        mapper.insert(item);

        return structMapper.itemToResponse(item);
    }

    @Override
    public ItemResponse getItem(int id) {
        var item = mapper.selectById(id);
        if (item == null) {
            return null;
        }
        return structMapper.itemToResponse(item);
    }

    @Override
    public DelItemResponse delItem(int id) {
        int rv = mapper.deleteById(id);
        if (rv == 0) {
            return null;
        }
        var resp = new DelItemResponse();
        resp.setId(id);
        resp.setUpdated(new Date());
        return resp;
    }

    @Override
    public ItemResponse putItem(int id, ItemRequest request) {
        var item = mapper.selectById(id);
        if (item == null) {
            return null;
        }

        item.setUpdated(new Date());
        item.setContent(request.getContent());
        item.setFinished(request.getFinished());
        // TODO: check update failed
        mapper.updateById(item);
        return structMapper.itemToResponse(item);
    }
}
