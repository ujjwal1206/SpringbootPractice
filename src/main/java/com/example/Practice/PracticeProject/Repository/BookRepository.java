package com.example.Practice.PracticeProject.Repository;
import com.example.Practice.PracticeProject.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
