package me.lycheng.todoapp.todo.service;

import me.lycheng.todoapp.todo.model.Item;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StructMapper {

    ItemResponse itemToResponse(Item item);
}
