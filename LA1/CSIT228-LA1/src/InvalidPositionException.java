public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(int num) {

        super("Position must be between 1 and " + num);
    }
}
