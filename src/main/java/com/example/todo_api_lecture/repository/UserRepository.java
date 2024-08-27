package com.example.todo_api_lecture.repository;


import com.example.todo_api_lecture.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TbUser, Long> {
    TbUser findByUsername(String username);

}
