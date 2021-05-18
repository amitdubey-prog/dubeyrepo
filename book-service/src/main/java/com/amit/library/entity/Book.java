package com.amit.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BOOK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	private int  bookId;
	
	
	private String name;
	private String author;
	private int copiesAvailable ;
	private int totalCopies;
}
