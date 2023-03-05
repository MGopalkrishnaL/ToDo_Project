package com.Geekster.ToDo_Project.dao;

import com.Geekster.ToDo_Project.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepo extends JpaRepository<Todo,Integer> {
}
