package ar.edu.uai.paradigms.translator;

import ar.edu.uai.model.Person;
import ar.edu.uai.paradigms.dto.PersonDTO;

public class PersonTranslator {

	public Person translate(PersonDTO personDTO) {
		return new Person(personDTO.getName(),	personDTO.getAge());
	}

	public PersonDTO translateToDTO(Person person) {
		return new PersonDTO(person.getName(), person.getAge());
	}
}
