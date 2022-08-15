public class NotFullPaidException extends RuntimeException {
    String message;
    long remaining;
   public NotFullPaidException(String m, long r){
        this.message=m;
        this.remaining=r;
    }

    @Override
    public String getMessage(){
        return message + remaining;
    }
    public long getRemaining(){
        return remaining;
    }
}
