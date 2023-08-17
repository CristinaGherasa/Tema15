package org.fastrack.ex2;

import org.fasttrack.ex2.Person;
import org.fasttrack.ex2.PersonService;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    @Test
    public void testAddValidPerson() {
        PersonService service = new PersonService();
        Person person = new Person(0, "John", 30);
        Person addedPerson = service.addPerson(person);
        assertEquals(1, addedPerson.getId());
        assertEquals("John", addedPerson.getName());
        assertEquals(30, addedPerson.getAge());
    }

    @Test
    public void testAddInvalidPerson() {
        PersonService service = new PersonService();
        Person invalidPerson = new Person(0, null, -5);
        assertThrows(IllegalArgumentException.class, () -> service.addPerson(invalidPerson));
    }


    @Test
    public void testRemoveExistingPerson() {
        PersonService service = new PersonService();
        Person person = new Person(0, "Jane", 25);
        service.addPerson(person);
        Person removedPerson = service.removePerson(1);
        assertEquals("Jane", removedPerson.getName());
    }

    @Test
    public void testRemoveNonExistingPerson() {
        PersonService service = new PersonService();
        assertThrows(NoSuchElementException.class, () -> service.removePerson(1));
    }

    @Test
    public void testGetAllPersons() {
        PersonService service = new PersonService();
        service.addPerson(new Person(0, "Alice", 28));
        service.addPerson(new Person(0, "Bob", 35));
        assertEquals(2, service.getAllPersons().size());
    }

    @Test
    public void testGetPersonsOlderThan() {
        PersonService service = new PersonService();
        service.addPerson(new Person(0, "Eve", 22));
        service.addPerson(new Person(0, "Daniel", 30));
        service.addPerson(new Person(0, "Grace", 42));
        assertEquals(2, service.getPersonsOlderThan(25).size());
    }

    @Test
    public void testGetPersonsOlderThanInvalidAge() {
        PersonService service = new PersonService();
        assertThrows(IllegalArgumentException.class, () -> service.getPersonsOlderThan(-5));
        assertThrows(IllegalArgumentException.class, () -> service.getPersonsOlderThan(150));
    }

    @Test
    public void testGetAllPersonNames() {
        PersonService service = new PersonService();
        service.addPerson(new Person(0, "Carol", 27));
        service.addPerson(new Person(0, "Frank", 39));
        assertTrue(service.getAllPersonNames().contains("Carol"));
        assertTrue(service.getAllPersonNames().contains("Frank"));
    }

    @Test
    public void testGetPersonByName() {
        PersonService service = new PersonService();
        service.addPerson(new Person(0, "Grace", 30));
        service.addPerson(new Person(0, "John", 45));
        Person person = service.getPerson("Grace");
        assertNotNull(person);
        assertEquals("Grace", person.getName());
    }

    @Test
    public void testGetPersonById() {
        PersonService service = new PersonService();
        Person person = new Person(0, "Sam", 28);
        service.addPerson(person);
        Person retrievedPerson = service.getPersonById(1);
        assertEquals("Sam", retrievedPerson.getName());
    }

    @Test
    public void testGetPersonByNameNotFound() {
        PersonService service = new PersonService();
        assertNull(service.getPerson("NonExistentName"));
    }

    @Test
    public void testGetPersonByIdNotFound() {
        PersonService service = new PersonService();
        assertNull(service.getPersonById(1));
    }
}
