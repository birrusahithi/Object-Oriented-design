import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Stack<K> implements StackImplementation<K>{
    Deque<K> deque = new ArrayDeque<>();
    @Override
    public void push(K insert) {
       deque.addFirst(insert);
    }

    @Override
    public K pop() {
       return deque.removeFirst();
    }

    @Override
    public K peek() {
        K peek = deque.peekFirst();
        return peek;
    }

    @Override
    public boolean isitEMpty() {
        if(deque.size()<1){
            return true;
        }
        return false;
    }
}
