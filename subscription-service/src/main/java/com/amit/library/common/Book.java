package com.amit.library.common;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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