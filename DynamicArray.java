import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private T[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        this.capacity = 10000;
        this.array = (T[]) new Object[this.capacity];
        this.size = 0;
    }

    public boolean add(T element) {
        if (this.size == this.capacity) {
            return false;
        }

        this.array[this.size++] = element;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= this.size) {
            return false;
        }

        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[--this.size] = null;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }

        return this.array[index];
    }

    public boolean set(int index, T value) {
        if (index < 0 || index >= this.size) {
            return false;
        }

        this.array[index] = value;
        return true;
    }

    public T getMax() {
        if (this.size == 0) {
            return null;
        }

        T max = this.array[0];
        for (int i = 1; i < this.size; i++) {
            if (((Comparable<T>) this.array[i]).compareTo(max) > 0) {
                max = this.array[i];
            }
        }

        return max;
    }

    public int getMaxIndex() {
        if (this.size == 0) {
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < this.size; i++) {
            if (((Comparable<T>) this.array[i]).compareTo(this.array[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public T getSecondMax() {
        if (this.size < 2) {
            return null;
        }

        int maxIndex = getMaxIndex();
        int secondMaxIndex = maxIndex == 0 ? 1 : 0;

        for (int i = 0; i < this.size; i++) {
            if (i != maxIndex && ((Comparable<T>) this.array[i]).compareTo(this.array[secondMaxIndex]) > 0) {
                secondMaxIndex = i;
            }
        }

        return this.array[secondMaxIndex];
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator();
    }

    private class DynamicArrayIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            return array[currentIndex++];
        }
    }
}
