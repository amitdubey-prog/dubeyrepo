package com.amit.library.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.amit.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	

}
