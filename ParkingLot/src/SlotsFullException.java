public class SlotsFullException extends RuntimeException{
    String message;
    SlotsFullException(String m){
        this.message = m;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
