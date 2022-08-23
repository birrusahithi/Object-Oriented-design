import java.util.Objects;

public class HashTable<K, V> {
    int size = 16;
    Map<K, V>[] array = new Map[size];

    public void put(K key, V value) {
        Map<K, V> entry = new Map<>(key, value);
        int index = calculateIndex(key);
        if(array[index]==null){
            array[index] = entry;
        }else{
            Map<K, V> temp = array[index];
            while(temp!=null){
                if(temp.key.equals(key)){
                    temp.value = value;
                }
                temp = temp.next;
            }
            temp = entry;
        }
    }
    public V get(K key){
        int index = calculateIndex(key);
        if(array[index]==null){
            return null;
        }
        if(array[index].key.equals(key)){
            return array[index].value;
        }
        Map<K, V> check = array[index];
        while(check!=null){
            if(check.key.equals(key)){
                return check.value;
            }
            check = check.next;
        }
        return null;
    }
    public boolean containsKey(K key){
        int index = calculateIndex(key);
        if(array[index]==null){
            return false;
        }
        if(array[index].key.equals(key)){
            return true;
        }
        Map<K, V> contains = array[index];
        while(contains!=null){
            if(contains.key.equals(key)){
                return true;
            }
            contains = contains.next;
        }
        return false;
    }
    public boolean remove(K key){
        int index = calculateIndex(key);
        if(array[index]==null){
            return false;
        }
        if(array[index]!=null && array[index].key.equals(key)){
            array[index] = array[index].next;
        }
        Map<K, V> current = array[index];
        Map<K, V> prev = array[index];
        while(current!=null){
            if(current.key.equals(key)){
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;

        }
        return false;
    }

    public static void main(String[] args) {

    }

    public int calculateIndex(K key) {
        int a = Objects.hashCode(key);
        int index;
        if (a > 0) {
            index = a % size;
        } else {
            index = -a % size;
        }
        return index;
    }

}
