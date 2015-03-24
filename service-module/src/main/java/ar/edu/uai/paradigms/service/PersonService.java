package ar.edu.uai.paradigms.service;
import ar.edu.uai.model.Person;


public interface PersonService {

	public Person savePerson(Person person);

    public Person retrievePerson(String identifier);
}
