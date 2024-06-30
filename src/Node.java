public class Node<T> {
    T key;
    T data;
    Integer block;
    Node<T> next;
    Node<T> prev;

    public Node(T key,T data,int block, Node<T> next, Node<T> prev) {
        this.key = key;
        this.data = data;
        this.block = block;
        this.next = next;
        this.prev = prev;
    }

    public Node() {
        this.key = null;
        this.data = null;
        this.block=null;
        this.next = null;
        this.prev = null;
    }
}
