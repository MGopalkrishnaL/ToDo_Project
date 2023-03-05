package com.Geekster.ToDo_Project.controller;

import com.Geekster.ToDo_Project.model.Todo;
import com.Geekster.ToDo_Project.service.TodoService;
import com.Geekster.ToDo_Project.util.TodoUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/todo")
public class TodoController {
    @Autowired
    TodoService todoService;
    @Autowired
    TodoUtils todoUtils;
    @GetMapping(value = "/gettodosall")
    public ResponseEntity<String> getallTodos(){
        return todoService.getall();
    }
    @PostMapping(value = "/createTodo")
    public ResponseEntity createTodo( @Valid @RequestBody String todo){
        Todo todo1 = todoUtils.StringToTodo(todo);
        return todoService.create(todo1);
    }
    @PutMapping(value = "/updateTodo/{id}")
    public ResponseEntity updateTodo(@RequestBody String todo, @PathVariable Integer id){
        Todo todo1 = todoUtils.StringToTodo(todo);
        return todoService.update(id,todo1);
    }
    @DeleteMapping(value = "/deleteTodo/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id){
        return todoService.delete(id);
    }
    @GetMapping(value = "/getTodoById/{id}")
    public ResponseEntity gettodo(@PathVariable Integer id){
        return todoService.getTodo(id);
    }


}
