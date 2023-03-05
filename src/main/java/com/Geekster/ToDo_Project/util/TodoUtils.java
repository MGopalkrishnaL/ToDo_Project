package com.Geekster.ToDo_Project.util;

import com.Geekster.ToDo_Project.model.Todo;
import com.Geekster.ToDo_Project.model.User;
import org.json.JSONObject;

public class TodoUtils {
    public Todo StringToTodo(String Tododetails){
        JSONObject json = new JSONObject(Tododetails);
        Todo  todo = new Todo();
        todo.setTodoId(json.getInt("todoId"));
        todo.setTitle(json.getString("title"));
        todo.setStatus(json.getString("status"));
        User user = new User();
        user.setUserId(json.getInt("userId"));
        user.setName(json.getString("name"));
        user.setEmail(json.getString("email"));
        todo.setUser(user);
        return todo;
    }
}
