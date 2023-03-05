package com.Geekster.ToDo_Project.service;

import com.Geekster.ToDo_Project.dao.ITodoRepo;
import com.Geekster.ToDo_Project.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    ITodoRepo todoRepo;

    public ResponseEntity<String> getall() {
        List<Todo> list =  todoRepo.findAll();
        return new ResponseEntity<>( "List of Todos \n"+list,HttpStatus.ACCEPTED);
    }
    public ResponseEntity getTodo(Integer id){
        Todo todo = todoRepo.findById(id).get();
        return new ResponseEntity<>("Todo Details"+todo,HttpStatus.OK);
    }
    public ResponseEntity create(Todo todo){
        todoRepo.save(todo);
        return new ResponseEntity<>("Todo has been saved for the user with id "+todo.getUser().getUserId(), HttpStatus.CREATED);

    }

    public ResponseEntity update(Integer id, Todo todo) {

        Todo todo1 = todoRepo.findById(id).get();
        if(todo1==null){
            return new ResponseEntity<>("Todo not found",HttpStatus.NOT_FOUND);
        }
        todo1.setTodoId(todo.getTodoId());
        todo1.setTitle(todo.getTitle());
        todo1.setStatus(todo.getStatus());
        return new ResponseEntity<>("Todo has been Updated successfully",HttpStatus.ACCEPTED);
    }

    public ResponseEntity delete(Integer id) {
        if(todoRepo.findById(id).isPresent()){
            todoRepo.deleteById(id);
            return new ResponseEntity<>("Todo has been deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Todo with the following id has not present",HttpStatus.BAD_REQUEST);
    }
}
