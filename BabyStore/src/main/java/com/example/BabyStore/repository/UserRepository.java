package com.example.BabyStore.repository;

import com.example.BabyStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {
}
