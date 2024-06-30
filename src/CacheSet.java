import java.util.HashMap;

public class CacheSet<T> {

    Node<T> head;
    Node<T> tail;

    int capacity;
    int len=0;

    HashMap<T, Node<T>> map;

    public CacheSet(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node<>();
        tail = new Node<>();
    }

    public void put(Node<T> root) {
        if (map.containsKey(root.key)) {
            delNode(root);
            addNode(root);
        } else {
            if (len == capacity) {
                delNode(tail.prev);
            }
            addNode(root);
        }
    }

    public Node<T> get(T key) {
        if (map.containsKey(key)) {
            Node<T> root = map.get(key);
            delNode(root);
            addNode(root);
            return root;
        }
        return null;
    }

    public void addNode(Node<T> root) {
        map.put(root.key, root);
        root.next = head.next;
        root.prev = head;
        head.next = root;
        root.next.prev = root;
        len++;
    }

    public void delNode(Node<T> root) {
        map.remove(root.key);
        root.next.prev= root.prev;
        root.prev.next=root.next;
        len--;
    }
}
