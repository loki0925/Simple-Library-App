package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
