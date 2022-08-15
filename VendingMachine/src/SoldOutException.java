public class SoldOutException extends RuntimeException{
    private String message;
    SoldOutException(String m){
        this.message= m;

    }
    public String getMessage(){
        return message;
    }
}
