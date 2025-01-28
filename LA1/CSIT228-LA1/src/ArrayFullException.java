public class ArrayFullException extends Exception {
    // array full
    public <T> ArrayFullException(T num) {
        super("The array is full and " + num + " cannot be inserted.");
    }
}
