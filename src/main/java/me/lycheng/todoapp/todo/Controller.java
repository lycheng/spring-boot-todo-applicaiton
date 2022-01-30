package me.lycheng.todoapp.todo;

import me.lycheng.todoapp.todo.model.Item;
import me.lycheng.todoapp.todo.rest.DelItemResponse;
import me.lycheng.todoapp.todo.rest.ItemRequest;
import me.lycheng.todoapp.todo.rest.ItemResponse;
import me.lycheng.todoapp.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class Controller {

    @Autowired
    private TodoService svc;

    @GetMapping("")
    public List<ItemResponse> getAllItems() {
        return svc.allItems();
    }

    @PostMapping("")
    public ItemResponse newItem(@Valid @RequestBody ItemRequest request) {
        return svc.newItem(request);
    }

    @GetMapping("/{id}")
    public ItemResponse getItem(@Valid @NotNull @PathVariable int id) {
        var resp = svc.getItem(id);
        if (resp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found", null);
        }
        return resp;
    }

    @DeleteMapping("/{id}")
    public DelItemResponse delItem(@Valid @NotNull @PathVariable int id) {
        var resp = svc.delItem(id);
        if (resp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found", null);
        }
        return resp;
    }

    @PutMapping("/{id}")
    public ItemResponse putItem(@Valid @NotNull @PathVariable int id, @Valid @RequestBody ItemRequest request) {
        var resp = svc.putItem(id, request);
        if (resp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found", null);
        }
        return resp;
    }
}
