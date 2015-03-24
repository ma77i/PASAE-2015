package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.Person;
import ar.edu.uai.paradigms.dao.PersonDAO;
import ar.edu.uai.paradigms.service.PersonService;
import org.springframework.transaction.annotation.Transactional;

public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public Person savePerson(Person person) {
		return this.personDAO.create(person);
	}

    @Override
    public Person retrievePerson(String identifier) {
        return this.personDAO.retrieve(identifier);
    }

}
