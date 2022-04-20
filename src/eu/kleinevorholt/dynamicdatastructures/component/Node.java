package eu.kleinevorholt.dynamicdatastructures.component;

public class Node<E> {

    private E content;
    private Node<E> next;
    private Node<E> prev;


    public Node(E pObject) {
        content = pObject;
    }

    public void setContent(E content)
    {
        this.content = content;
    }

    public E getContent()
    {
        return content;
    }

    public Node<E> getNext()
    {
        return next;
    }

    public Node<E> getPrev()
    {
        return prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
