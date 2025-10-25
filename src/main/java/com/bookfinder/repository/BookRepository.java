package com.bookfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookfinder.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}