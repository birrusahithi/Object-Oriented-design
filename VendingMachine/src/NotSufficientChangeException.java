public class NotSufficientChangeException extends RuntimeException{
    String message;
    NotSufficientChangeException(String m){
        this.message= m;

    }
    public String getMessage(){
        return message;
    }
}
