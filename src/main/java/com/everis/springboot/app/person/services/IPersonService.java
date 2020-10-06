package com.everis.springboot.app.person.services;

import com.everis.springboot.app.person.entity.Person;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface IPersonService {
	//public List<Person> findAll();
	public Observable<Person> findAll();
	public Person findByID(Long id);
	//public Person findByDni(Integer dni);
	public Maybe<Person> findByDni(Integer dni);
}
