package com.Geekster.ToDo_Project.dao;


import com.Geekster.ToDo_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepo extends JpaRepository<User,Integer> {
    @Query(value = "Select * from tbl_user where name = :name",nativeQuery = true)
     List<User> findByName(String name);
    @Query(value = "Select * from tbl_user where email = :email",nativeQuery = true)
      List<User> findByEmail(String email);

//     User findByName(String name);

}
