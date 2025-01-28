public class MyArrayList {
    private int capacity = 5;
    private int size = 0;
    private int[] array = new int[capacity];

    public MyArrayList() {}

    public void add(int num) throws ArrayFullException {

        try {
            array[size++] = num;
        } catch (ArrayIndexOutOfBoundsException e) {
            size--;
            throw new ArrayFullException("The array is full and " + num + " cannot be inserted.");
        }

    }
    public void addAt(int num, int pos) throws ArrayFullException, InvalidPositionException {

        if (size == capacity) {
            throw new ArrayFullException("The array is full and " + num + " cannot be inserted.");
        }

        if (pos < 1 || pos > size +1) {
            throw new InvalidPositionException("Position must be between 1 and " + capacity);
        }

        for (int i = size; i > pos -1; i--) {
            array[i] = array[i -1];
        }
        array[pos -1] = num;
        size++;
    }

    public boolean remove(int num) {

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
    public int removeAt(int pos) throws InvalidPositionException {

        if (pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        int ret = array[pos -1];

        for (int i = pos -1; i < size -1; i++) {
            array[i] = array[i +1];
        }
        size--;
        return ret;
    }
    public boolean contains(int num) {

        for (int n : array) {
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
    public int get(int pos) throws InvalidPositionException {

        if (pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }
        return array[pos -1];
    }
    public int set(int pos, int num) throws InvalidPositionException {

        if (pos < 1 || pos > size) {
            throw new InvalidPositionException("Position must be between 1 and " + size);
        }

        int ret = array[pos -1];
        array[pos -1] = num;

        return ret;
    }
}
