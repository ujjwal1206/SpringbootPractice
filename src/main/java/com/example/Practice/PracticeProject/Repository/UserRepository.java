package com.example.Practice.PracticeProject.Repository;

import com.example.Practice.PracticeProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
