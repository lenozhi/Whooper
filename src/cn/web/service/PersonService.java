package cn.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.web.domain.Person;

/**
 * 注意这个只是�?��临时数据用于显示.
 * 
 * @author liukai
 * 
 */
@Service("personService")
@Transactional
public class PersonService {

	protected static Logger logger = Logger.getLogger("service");

	private HashMap<Integer, Person> database = new HashMap<Integer, Person>();

	/**
	 * Initialize a list of persons
	 */
	private void init() {
		// New person
		Person person = new Person();
		person.setId(1);
		person.setFirstName("John");
		person.setLastName("Smith");
		person.setCurrency("Dollar");
		person.setMoney(1500.00);

		// Add to list
		database.put(1, person);

		// New person
		person = new Person();
		person.setId(2);
		person.setFirstName("Jane");
		person.setLastName("Adams");
		person.setCurrency("Yen");
		person.setMoney(1000.00);

		// Add to list
		database.put(2, person);

		// New person
		person = new Person();
		person.setId(3);
		person.setFirstName("Mike");
		person.setLastName("Polaski");
		person.setCurrency("Euro");
		person.setMoney(2000.00);

		// Add to list
		database.put(3, person);
	}

	public PersonService() {
		// Initialize dummy database
		init();
	}

	/**
	 * �?���?���?persons
	 */
	public List<Person> getAll() {
		logger.debug("Retrieving all persons");

		// Initialize our array
		List<Person> persons = new ArrayList<Person>();

		// Iterate the database
		for (Map.Entry<Integer, Person> entry : database.entrySet()) {
			persons.add(entry.getValue());
		}

		// Return all persons
		return persons;
	}

	/**
	 * 根据ID获得对应的Perosn
	 */
	public Person get(Integer id) {
		logger.debug("Retrieving person based on his id");
		return database.get(id);
	}

	/**
	 * 修改Person
	 */
	public void edit(Person person) {
		logger.debug("Editing existing person");

		// Note this is not the best way to update a data!

		// Delete existing user
		database.remove(person.getId());
		// Add updated user
		database.put(person.getId(), person);
	}

}
