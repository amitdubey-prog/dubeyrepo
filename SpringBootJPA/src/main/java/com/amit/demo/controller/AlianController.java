package com.amit.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amit.demo.dao.AlianRepo;
import com.amit.demo.model9.Alian;

@RestController
public class AlianController {

	@Autowired
	AlianRepo repo;

//	@RequestMapping("/")
//	public String home()
//	{
//	
//		return "home.jsp";
//	}

	@PostMapping("/Alians")
	public Alian addalian(@RequestBody Alian alian) {

		repo.save(alian);

		return alian;
	}

	@GetMapping("/Alians")

	public List<Alian> getAlians() {
		return repo.findAll();
	}

	@GetMapping("/Alians/{aid}")

	public Optional<Alian> getAlian(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}

	@DeleteMapping("/Alians/{aid}")

	public String deleteAlian(@PathVariable int aid) {

		Alian a = repo.getOne(aid);

		repo.delete(a);

		return "deleted";
	}

	@PutMapping("/Alians")
	public Alian saveOrupdateAlian(@RequestBody Alian alian) {

		repo.save(alian);

		return alian;
	}

//	public ModelAndView  getAlian(@RequestParam int  aid)
//	{
//		ModelAndView mv = new ModelAndView("showAlian.jsp");
//		Alian alian= repo.findById(aid).orElse(new Alian());
//		
////		System.out.println(repo.findByTech("java"));
////		System.out.println(repo.findByAidGreaterThan(2));
////		//System.out.println(repo.findByTechSorted("java"));
//		mv.addObject(alian);
//	
//	return mv;
//}

}