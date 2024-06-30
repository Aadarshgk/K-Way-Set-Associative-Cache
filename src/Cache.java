import java.util.ArrayList;
import java.util.List;

public class Cache <T>{
    int set;
    List<CacheSet<T>> cache;
    public Cache(int k) {
        cache= new ArrayList<>();
        this.set = 10;

        for(int i=0;i<10;i++){
            cache.add(0,new CacheSet<>(k));
        }
    }

    public void put(Node<T> root) {
        cache.get((root.block)%set).putBlock(root);
    }

    public Node<T> get(Node<T> root) {
        return cache.get((root.block)%set).getBlock(root.key);
    }
}
