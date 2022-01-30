package me.lycheng.todoapp.todo.service;

import me.lycheng.todoapp.todo.rest.DelItemResponse;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import me.lycheng.todoapp.todo.rest.ItemRequest;

import java.util.List;

public interface TodoService {
    List<ItemResponse> allItems();

    ItemResponse newItem(ItemRequest request);

    ItemResponse getItem(int id);

    DelItemResponse delItem(int id);

    ItemResponse putItem(int id, ItemRequest request);
}
