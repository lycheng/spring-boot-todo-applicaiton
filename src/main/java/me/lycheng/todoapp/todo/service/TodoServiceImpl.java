package me.lycheng.todoapp.todo.service;

import me.lycheng.todoapp.todo.model.Item;
import me.lycheng.todoapp.todo.model.ItemMapper;
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
}
