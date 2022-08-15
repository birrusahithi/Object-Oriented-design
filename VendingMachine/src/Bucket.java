public class Bucket <D1, D2>{
    private D1 first;
    private D2 second;
    Bucket(D1 f, D2 sec){
        this.first = f;
        this.second=sec;
    }
    public D2 getSecond(){
        return second;
    }
    public D1 getFirst(){
        return first;
    }
}
