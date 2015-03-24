package ar.edu.uai.paradigms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ar.edu.uai.paradigms.dto.PersonDTO;
import ar.edu.uai.paradigms.service.PersonService;
import ar.edu.uai.paradigms.translator.PersonTranslator;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */

@Controller
@RequestMapping("/persons")
public class PersonController {

	public PersonController(
			PersonService personService,
			PersonTranslator personTranslator) {
		super();
		this.personService = personService;
		this.personTranslator = personTranslator;
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PersonController.class);

	private PersonService personService;

	private PersonTranslator personTranslator;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
		LOGGER.debug("Received DTO: " + personDTO);
		return this.personTranslator.translateToDTO(this.personService
                .savePerson(this.personTranslator.translate(personDTO)));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
	public @ResponseBody PersonDTO getPerson(@PathVariable String identifier) {
		return this.personTranslator.translateToDTO(this.personService.retrievePerson(identifier));
	}
}