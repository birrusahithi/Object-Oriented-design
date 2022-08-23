public class Map<K, V>{
    K key;
    V value;
    Map<K, V> next;
    Map(K keys, V values){
        this.key = keys;
        this.value = values;
        this.next = null;
    }
}