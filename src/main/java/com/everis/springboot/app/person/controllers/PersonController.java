package com.everis.springboot.app.person.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springboot.app.person.entity.Person;
import com.everis.springboot.app.person.services.IPersonService;

import io.reactivex.Maybe;
import io.reactivex.Observable;


@RestController
@RequestMapping("/Person")
public class PersonController {
	@Autowired
	private IPersonService personService;
	
	@GetMapping("/listar")
	public Observable<Person> getAll() throws Exception{
		return personService.findAll();
	}
	@GetMapping("/info/id/{id}")
	public Person detalle(@PathVariable Long id) throws Exception {
		Person person = personService.findByID(id);
		return person;
	}
	@GetMapping("/info/{dni}")
	public Maybe<Person> detalle(@PathVariable Integer dni) throws Exception {
		Maybe<Person> person = personService.findByDni(dni);
		return person;
	}
}
