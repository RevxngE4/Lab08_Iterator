import java.util.Arrays;
import java.util.Iterator;

public class Java implements Iterable<Object> {
    private int integer1;
    private int integer2;
    private int[] integerArray;
    private char character;

    public Java(int integer1, int integer2, int[] integerArray, char character) {
        this.integer1 = integer1;
        this.integer2 = integer2;
        this.integerArray = integerArray;
        this.character = character;
    }

    public Iterator<Object> iterator() {
        return new FieldsIterator();
    }

    public Iterator<Object> charFirstIterator() {
        return new CharFirstIterator();
    }

    public Iterator<Object> oddIndexFirstIterator() {
        return new OddIndexFirstIterator();
    }

    private class FieldsIterator implements Iterator<Object> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < 4;
        }

        @Override
        public Object next() {
            Object value = null;
            switch (currentIndex) {
                case 0:
                    value = integer1;
                    break;
                case 1:
                    value = integer2;
                    break;
                case 2:
                    value = Arrays.toString(integerArray);
                    break;
                case 3:
                    value = character;
                    break;
            }
            currentIndex++;
            return value;
        }
    }

    private class CharFirstIterator implements Iterator<Object> {
        private int arrayIndex = 0;
        private int arrayLength = integerArray.length;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < (arrayLength + 3);
        }

        @Override
        public Object next() {
            Object value = null;
            if (currentIndex == 0) {
                value = character;
            } else if (currentIndex <= arrayLength) {
                value = integerArray[currentIndex - 1];
            } else if (currentIndex == (arrayLength + 1)) {
                value = integer1;
            } else if (currentIndex == (arrayLength + 2)) {
                value = integer2;
            }
            currentIndex++;
            return value;
        }
    }

    private class OddIndexFirstIterator implements Iterator<Object> {
        private int arrayIndex = 0;
        private int arrayLength = integerArray.length;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < (arrayLength + 3);
        }

        @Override
        public Object next() {
            Object value = null;
            if (currentIndex % 2 == 0) {
                value = integerArray[arrayIndex];
                arrayIndex += 2;
                if (arrayIndex >= arrayLength) {
                    arrayIndex = 1;
                }
            } else {
                switch (currentIndex) {
                    case 1:
                        value = integer1;
                        break;
                    case 3:
                        value = character;
                        break;
                    case 5:
                        value = integer2;
                        break;
                }
            }
            currentIndex++;
            return value;
        }
    }
}

 class Main2 {
     public static void main(String[] args) {
         int integer1 = 45;
         int integer2 = 50;
         int[] integerArray = {5, 6, 7, 8, 9};
         char character = 'C';

         Java javaObject = new Java(integer1, integer2, integerArray, character);

         System.out.println("Fields Iterator:");
         Iterator<Object> fieldsIterator = javaObject.iterator();
         while (fieldsIterator.hasNext()) {
             Object value = fieldsIterator.next();
             System.out.println(value);
         }

         System.out.println("\nChar First Iterator:");
         Iterator<Object> charFirstIterator = javaObject.charFirstIterator();
         while (charFirstIterator.hasNext()) {
             Object value = charFirstIterator.next();
             System.out.println(value);
         }

         System.out.println("\nOdd Index First Iterator:");
         Iterator<Object> oddIndexFirstIterator = javaObject.oddIndexFirstIterator();
         while (oddIndexFirstIterator.hasNext()) {
             Object value = oddIndexFirstIterator.next();
             System.out.println(value);
         }
     }
}
