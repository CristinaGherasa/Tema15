package org.fasttrack.ex2;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService();

        Person person1 = new Person(0, "Alice", 28);
        Person person2 = new Person(0, "Bob", 35);
        Person person3 = new Person(0, "Jack", 40);
        Person addedPerson1 = personService.addPerson(person1);
        Person addedPerson2 = personService.addPerson(person2);
        Person addedPerson3 = personService.addPerson(person3);

        System.out.println("Added Persons:");
        System.out.println(addedPerson1.getId() + ": " + addedPerson1.getName() + " (" + addedPerson1.getAge()
                + " years)");
        System.out.println(addedPerson2.getId() + ": " + addedPerson2.getName() + " (" + addedPerson2.getAge()
                + " years)");
        System.out.println(addedPerson3.getId() + ": " + addedPerson3.getName() + " (" + addedPerson3.getAge()
                + " years)");

        System.out.println("\nAll Persons:");
        for (Person person : personService.getAllPersons()) {
            System.out.println(person.getId() + ": " + person.getName() + " (" + person.getAge() + " years)");
        }

        System.out.println("\nPersons Older than 30:");
        for (Person person : personService.getPersonsOlderThan(30)) {
            System.out.println(person.getId() + ": " + person.getName() + " (" + person.getAge() + " years)");
        }

        System.out.println("\nAll Person Names:");
        for (String name : personService.getAllPersonNames()) {
            System.out.println(name);
        }

        Person personByName = personService.getPerson("Alice");
        if (personByName != null) {
            System.out.println("\nPerson Found by Name:");
            System.out.println(personByName.getId() + ": " + personByName.getName() + " (" + personByName.getAge() + " years)");
        } else {
            System.out.println("\nPerson Not Found by Name");
        }

        Person personById = personService.getPersonById(1);
        if (personById != null) {
            System.out.println("\nPerson Found by ID:");
            System.out.println(personById.getId() + ": " + personById.getName() + " (" + personById.getAge() + " years)");
        } else {
            System.out.println("\nPerson Not Found by ID");
        }

        try {
            Person removedPerson = personService.removePerson(1);
            System.out.println("\nRemoved Person:");
            System.out.println(removedPerson.getId() + ": " + removedPerson.getName() + " (" + removedPerson.getAge() + " years)");
        } catch (Exception e) {
            System.out.println("\nFailed to Remove Person: " + e.getMessage());
        }
    }
}
