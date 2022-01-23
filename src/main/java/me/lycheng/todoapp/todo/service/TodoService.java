package me.lycheng.todoapp.todo.service;

import me.lycheng.todoapp.todo.entity.Item;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import me.lycheng.todoapp.todo.rest.NewItemRequest;

import java.util.List;

public interface TodoService {
    List<Item> allItems();

    ItemResponse newItem(NewItemRequest request);
}
