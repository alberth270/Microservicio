package com.everis.springboot.app.person.dao;


import org.springframework.data.repository.CrudRepository;

import com.everis.springboot.app.person.entity.Person;


public interface Persondao extends CrudRepository<Person, Long>{

}
