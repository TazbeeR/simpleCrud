package com.example.simpleCRUD.repository;

import com.example.simpleCRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
}
