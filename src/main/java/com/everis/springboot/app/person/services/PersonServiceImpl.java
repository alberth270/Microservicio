package com.everis.springboot.app.person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.springboot.app.person.dao.Persondao;
import com.everis.springboot.app.person.entity.Person;

import io.reactivex.Maybe;
import io.reactivex.Observable;

@Service
public class PersonServiceImpl implements IPersonService {
	@Autowired
	private Persondao persondao;
	
	@Override
	@Transactional
	public Observable<Person> findAll() {
		//return (List<Person>) persondao.findAll();
		return Observable.just((List<Person>) persondao.findAll()).flatMapIterable(x->x).onErrorResumeNext(Observable.just(new Person()));
	}
	@Override
	@Transactional
	public Person findByID(Long id) {
		return persondao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Maybe<Person> findByDni(Integer dni) {
		List<Person> listperson = (List<Person>) persondao.findAll();
		/*Optional<Person> person = listperson.stream().filter( p -> p.getDni().intValue() == dni).findFirst();
		return person.orElse(null);*/
		return Observable.just(listperson)
		.flatMapIterable(x->x)
		.filter(p->p.getDni().intValue()==dni).firstElement()
		.onErrorResumeNext(Maybe.just(
			new Person()));
	}
}
