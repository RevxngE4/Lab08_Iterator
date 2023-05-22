import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SportsTeam implements Iterable<Person> {
    private List<Person> people;

    public SportsTeam() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void removePerson(Person person) {
        people.removeIf(p -> p.getName().equals(person.getName()));
    }

    public Iterator<Person> iterator() {
        return people.iterator();
    }
}

  class Main1 {
      public static void main(String[] args) {
          Person[] peopleArray = new Person[3];
          peopleArray[0] = new Person("Camilo", 24);
          peopleArray[1] = new Person("Andres", 34);
          peopleArray[2] = new Person("Felipe", 12);

          TrainingGroup trainingGroup = new TrainingGroup(peopleArray);

          System.out.println("Training Group:");
          Iterator<Person> trainingGroupIterator = trainingGroup.iterator();
          while (trainingGroupIterator.hasNext()) {
              Person person = trainingGroupIterator.next();
              System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
          }

          SportsTeam sportsTeam = new SportsTeam();
          sportsTeam.addPerson(new Person("Carlitos", 31));
          sportsTeam.addPerson(new Person("Carla", 23));

          System.out.println("\nSports Team:");
          for (Person person : sportsTeam) {
              System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
          }

          increaseAge(sportsTeam);

          System.out.println("\nSports Team after:");
          for (Person person : sportsTeam) {
              System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
          }

          Person personToRemove = new Person("Mike", 32);
          sportsTeam.removePerson(personToRemove);

          System.out.println("\nSports Team after removing a person:");
          for (Person person : sportsTeam) {
              System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
          }
      }

      private static void increaseAge(SportsTeam sportsTeam) {
          for (Person person : sportsTeam) {
              person.increaseAge();
          }
      }

  }
