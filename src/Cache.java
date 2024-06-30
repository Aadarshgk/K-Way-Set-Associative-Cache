public class Cache <T>{
    int set;
    CacheSet<T>[] cache;
    public Cache(int k) {
        cache= new CacheSet[10];
        this.set = 10;

        for(int i=0;i<10;i++){
            cache[i] = new CacheSet<T>(k);
        }
    }

    public void put(Node<T> root) {
        cache[root.block%set].put(root);
    }

    public Node<T> get(Node<T> root) {
        return cache[root.block % set].get(root.key);
    }
}
