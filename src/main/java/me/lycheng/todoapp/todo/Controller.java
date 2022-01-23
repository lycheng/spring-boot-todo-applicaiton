package me.lycheng.todoapp.todo;

import me.lycheng.todoapp.todo.model.Item;
import me.lycheng.todoapp.todo.rest.NewItemRequest;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import me.lycheng.todoapp.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class Controller {

    @Autowired
    private TodoService svc;

    @GetMapping("")
    public List<Item> getAllItems() {
        return svc.allItems();
    }

    @PostMapping("")
    public ItemResponse newItem(@Valid @RequestBody NewItemRequest request) {
        return svc.newItem(request);
    }
}
