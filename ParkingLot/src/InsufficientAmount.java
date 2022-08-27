public class InsufficientAmount extends RuntimeException{
    String message;
    InsufficientAmount(String m){
        this.message = m;
    }
    public String getMessage(){
        return message;
    }

}
