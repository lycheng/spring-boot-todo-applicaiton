package me.lycheng.todoapp.todo.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(int id) {
        super(String.format("Item not found: id=%d", id));
    }
}
