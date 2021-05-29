package com.amit.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.amit.demo.model9.Alian;



public interface AlianRepo extends JpaRepository<Alian , Integer> {
	
//	List<Alian> findByTech(String tech);
//	
//	 List<Alian>  findByAidGreaterThan(int aid);
//	 
	// @Query("from alian where tech=?1 order by aname")
	// List<Alian >findByTechSorted(String tech);

}
