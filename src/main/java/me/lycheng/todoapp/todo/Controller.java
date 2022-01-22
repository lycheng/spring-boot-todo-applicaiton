package me.lycheng.todoapp.todo;

import me.lycheng.todoapp.todo.model.Item;
import me.lycheng.todoapp.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
