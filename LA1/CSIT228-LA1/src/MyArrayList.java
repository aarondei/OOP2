public class MyArrayList<T> {
    private int capacity = 5;
    private int size = 0;
    private T[] array = (T[]) new Object[capacity];

    public MyArrayList() {}

    public void add(T num) throws ArrayFullException {

        try {
            array[size++] = num;
        } catch (ArrayIndexOutOfBoundsException e) {
            size--;
            throw new ArrayFullException(num);
        }

    }
    public void addAt(T num, int pos) throws ArrayFullException, InvalidPositionException {

        if (size == capacity) {
            throw new ArrayFullException(num);
        }

        if (pos < 1 || pos > size +1) {
            throw new InvalidPositionException(size +1);
        }

        for (int i = size; i > pos -1; i--) {
            array[i] = array[i -1];
        }
        array[pos -1] = num;
        size++;
    }

    public boolean remove(T num) {

        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
                for (int j = i; j < size -1; j++) {
                    array[j] = array[j +1];
                }
                size--;
                return true;
            }
        }
        return false;
    }
    public T removeAt(int pos) throws InvalidPositionException {

        if (pos < 1 || pos > size) {
            throw new InvalidPositionException(size);
        }

        T ret = array[pos -1];

        for (int i = pos -1; i < size -1; i++) {
            array[i] = array[i +1];
        }
        size--;
        return ret;
    }
    public boolean contains(T num) {

        for (T n : array) {
            if (num == n) {
                return true;
            }
        }

        return false;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public T get(int pos) throws InvalidPositionException {

        if (pos < 1 || pos > size) {
            throw new InvalidPositionException(size);
        }
        return array[pos -1];
    }
    public T set(int pos, T num) throws InvalidPositionException {

        if (pos < 1 || pos > size) {
            throw new InvalidPositionException(size);
        }

        T ret = array[pos -1];
        array[pos -1] = num;

        return ret;
    }

    public <V, U> void print(V v, U u) {

        for (T i : array) {
            System.out.println(v + " " + i + " " + u);
        }
    }
}
