import java.util.Iterator;

public class TrainingGroup {
    private Person[] people;

    public TrainingGroup(Person[] people) {
        this.people = people;
    }

    public Iterator<Person> iterator() {
        return new TrainingGroupIterator();
    }

    private class TrainingGroupIterator implements Iterator<Person> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < people.length;
        }

        @Override
        public Person next() {
            return people[currentIndex++];
        }
    }
}
