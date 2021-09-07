package com.example.Practice.PracticeProject.Repository;

import com.example.Practice.PracticeProject.Model.UserBookMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface UserBookRepository extends JpaRepository<UserBookMapping,Integer> {
}
