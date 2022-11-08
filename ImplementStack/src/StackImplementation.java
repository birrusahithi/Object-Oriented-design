public interface StackImplementation<K> {
    public void push(K insert);
    public K pop();
    public K peek();
    boolean isitEMpty();

}
