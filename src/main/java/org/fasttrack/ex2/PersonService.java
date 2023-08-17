package org.fasttrack.ex2;

import java.util.*;

public class PersonService {
    private List<Person> persons = new ArrayList<>();
    private int nextId = 1;

    public Person addPerson(Person person) {
        if (person.getName() == null || person.getAge() <= 0 || person.getAge() >= 120) {
            throw new IllegalArgumentException("Invalid person data");
        }

        Person newPerson = new Person(nextId++, person.getName(), person.getAge());
        persons.add(newPerson);
        return newPerson;
    }

    public Person removePerson(int id) {
        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
            Person person = iterator.next();
            if (person.getId() == id) {
                iterator.remove();
                return person;
            }
        }
        throw new NoSuchElementException("Person not found");
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age <= 0 || age >= 120) {
            throw new IllegalArgumentException("Invalid age");
        }

        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }

    public List<String> getAllPersonNames() {
        List<String> names = new ArrayList<>();
        for (Person person : persons) {
            names.add(person.getName());
        }
        return names;
    }

    public Person getPerson(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }


}
